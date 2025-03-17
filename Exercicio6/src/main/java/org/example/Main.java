package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = null;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nSELECIONE O MÉTODO DE PAGAMENTO\n");
            System.out.println("0 - SAIR\n1 - PIX\n2 - CARTÃO DE CRÉDITO\n3 - BOLETO");
            System.out.println("\nOPÇÃO: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nOPÇÃO INVÁLIDA, INSIRA OUTRO NÚMERO: ");
                scanner.nextLine();
                continue;
            }

            if (choice == 0)
                break;

            System.out.println("\nDigite o valor da transação: ");
            double amount = scanner.nextDouble();

            try {
                strategy = PaymentFactory.createPaymentMethod(choice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.executePayment(amount);

        } while (choice != 0);

        scanner.close();
    }
}
