package org.example;

public class CaminhaoRefrigerado extends Caminhao{
    private double temperaturaMinima;
    private double tamanhoTanque = 50.0;
    private double consumo = 6;

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int capacidadeCarga, int temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public void calcularAutonomia() {

        double autonomiaTotal;


        if(capacidadeCarga > 0 && capacidadeCarga <= 25) {
            consumo = consumo - ((consumo/100) * capacidadeCarga);
        }else if(capacidadeCarga > 25 ){

            consumo = consumo - ((consumo/100) * 25);

        }

        autonomiaTotal = (tamanhoTanque * consumo);
        autonomiaTotal = autonomiaTotal - ((tamanhoTanque * consumo) * (0.1));
        System.out.println("A autonomia é de: " + autonomiaTotal + "km");


    }
}
