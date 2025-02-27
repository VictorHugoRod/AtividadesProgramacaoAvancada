package org.example;

public class CarroEletico extends Carro{
    private int bateriaKWh;
    int consumo = 5;

    public CarroEletico(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, TipoCarro tipoCarro, int bateriaKWh) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, tipoCarro);
        this.bateriaKWh = bateriaKWh;
    }

    @Override
    public void calcularAutonomia(){

        System.out.println("A autonomia é de: " + (bateriaKWh * consumo) + "km");

    }
}
