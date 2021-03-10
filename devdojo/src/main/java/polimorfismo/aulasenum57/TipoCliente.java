package polimorfismo.aulasenum57;

import lombok.Getter;

@Getter
public enum TipoCliente {
    PESSOA_FISICA(1,"Pessoa Fisica"),
    PESSOA_JURIDICA(2,"Pessoa Juridica") { @Override public String getId(){return "b";}}
    ;

    private int tipo;
    private String nome;

    TipoCliente(int tipo,String nome){
        this.tipo = tipo;
        this.nome = nome;
    }
    
    // Imagine que temos um método que retorna uma constante:
    public String getId(){
        return "A";
    }
    // Podemos sobrescrever esse método abrindo chaves num enum declarado lá encima:
    // Agora que sobrescrevemos ele em PESSOA_JURIDICA, seu getId() retorna "b"
    // Enquanto o de PESSOA_FISICA retorna "A"

    // Constant specific class body

}
