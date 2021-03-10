package polimorfismo.aulasenum57;

import polimorfismo.aulasenum57.Cliente.TipoPagamento;

public class TesteEnum {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("nomedele", TipoCliente.PESSOA_FISICA, TipoPagamento.A_PRAZO);
// Pra acessar o método criado, primeiro é preciso acessar o enum para que o constructor crie o objeto
        System.out.println(TipoCliente.PESSOA_JURIDICA.getId());
        System.out.println(cliente);
    }
}
