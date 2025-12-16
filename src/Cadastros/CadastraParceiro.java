package Cadastros;

public class CadastraParceiro {
    public static Parceiro ciar(int tipo, String nome, String doc, String email){
        return switch(tipo){
            case 1 -> new ParceiroCliente(nome,doc,email);
            case 2 -> new ParceiroFornecedor(nome,doc,email);
            case 3 -> new ParceiroTransp(nome,doc,email);
            default -> throw new IllegalArgumentException("Tipo inválido para cadastrar parceiro.");
        };
    }
}
