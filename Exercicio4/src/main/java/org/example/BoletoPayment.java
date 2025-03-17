package org.example;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        String boletoCode = generateBoletoCode();
        System.out.println("BOLETO GERADO: " + boletoCode);
    }

    public String generateBoletoCode(){
        Random random = new Random();
        StringBuilder boleto = new StringBuilder();
        for(int i = 0; i < 40; i++){
            boleto.append(random.nextInt(10));
        }
        return boleto.toString();
    }
}
