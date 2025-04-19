package com.unicesumar.paymentMethods;

public class PixPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Pagamento efetuado com sucesso via PIX. Chave de Autenticação: 12345678-1234-1234-12345678");
    }
}