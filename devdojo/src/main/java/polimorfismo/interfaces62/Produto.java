package polimorfismo.interfaces62;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Produto implements Tributavel,Transportavel{
    private String nome;
    private double peso;
    private double preco;
    private double precoFinal;
    private double valorFrete;

    @Override
    public void tributavelCalcularImposto() {
        this.precoFinal = this.preco + this.preco*IMPOSTO;
    }

    @Override
    public void calculaFrete() {
        this.valorFrete = this.preco/peso*0.1;
    }

    public Produto(String nome, double peso, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nProduto [nome=" + nome + ", peso=" + peso + ", preco=" + preco + ", precoFinal=" + precoFinal
                + ", valorFrete=" + valorFrete + "]\n";
    }

}