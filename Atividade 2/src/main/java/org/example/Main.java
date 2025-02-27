package org.example;

import java.sql.SQLOutput;

import static org.example.TipoCarro.hatch;
import static org.example.TipoCarro.sedan;

public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro("Chevrolet", "Vectra", 2005, 6, "Gasolina", sedan);
        Caminhao caminhao = new Caminhao("Scania", "S320", 2012, 4, "Diesel", 5);
        Onibus onibus = new Onibus("Mercedes", "Lv-14", 2015, 46, "Diesel", 6);
        CarroEletico carroEletico = new CarroEletico("BYD", "Dolphin", 2024, 6, "Energia elétrica", hatch, 15);
        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "S250", 2012, 4, "Diesel", 0, 0);

        carro.exibirDetalhes();
        carro.calcularAutonomia();
        System.out.println(" ");

        caminhao.exibirDetalhes();
        caminhao.calcularAutonomia();
        System.out.println(" ");

        onibus.exibirDetalhes();
        onibus.calcularAutonomia();
        System.out.println(" ");

        carroEletico.exibirDetalhes();
        carroEletico.calcularAutonomia();
        System.out.println(" ");

        caminhaoRefrigerado.exibirDetalhes();
        caminhaoRefrigerado.calcularAutonomia();

    }

}