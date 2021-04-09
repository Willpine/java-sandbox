package willpine.batchprocessing;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

// Here we PUT TOGETHER THE ACTUAL BATCH JOB

@Configuration

// Adds beans that save us time, like a
// MEMORY-BASED DATABASE
@EnableBatchProcessing
public class BatchConfiguration {
    
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    // The next three methods define INPUT, PROCESSOR AND OUTPUT
    // All of them are class names.

    // Just looks for a file named sample-data and parses it into a person
    @Bean
    public FlatFileItemReader<Person> reader(){
        return new FlatFileItemReaderBuilder<Person>()
            .name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"firstName", "lastName"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
            }})
            .build();
    }

    // Creates an instance of the PersonItem processor
    // so it will recieve a lower-case Person, and return an upper-case Person.
    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    // Creates an ITEMWRITER.
    // It is automatically assigned to look to the
    // dataSource (In-memory database) created by @EnableBatchProcessing
    // and it includes a sql statement to insert a Person there VIA JAVA BEAN PROPERTIES. 
    @Bean
    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
        .dataSource(dataSource)
        .build();
    }

    // THIS IS THE POINT WHERE THE JOB ITSELF IS BEING CONFIGURED
    
    // This one defines the job. A job is made of steps. Steps are READER+PROCESSOR+WRITER.
    // We need this incrementer cause it uses the DB to maintain execution state in this job definition.
    // Normally, all steps are listed here. Thing is, there is only one in this example.
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1){
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    // Defines a step. Here we are defining how much data we are writting at a atime.
    // In this particular one, it writes up to 10 at a time.
    @Bean
    public Step step1(JdbcBatchItemWriter<Person> writer){
        return stepBuilderFactory.get("step1")
        .<Person, Person> chunk(10) // chunk is a generic method, so it is prefixed with <Person, Person>, representing input and output (ITEMREADER<PERSON> AND ITEMWRITER<PERSON>)
        .reader(reader())
        .processor(processor())
        .writer(writer)
        .build();
    }

}
