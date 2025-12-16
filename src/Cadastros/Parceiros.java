package Cadastros;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Parceiros{
    private static Set<Parceiro> parceiros = new HashSet<>();

    boolean adicionar(Parceiro parceiro){
        try {
            parceiros.add(parceiro);
            return true;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void listar(){
        for(Parceiro parceiro : parceiros){
            System.out.println(parceiro.getInfo());
        }
    }

    public void buscaPorNome(String termo){
        List<Parceiro> p =
                parceiros.stream()
                .filter(parceiro -> parceiro.getNome().contains(termo.toUpperCase()))
                .toList();

        if(p.isEmpty()) {
            System.out.println("Não foi encontrado nenhum parceiro.");
        }else {
            for (Parceiro parceiro : p) {
                System.out.println(parceiro.getInfo());
            }
        }
    }

    public String buscaPorDoc(String termo){
        for (Parceiro parceiro : parceiros) {
            if(parceiro.getDocumento().equals(termo)){
                return parceiro.getInfo();
            }
        }
        return "Não foi encontrado nenhum parceiro com esse documento!";
    }

    public boolean remover(int id){
        Iterator<Parceiro> it = parceiros.iterator();

        while(it.hasNext()){
            Parceiro parceiro = it.next();
            if(parceiro.getId()==id){
                it.remove();
                return true;
            }
        }
        return false;
    }
}
