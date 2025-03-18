package org.example;

import java.util.Scanner;
import java.util.UUID;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: " + preco;
    }
}
