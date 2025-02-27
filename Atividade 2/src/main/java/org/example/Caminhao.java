package org.example;

public class Caminhao extends Veiculo{
    protected double capacidadeCarga;
    private double tamanhoTanque = 50;
    private double consumo = 6;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public void calcularAutonomia() {

        if(capacidadeCarga > 0 && capacidadeCarga <= 25) {
            consumo = consumo - ((consumo/100) * capacidadeCarga);
        }else if(capacidadeCarga > 25 ){

            consumo = consumo - ((consumo/100) * 25);

        }

        System.out.println("A autonomia é de: " + (tamanhoTanque * consumo) + "km");

    }
}
