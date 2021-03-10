package polimorfismo;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Anna",5000,2000);
        Vendedor vendedor = new Vendedor("Harvey",2000,20000);
        RelatorioPagamento relatorio = new RelatorioPagamento();
        relatorio.relatorioPagamentoGenerico(gerente);
        relatorio.relatorioPagamentoGenerico(vendedor);
        // relatorio.relatorioPagamentoGerente(gerente);
        // relatorio.relatorioPagamentoVendedor(vendedor);

        // Funcionario funcionario = gerente;
        // System.out.println("\nSalario funcionário: "+funcionario.getSalario());
    }
}
