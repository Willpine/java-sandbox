package aulasheranca50;

import lombok.Data;

@Data
public class Pessoa {
    protected String  nome;
    private String  cpf;
    private Endereco endereco;

    public Pessoa (String nome,String cpf){
        this.nome=nome;
        this.cpf=cpf;
    }

    public void imprime(){
        System.out.println("nome: "+this.nome);
        System.out.println("cpf: "+this.cpf);
        System.out.println("end: "+this.endereco.getRua() + endereco.getBairro());
    }
}
