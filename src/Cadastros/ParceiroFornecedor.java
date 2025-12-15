package Cadastros;

public class ParceiroFornecedor extends Parceiro {

    public ParceiroFornecedor(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getTipo() {
        return "FORNECEDOR";
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
