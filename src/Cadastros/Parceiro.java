package Cadastros;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Parceiro {
    final int id;
    static int ult_id=0;
    String nome;
    final String documento;
    String email;
    Set<TipoParc> tipos = new HashSet<>();

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

    public void addTipo(TipoParc tipo){
        tipos.add(tipo);
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
        return "Parceiro: "+id+ " - " +nome+" - "+documento+" - "+email +" - ["+getTipo() +"] ;" ;
    }

    public String getInfoCompleta(){
        return "---\n ID: "+id+"\n Tipo: " +getTipo()+"\n Nome: "+nome
                +"\n Documento: " +documento+"\n Permite Crédito: Sim"
                +"\n E-mail: "+ email + "\n ---";
    };

    public String getTipo(){
        return tipos.stream().map(TipoParc::name).distinct().sorted()
                .collect(Collectors.joining(", "));
    };

    public boolean permiteCredito(){
        return tipos.stream().anyMatch(TipoParc::isPermCred);
    };

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
