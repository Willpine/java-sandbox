package polimorfismo.aulasclassesabdtratas60;

import lombok.Data;

@Data
public class FuncionarioNaoAbstrato {
    protected String nome;
    protected String clt;
    protected double salario;

    public void calculaSalario() {
        this.salario = salario + (salario * 0.1);
    }

    public FuncionarioNaoAbstrato(String nome, String clt, double salario) {
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "\nFuncionario [clt=" + clt + ", nome=" + nome + ", salario=" + salario + "]\n";
    }

    // Essa classe é uma decisão arquitetural ruim, pois
    // não queremos que existam funcionários genéricos
    // A melhor coisa a se fazer nesse caso é criar
    // uma classe abstrata.
}
