package polimorfismo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Funcionario {
    protected String nome;
    protected double salario;
    
    public abstract void calcularPagamento();

    @Override
    public String toString() {
        return "\nFuncionario [nome=" + nome + ", salario=" + salario + "]\n";
    }

    protected Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
}
