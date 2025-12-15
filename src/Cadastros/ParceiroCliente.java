package Cadastros;

public class ParceiroCliente extends Parceiro{

    public ParceiroCliente(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getTipo() {
        return "CLIENTE";
    }

    @Override
    public String permiteCredito() {
        return "Sim";
    }

    @Override
    public boolean permCred() {
        return true;
    }


}
