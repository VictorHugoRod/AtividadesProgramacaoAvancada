package org.example;

public class ContaInvestimentoAltoRisco extends ContaInvestimento{
    private double saldoMinimoSaque = 10000;

    public ContaInvestimentoAltoRisco(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.05;

        if(saldo >= saldoMinimoSaque) {
            if (saldo >= (valor + taxa)) {
                saldo -= (valor + taxa);
            } else {
                System.out.println("Valor indisponível para saque.");
            }
        }else{
            System.out.println("Saldo menor que o saldo mínimo para saque");
        }
    }
}
