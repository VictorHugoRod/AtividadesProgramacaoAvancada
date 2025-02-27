package org.example;

public class ContaInvestimento extends ContaBancaria{
    public ContaInvestimento(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.02;

        if(saldo >= (valor + taxa)){
            saldo -= (valor + taxa);
        }else{
            System.out.println("Valor indisponível para saque.");
        }
    }
}
