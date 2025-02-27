package org.example;

public class ContaPoupanca extends  ContaBancaria{
    public ContaPoupanca(int numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
        }else{
            System.out.println("Saldo indisponível, impossível sacar o valor desejado.");
        }
    }
}
