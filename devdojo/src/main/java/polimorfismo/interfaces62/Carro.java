package polimorfismo.interfaces62;

public class Carro implements Tributavel {

    // Se não especificamos a restrição do método numa
    // classe normal, ele adota "default", gerando um
    // erro de compilação, pois a implementação de
    // um método de interface deve ser menos restritivo ou
    // igualmente.

    // private > default > protected > public

    @Override
    public void tributavelCalcularImposto() {
        System.out.println("SEM IMPOSTO YAY");
    }
    
}
