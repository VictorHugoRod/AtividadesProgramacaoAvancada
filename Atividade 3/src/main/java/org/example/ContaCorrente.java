package org.example;

public class ContaCorrente extends ContaBancaria{
    protected double limiteChequeEspecial;

    public ContaCorrente(int numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if(saldo >= valor){
            saldo -= valor;
        }else{
            if(saldo + limiteChequeEspecial >= valor) {
                valor = valor - saldo;
                saldo = 0;
                limiteChequeEspecial -= valor;
            }else{
                System.out.println("Erro ao sacar, sem saldo e sem limite de cheque especial");
            }
        }
    }

}
