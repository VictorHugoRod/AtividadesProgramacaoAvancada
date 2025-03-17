package org.example;

public class SMSNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("\nEnviando o SMS: \n");
        System.out.println("Usuário");
        System.out.println("Text Message . SMS");
        System.out.println(message);
    }
}
