package polimorfismo.interfaces62;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Notebook", 4, 3000);
        // Podemos criar variáveis de referência para interfaces,
        // mas não podemos instanciar objetos.
        produto.calculaFrete();
        produto.tributavelCalcularImposto();
        System.out.println(produto);
    }
}
