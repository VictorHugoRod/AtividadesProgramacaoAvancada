package org.example;

public class Onibus extends Veiculo{

    private int quantidadeEixos;
    private int tamanhoTanque = 200;
    private int consumo = 5;

    public Onibus(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int quantidadeEixos) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);

            if (quantidadeEixos >= 6 && quantidadeEixos <= 8) {
                this.quantidadeEixos = quantidadeEixos;
            } else {
                throw new IllegalArgumentException("ERRO! A quantidade de eixos deve estar entre 6 e 8");
            }
    }

    @Override
    public void calcularAutonomia() {

        System.out.println("A autonomia é de: " + (tamanhoTanque * consumo) + "km");

    }
}
