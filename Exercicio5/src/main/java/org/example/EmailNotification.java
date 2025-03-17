package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        LocalDateTime today = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = today.format(formatter);

        System.out.println("\nEnviando o email: \n");
        System.out.println(message);
        System.out.println("De:  Usuário <email@gmail.com>\n" + "Enviado: " + today + "\nPara: Destinatário <email@gmail.com>\n" + "Assunto: PRIVADO");
    }
}
