package com.unicesumar.service;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.entities.Venda;
import com.unicesumar.paymentMethods.PaymentMethod;
import com.unicesumar.PaymentMethodFactory;
import com.unicesumar.paymentMethods.PaymentType;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;
import com.unicesumar.repository.VendaRepository;

import java.sql.SQLException;
import java.util.*;

public class VendaService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final VendaRepository vendaRepository;
    private final Scanner scanner;

    public VendaService(UserRepository userRepository, ProductRepository productRepository, VendaRepository vendaRepository, Scanner scanner){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.vendaRepository = vendaRepository;
        this.scanner = scanner;
    }

    public Venda realizarVenda(){
        try{
            System.out.print("\nDigite o Email do usuário: ");
            String email = scanner.next();

            Optional<User> userOptional = userRepository.findByEmail(email);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                System.out.println("Usuário encontrado: " + user.getName() + "\n");

                System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
                String input = scanner.next();
                String[] productIds = input.split(",");

                List<Product> products = new ArrayList<>();

                for(String id : productIds){
                    UUID productUUID = UUID.fromString(id.trim());

                    Product product = productRepository.findById(productUUID).orElse(null);
                    if(product != null){
                        products.add(product);
                        System.out.printf("Produto encontrado: %s (R$ %.2f)%n", product.getName(), product.getPrice());

                    }else{
                        System.out.println("Produto com ID " + id + " não encontrado.");
                    }
                }

                System.out.println("\nEscolha a forma de pagamento: ");
                System.out.println("1 - Cartão de Crédito");
                System.out.println("2 - Boleto");
                System.out.println("3 - PIX");
                System.out.print("Opção: ");
                int paymentOption = scanner.nextInt();

                System.out.println("\nAguarde, efetuando pagamento...");

                PaymentMethod paymentMethod = PaymentMethodFactory.create(PaymentType.values()[paymentOption - 1]);
                paymentMethod.pay(products.stream().mapToDouble(Product::getPrice).sum());

                Venda venda = new Venda(user, products, paymentMethod);
                vendaRepository.save(venda);

                for(Product product : products){
                    vendaRepository.saveSaleProduct(venda.getId(), product.getUuid());
                }

                System.out.println("\nResumo da venda:");
                System.out.println("Cliente: " + user.getName());
                System.out.println("Produtos:");
                for(Product product : products){
                    System.out.printf("- %s (R$ %.2f)%n", product.getName(), product.getPrice());
                }
                double total = products.stream().mapToDouble(Product::getPrice).sum();
                System.out.printf("Valor total: R$ %.2f%n", total);
                System.out.println("Pagamento: " + paymentMethod.getClass().getSimpleName());

                System.out.println("\nVenda registrada com sucesso!");
                return venda;

            }else{
                System.out.println("Usuário não encontrado!");
                return null;
            }
        }catch(SQLException e){
            System.err.println("Erro ao salvar dados no banco de dados: " + e.getMessage());
            return null;
        }
    }

}

