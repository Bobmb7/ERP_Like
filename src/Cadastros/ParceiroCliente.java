package Cadastros;

public class ParceiroCliente extends Parceiro{

    public ParceiroCliente(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getInfoCompleta() {
        return "---\n ID: "+id+"\n Tipo: " +getTipo()+"\n Nome: "+nome
                +"\n Documento: " +documento+"\n Permite Crédito: Sim"
                +"\n E-mail: "+ email + "\n ---";
    }

    @Override
    public String getTipo() {
        return "CLIENTE";
    }

    @Override
    public boolean permiteCredito() {
        return true;
    }


}
