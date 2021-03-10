package polimorfismo.aulasenum57;

import lombok.Data;

@Data
public class Cliente {

    public enum TipoPagamento{
        A_VISTA,A_PRAZO;
    }

    private String nome;
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento){
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", tipo=" + tipoCliente + ", tipoPagamento=" + tipoPagamento + " numero=" + tipoCliente.getTipo() + "]";
    }

}
