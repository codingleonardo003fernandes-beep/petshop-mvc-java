package model;

import java.io.Serializable;

// Código temporário de teste para o sistema funcionar até o Felipe te passar o dele.
public class Servico implements Serializable {
    private String nome;
    private double preco;

    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}
