package polimorfismo.aulasclassesabdtratas60;

public class Vendedor extends Funcionario{

    private double totalVendas;

    public Vendedor(String nome, String clt, double salario,double totalVendas) {
        super(nome, clt, salario);
        this.totalVendas=totalVendas;
    }

    @Override
    public void calculaSalario() {
        this.salario = salario + (totalVendas * 0.05);
    }
    
}
