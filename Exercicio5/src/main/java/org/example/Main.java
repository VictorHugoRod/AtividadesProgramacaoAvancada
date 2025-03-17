package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nESCOLHA UM TIPO DE NOTIFICAÇÃO\n");
            System.out.println("0 - SAIR\n1 - EMAIL\n2 - SMS\n3 - PUSH");
            System.out.print("\nOPÇÃO: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nOPÇÃO INVÁLIDA, INSIRA OUTRO NÚMERO: ");
                scanner.nextLine();
                continue;
            }

            if (choice == 0)
                break;

            String notificationType = "";

            switch (choice) {
                case 1:
                    notificationType = "email";
                    break;
                case 2:
                    notificationType = "sms";
                    break;
                case 3:
                    notificationType = "push";
                    break;

                default:
                    System.out.println("\nOPÇÃO INVÁLIDA\n");
                    continue;
            }

            System.out.print("Digite a mensagem: ");
            scanner.nextLine();
            String message = scanner.nextLine();

            Notification notification = NotificationFactory.createNotification(notificationType);

            notification.send(message);

        } while (choice != 0);

        scanner.close();
    }
}
