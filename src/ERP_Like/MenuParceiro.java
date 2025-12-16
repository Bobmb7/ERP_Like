package ERP_Like;

import Cadastros.CadastraParceiro;
import Cadastros.Parceiros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuParceiro {
    private static int opcao=0;
    private static Parceiros parceiros = new Parceiros();
    private static Scanner leitor = new Scanner(System.in);

    public void iniciar(){
        limpar();
        System.out.println("Bem vindo!");
        System.out.println();
        while(opcao != 9){
            opcao = 0;
            menu();
            try {
                opcao = leitor.nextInt();
            } catch (InputMismatchException e){
                limpar();
                System.out.println("Não foi digitada uma opção válida! Utilize o numero da opção.");
            }
            leitor.nextLine();

            if(opcao == 1){
                novoParceiro();
            }else if(opcao ==2){
                listarParceiros();
            }else if(opcao ==3){
                buscarParceiro();
            }else if(opcao ==4) {
                remover();
            }else if(opcao !=9){
                opcaoInvalida();
            }
        }
    }

    private static void menu(){
        System.out.println("1 - Cadastrar parceiro");
        System.out.println("2 - Listar parceiro");
        System.out.println("3 - Buscar parceiro");
        System.out.println("4 - Excluir parceiro por código.");
        System.out.println("9 - Sair");
        System.out.println();
        System.out.println("Escolha uma opção:");
    }

    private static void novoParceiro(){
        limpar();
        System.out.println("Qual tipo de parceiro quer cadastrar? \n");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.println("3 - Transportadora");
        int tipo=0;
        try {
            tipo = leitor.nextInt();
        } catch (InputMismatchException e){
            limpar();
            System.out.println("Não foi digitada uma opção válida! Cancelando cadastro.");
        }
        leitor.nextLine();

        if(tipo == 0) return;
        else if ( tipo<1 || tipo>3) {
            limpar();
            System.out.println("Opção inválida! Não existe tipo de parceiro de código "+tipo+".");
        }else {
            limpar();
            System.out.println("Digite os dados do parceiro:");
            System.out.println();
            System.out.println(" Nome");
            String nome = leitor.nextLine();
            System.out.println();
            System.out.println(" Documento");
            String documento = leitor.nextLine();
            System.out.println();
            System.out.println(" E-mail");
            String email = leitor.nextLine();
            limpar();
            try {
                parceiros.add(new CadastraParceiro(tipo,nome, documento, email));
                System.out.println(" Cliente cadastrado com sucesso!");
            } catch(IllegalArgumentException e){
                limpar();
                System.out.println(e.getMessage());
            }
        }
    }

    private static void novoCliente(){

    }

        private static void listarParceiros(){
        limpar();
        System.out.println("Lista de Parceiros");
        System.out.println();
        parceiros.listar();
        System.out.println();
        System.out.println("Dê enter para retornar.");
        leitor.nextLine();
        limpar();
    }

    private static void buscarParceiro(){
        limpar();
        int busca =0;
        System.out.println("Qual tipo de busca?");
        System.out.println();
        System.out.println("1 - Por nome.");
        System.out.println("2 - Por documento.");
        System.out.println();
        try {
            busca = leitor.nextInt();
        } catch (InputMismatchException e){
            limpar();
            System.out.println("Não foi digitada uma opção válida! Cancelando busca.");
        }
        leitor.nextLine();
        if(busca == 1){
            limpar();
            System.out.println("Digite o nome para buscar!");
            String termo = leitor.nextLine();
            System.out.println();
            parceiros.buscaPorNome(termo);
            System.out.println();
            System.out.println("Dê enter para retornar:");
            leitor.nextLine();
            limpar();
        }else if(busca ==2){
            limpar();
            System.out.println("Digite o documento para buscar!");
            String termo = leitor.nextLine();
            System.out.println();
            System.out.println(parceiros.buscaPorDoc(termo));
            System.out.println();
            System.out.println("Dê enter para retornar:");
            leitor.nextLine();
            limpar();
        }else if(busca != 0){
            limpar();
            System.out.println("Opção inválida, busca cancelada.");
            System.out.println();
        }
    }

    private static void remover(){
        limpar();
        System.out.println("Digite o código do parceiro a ser excluído.");
        int id=0;
        try{
            id= leitor.nextInt();
            leitor.nextLine();
        }catch (InputMismatchException e){
            limpar();
            System.out.println("Não foi digitada um código válido! Cancelando exclusão.");
            id=0;
        }
        if(id!=0) {
            boolean val = parceiros.remover(id);
            if (val) {
                System.out.println("Parceiro removido com sucesso.");
            } else {
                System.out.println("Parceiro não encontrado.");
                System.out.println("Exclusão cancelada.");
            }
        }
        System.out.println();
        System.out.println("Dê enter para retornar.");
        leitor.nextLine();
        limpar();
    }

    public static void opcaoInvalida(){
        limpar();
        System.out.println("Opção inválida! Opção digitada: "+opcao);
        System.out.println();
        System.out.println("Dê enter para retornar.");
        leitor.nextLine();
        limpar();
    }

    public static void limpar(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
