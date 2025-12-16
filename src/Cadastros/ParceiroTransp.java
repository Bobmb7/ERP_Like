package Cadastros;

public class ParceiroTransp extends Parceiro{

    public ParceiroTransp(String nome, String documento, String email){
        super(nome, documento, email);
    }

    @Override
    public String getinfoCompleta() {
        return "---\n ID: "+id+"\n Tipo: " +getTipo()+"\n Nome: "+nome
                +"\n Documento: " +documento+"\n Permite Crédito: Não"
                +"\n E-mail: "+ email + "\n ---";
    }

    @Override
    public String getTipo() {
        return "TRANSPORTADORA";
    }

    @Override
    public boolean permiteCredito() {
        return false;
    }
}
