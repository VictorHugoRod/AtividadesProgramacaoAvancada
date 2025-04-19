package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;
import com.unicesumar.repository.VendaRepository;
import com.unicesumar.service.VendaService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = null;
        UserRepository userRepository = null;
        VendaRepository vendaRepository = null;
        Connection conn = null;

        // Parâmetros de conexão
        String url = "jdbc:sqlite:database.sqlite";

        // Tentativa de conexão
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                productRepository = new ProductRepository(conn);
                userRepository = new UserRepository(conn);
                vendaRepository = new VendaRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        VendaService vendaService = new VendaService(userRepository, productRepository, vendaRepository, scanner);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Realizar Venda");
            System.out.println("6 - Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de leitura após o nextInt()

            switch (option) {
                case 1:
                    System.out.println("Cadastrar Produto");

                    System.out.print("Nome do Produto: ");
                    String productName = scanner.nextLine();

                    System.out.print("Preço do Produto: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine();

                    productRepository.save(new Product(productName, productPrice));
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Listar Produtos");
                    List<Product> products = productRepository.findAll();
                    products.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Cadastrar Usuário");

                    System.out.print("Nome do Usuário: ");
                    String userName = scanner.nextLine();

                    System.out.print("E-mail do Usuário: ");
                    String userEmail = scanner.nextLine();

                    System.out.print("Senha do Usuário: ");
                    String userPassword = scanner.nextLine();

                    userRepository.save(new User(userName, userEmail, userPassword));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.println("Listar Usuários");
                    List<User> users = userRepository.findAll();
                    users.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Realizar Venda");
                    vendaService.realizarVenda();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }

        } while (option != 6);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
