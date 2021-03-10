FROM openjdk

WORKDIR /spring_sandbox

COPY target/spring_sandbox-0.0.1-SNAPSHOT.jar /spring_sandbox/spring_sandbox.jar

ENTRYPOINT ["java","-Dspring.profiles.active=remote","-jar","spring_sandbox.jar"]