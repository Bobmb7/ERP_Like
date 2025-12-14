package ERP_Like;

import Cadastros.Parceiros;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int opcao=0;
    private static Set<Parceiros> parceiros = new HashSet<>();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args){
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
                opcao1();
            }else if(opcao ==2){
                opcao2();
            }else if(opcao ==3){
                opcao3();
            }else if(opcao ==4) {
                opcao4();
            }else if(opcao !=9){
                opcaoInvalida();
            }
        }
    }

    private static void menu(){
        System.out.println("1 - Cadastrar parceiro");
        System.out.println("2 - Listar parceiros");
        System.out.println("3 - Buscar parceiro");
        System.out.println("4 - Remover parceiro");
        System.out.println("9 - Sair");
        System.out.println();
        System.out.println("Escolha uma opção:");
    }

    private static void opcao1(){
        limpar();
        System.out.println("Para cadastrar parceiro digite:");
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
            parceiros.add(new Parceiros());
            System.out.println(" Cadastrado com sucesso!");
        }
    }

    private static void opcao2(){
        System.out.println("opção 2");
        System.out.println();
        System.out.println("Dê enter para retornar.");
        leitor.nextLine();
        limpar();
    }

    private static void opcao3(){
        System.out.println("opção 3");
        System.out.println();
        System.out.println("Dê enter para retornar.");
        leitor.nextLine();
        limpar();
    }

    private static void opcao4(){
        System.out.println("opção 4");
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
