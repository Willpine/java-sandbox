package polimorfismo.aulasclassesabdtratas60;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Funcionario {
    protected String nome;
    protected String clt;
    protected double salario;
    
    public abstract void calculaSalario();

    @Override
    public String toString() {
        return "\nFuncionario [clt=" + clt + ", nome=" + nome + ", salario=" + salario + "]\n";
    }

    protected Funcionario(String nome, String clt, double salario) {
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
    }
}
