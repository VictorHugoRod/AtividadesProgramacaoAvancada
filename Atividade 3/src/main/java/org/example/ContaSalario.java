package org.example;

public class ContaSalario extends ContaCorrente{
    private boolean sacouMesAtual = false;

    public ContaSalario(int numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
    }

    @Override
    public void sacar(double valor) {

        if(!sacouMesAtual) {
            if (saldo >= valor) {
                saldo -= valor;
            } else {
                if (saldo + limiteChequeEspecial >= valor) {
                    valor = valor - saldo;
                    saldo = 0;
                    limiteChequeEspecial -= valor;
                } else {
                    System.out.println("Erro ao sacar, sem saldo e sem limite de cheque especial");
                }
            }
            sacouMesAtual = true;
        }else{
            if (saldo + 5 >= valor) {
                saldo -= (valor + 5);
            } else {
                if ((saldo + limiteChequeEspecial) + 5 >= valor) {
                    valor = valor - saldo;
                    saldo = 0;
                    limiteChequeEspecial -= (valor + 5);
                } else {
                    System.out.println("Valor indisponível para saque");
                }
            }
        }
    }


}
