package aulasheranca50;

public class App 
{
    public static void main( String[] args )
    {
        Pessoa pessoa = new Pessoa("Bill","Rights");
        pessoa.setCpf("1234");
        Endereco endereco = new Endereco();
        endereco.setBairro("Diva");
        endereco.setRua("rua 25");
        pessoa.setEndereco(endereco);
        pessoa.imprime();
System.out.println("###################");
        Funcionario funcionario = new Funcionario("will","sus");
        Endereco endFuncionario = new Endereco();
        endFuncionario.setBairro("bairro");
        endFuncionario.setRua("rua");
        funcionario.setEndereco(endFuncionario);
        funcionario.imprime();


    }
}
