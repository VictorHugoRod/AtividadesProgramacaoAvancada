package org.example;

import java.util.Scanner;

public class NotificationFactory {

    public static Notification createNotification(String type){
        if(type.equalsIgnoreCase("email")){
            return new EmailNotification();
        }else if(type.equalsIgnoreCase("sms")){
            return new SMSNotification();
        }else if(type.equalsIgnoreCase("push")){
            return new PushNotification();
        }
        throw new IllegalArgumentException("Tipo desconhecido");
    }

}