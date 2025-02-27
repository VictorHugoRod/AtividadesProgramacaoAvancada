package org.example;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente(1, "João", 1500,5000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, "Pedro", 5000);
        ContaInvestimento contaInvestimento = new ContaInvestimento(3, "Caio", 3000);
        ContaSalario contaSalario = new ContaSalario(4, "Hugo", 1400, 1000);
        ContaInvestimentoAltoRisco contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco(5,"Maria", 11000);
        
        contaCorrente.depositar(500);
        contaCorrente.sacar(1500);
        contaCorrente.sacar(6000);
        contaCorrente.sacar(5500);
        contaCorrente.exibirInformacoes();

        contaPoupanca.depositar(500);
        contaPoupanca.sacar(1000);
        contaPoupanca.sacar(7000);
        contaPoupanca.exibirInformacoes();

        contaInvestimento.depositar(500);
        contaInvestimento.sacar(500);
        contaInvestimento.exibirInformacoes();

        contaSalario.depositar(600);
        contaSalario.sacar(10);
        contaSalario.exibirInformacoes();
        contaSalario.sacar(10);
        contaSalario.exibirInformacoes();

        contaInvestimentoAltoRisco.sacar(1000);
        contaInvestimentoAltoRisco.exibirInformacoes();
        contaInvestimentoAltoRisco.sacar(10000);

    }
}