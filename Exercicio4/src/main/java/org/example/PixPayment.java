package org.example;

import java.util.Random;

public class PixPayment implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        String pixCode = generatePixCode();
        System.out.println("CÓDIGO PIX: " + pixCode);
    }

    public String generatePixCode(){
        String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        StringBuilder pixCode = new StringBuilder("PIX-");
        Random random = new Random();
        for(int i = 0; i < 32; i++){
            pixCode.append(chars.charAt(random.nextInt(chars.length())));
        }
        return pixCode.toString();
    }
}
