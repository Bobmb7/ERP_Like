package Cadastros;

import java.util.Objects;

public abstract class Parceiro {
    private final int id;
    private static int ult_id=0;
    private String nome;
    private final String documento;
    private String email;

    Parceiro(String nome, String documento, String email){
        if(documento == null || documento.equals(" ") || documento.isEmpty()){
            throw new IllegalArgumentException("Documento não pode ser nulo ou vazio! tente novamente");
        } else if (nome == null || nome.equals(" ") || nome.isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio! tente novamente");
        }else{
            ult_id++;
            this.id = ult_id;
            this.nome = nome.toUpperCase();
            this.documento = documento.toUpperCase();
            this.email = email.toLowerCase();
        }
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    String getInfo(){
        return "Parceiro: "+id+ " - " +nome+" - "+documento+" - "+email + " ;" ;
    }

    String infoCompleta(){
        return "---\n ID: "+id+"\n Tipo: " +getTipo()+"\n Nome: "+nome
                +"\n Documento: " +documento+"\n Permite Crédito:"+ permiteCredito()
                +"\n E-mail: "+ email + "\n ---";
    }

    public abstract String getTipo();

    public abstract String permiteCredito();

    public abstract boolean permCred();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Parceiro parceiros = (Parceiro) o;
        return Objects.equals(documento, parceiros.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
