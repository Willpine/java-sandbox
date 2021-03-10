package aulasheranca50;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome,String cpf){
        super(nome,cpf);
    }

    @Override
    public void imprime(){
        super.imprime();
        System.out.println("salario: "+this.salario);
        imprimeReciboDePagamento();
    }

    public void imprimeReciboDePagamento() {
        System.out.println("Eu "+super.nome+" recebi "+this.salario);    
    }
}
