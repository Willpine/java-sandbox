package polimorfismo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Vendedor extends Funcionario{

    private double totalVendas;

    public Vendedor(String nome,double salario,double totalVendas) {
        super(nome,salario);
        this.totalVendas=totalVendas;
    }

    @Override
    public void calcularPagamento() {
        this.salario = this.salario + (totalVendas * 0.05);
    }
}
