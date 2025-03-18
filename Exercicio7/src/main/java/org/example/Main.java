package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Produto> produtos = new HashMap<>();

        int idSequencial = 1;

        int choice = 0;

        do {
            System.out.println("\nSELECIONE UMA OPÇÃO\n");
            System.out.println("\n1 - CADASTRAR PRODUTO\n2 - BUSCAR PRODUTO(POR CÓDIGO) \n3 - SAIR");
            System.out.println("\nOPÇÃO: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\nOPÇÃO INVÁLIDA, INSIRA UMA OPÇÃO: ");
                scanner.nextLine();
                continue;
            }

            if (choice == 3) {
                System.out.println("SAINDO...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("INSIRA O NOME DO PRODUTO: ");
                    String nome = scanner.nextLine();

                    System.out.println("INSIRA O VALOR DO PRODUTO: ");
                    double preco = 0;
                    preco = scanner.nextDouble();
                    scanner.nextLine();

                    int codigo = idSequencial++;

                    Produto produto = new Produto(codigo, nome, preco);
                    produtos.put(codigo, produto);
                    System.out.println("PRODUTO CADASTRADO");
                    break;

                case 2:

                    System.out.println("INSIRA O CÓDIGO DO PRODUTO QUE DESEJA BUSCAR: ");
                    int codigoEntrada = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoBuscado = produtos.get(codigoEntrada);
                    if (produtoBuscado != null) {
                        System.out.println("PRODUTO ENCONTRADO: " + produtoBuscado);
                    } else {
                        System.out.println("PRODUTO NÃO ENCONTRADO");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }

        } while (choice != 3);

        scanner.close();
    }
}


