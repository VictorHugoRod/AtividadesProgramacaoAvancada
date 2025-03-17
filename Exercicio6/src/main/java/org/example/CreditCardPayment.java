package org.example;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nINSIRA O NÚMERO DO CARTÃO: ");
        String cardNumber = scanner.nextLine();
        System.out.println("\nPAGAMENTO DE R$" + amount +" CONFIRMADO!\n");


    }
}
