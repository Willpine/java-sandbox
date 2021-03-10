package polimorfismo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Gerente extends Funcionario {

    private double pnl;

    public Gerente(String nome,double salario, double pnl) {
        super(nome, salario);
        this.pnl = pnl;
    }

	@Override
	public void calcularPagamento() {
        this.salario = this.salario + this.pnl;
	}

    
    
}
