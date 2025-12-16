package Cadastros;

public class ParceiroFornecedor extends Parceiro {

    public ParceiroFornecedor(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getInfoCompleta() {
        return "---\n ID: "+id+"\n Tipo: " +getTipo()+"\n Nome: "+nome
                +"\n Documento: " +documento+"\n Permite Crédito: Não"
                +"\n E-mail: "+ email + "\n ---";
    }

    @Override
    public String getTipo() {
        return "FORNECEDOR";
    }

    @Override
    public boolean permiteCredito() {
        return false;
    }
}
