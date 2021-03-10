package polimorfismo;

public class RelatorioPagamento {
    // public void relatorioPagamentoGerente(Gerente gerente){
    //     System.out.println("Gerando relatório de pagamento para gerência");
    //     gerente.calcularPagamento();
    //     System.out.println("Nome: "+gerente.getNome());
    //     System.out.println("Salário: "+gerente.getSalario());
    // }

    // public void relatorioPagamentoVendedor(Vendedor vendedor){
    //     System.out.println("Gerando relatório de pagamento para vendedores");
    //     vendedor.calcularPagamento();
    //     System.out.println("Nome: "+vendedor.getNome());
    //     System.out.println("Salário: "+vendedor.getSalario());
    // }

    // Aqui podemos passar um Gerente,Vendedor ou Funcionário
    public void relatorioPagamentoGenerico(Funcionario funcionario){
        System.out.println("Gerando relatório de pagamento:");
        funcionario.calcularPagamento();
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Salário: "+funcionario.getSalario());
        if (funcionario instanceof Gerente){
            Gerente gerente = (Gerente)funcionario;
            System.out.println("Participação nos lucros: "+gerente.getPnl());
        }
        if (funcionario instanceof Vendedor){
            // Casting indireto de funcionário para vendedor:
            // Vendedor vendedor = (Vendedor) funcionario;
            // System.out.println("Total vendas: "+vendedor.getTotalVendas());

            //Casting Direto de Funcionário para vendedor (sem variável de referência):
            System.out.println("Total vendas: "+((Vendedor) funcionario).getTotalVendas());
        }
    }
}
