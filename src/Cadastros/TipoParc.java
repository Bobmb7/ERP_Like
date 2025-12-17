package Cadastros;

public enum TipoParc {
    Cliente(1,true),
    Fornecedor(2),
    Transportadora(3);

    private final int codigo;
    private final boolean permCred;

    TipoParc(int codigo){
        this.codigo=codigo;
        this.permCred = false;
    }

    TipoParc(int codigo, boolean permCred){
        this.codigo=codigo;
        this.permCred = permCred;
    }

    public int getCodigo(){return codigo;}
    public boolean isPermCred() {return permCred;}

    public static TipoParc deCodigo(int codigo){
        for(TipoParc t : TipoParc.values()){
            if (codigo == t.getCodigo())
                return t;
        }
        throw new IllegalArgumentException("Código informado é inválido!");
    }
}
