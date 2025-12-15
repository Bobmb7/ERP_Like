package Cadastros;

public class ParceiroTransp extends Parceiro{

    public ParceiroTransp(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getTipo() {
        return "TRANSPORTADORA";
    }

    @Override
    public String permiteCredito() {
        return "Não";
    }

    @Override
    public boolean permCred() {
        return false;
    }
}
