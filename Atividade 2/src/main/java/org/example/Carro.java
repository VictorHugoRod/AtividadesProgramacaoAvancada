package org.example;

public class Carro extends Veiculo{
    private TipoCarro tipoCarro;
    int tamanhoTanque = 50;
    int consumo = 12;

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, TipoCarro tipoCarro) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.tipoCarro = tipoCarro;
    }

    @Override
    public void calcularAutonomia(){

        System.out.println("A autonomia é de: " + (tamanhoTanque * consumo) + "km");

    }
}
