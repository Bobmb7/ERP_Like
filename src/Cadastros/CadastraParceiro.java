package Cadastros;

public class CadastraParceiro {
    public static Parceiro ciar(String tipos, String nome, String doc, String email){
        Parceiro p = new Parceiro(nome,doc,email);
        String[] opc = tipos.split("[, ]+");

        for(String op : opc){
            if(op.isBlank()) continue;

            try{
                int codigo = Integer.parseInt(op);
                TipoParc tipo = TipoParc.deCodigo(codigo);
                p.tipos.add(tipo);
            } catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        if(p.tipos.isEmpty()){
            throw new IllegalArgumentException("Obrigatório selecionar ao menos um tipo. Cadastro cancelado.");
        }
        return p;
    }
}
