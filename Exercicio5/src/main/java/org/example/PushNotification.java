package org.example;

public class PushNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("\nEnviando a push: \n");
        System.out.println("Usuário");
        System.out.println(message);
    }
}
