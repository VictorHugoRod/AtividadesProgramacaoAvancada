package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.repository.ProductRepository;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar Produto");
            System.out.println("3 - Listar Produtos");
            System.out.println("4 - Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    double price = scanner.nextDouble();
                    Product newProduct = new Product(name, price);
                    productRepository.save(newProduct);
                    break;

                case 2:
                    System.out.print("Digite o UUID do Produto: ");
                    String id = scanner.nextLine();
                    productRepository.findById(UUID.fromString(id))
                            .ifPresentOrElse(
                                    product -> System.out.println("Produto encontrado: " + product.getName() + " - R$" + product.getPrice()),
                                    () -> System.out.println("Produto não encontrado.")
                            );
                    break;

                case 3:
                    System.out.println("\n--- Produtos Cadastrados ---");
                    productRepository.findAll().forEach(p ->
                            System.out.println(p.getUuid() + " | " + p.getName() + " - R$" + p.getPrice()));
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);

        scanner.close();
    }
}
