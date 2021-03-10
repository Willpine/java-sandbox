package polimorfismo.aulasclassesabdtratas60;

public class Main {
    public static void main(String[] args) {
        // FuncionarioNaoAbstrato funcionario = new FuncionarioNaoAbstrato("Marcus", "20202-2",2000);
        // funcionario.calculaSalario();
        // System.out.println(funcionario);
        Gerente gerente = new Gerente("Anna", "20101-1",2000);
        gerente.calculaSalario();
        System.out.println(gerente);

        Vendedor vendedor = new Vendedor("Harvey", "1231-9", 1500, 5000);
        vendedor.calculaSalario();
        System.out.println(vendedor);
    }
}
