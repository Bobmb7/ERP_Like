package Cadastros;

import java.util.Objects;

public class Parceiros {
    private int id;
    private static int ult_id=0;
    private String nome;
    private String documento;
    private String email;

    public void Parceiros(String nome, String documento, String email){
        if(documento == null || documento.equals(" ") || documento.isEmpty()){
            throw new IllegalArgumentException("Documento não pode ser nulo ou vazio! tente novamente");
        } else if (nome == null || nome.equals(" ") || nome.isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio! tente novamente");
        }else{
            ult_id++;
            this.id = ult_id;
            this.nome = nome;
            this.documento = documento;
            this.email = email;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parceiros parceiros = (Parceiros) o;
        return Objects.equals(documento, parceiros.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(documento);
    }
}
