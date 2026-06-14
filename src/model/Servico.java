package model;

import java.io.Serializable;

public class Servico implements BanhoTosa, Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private double preco;
    private int duracaoMinutos;

    // Construtor do Grupo (Não mude para não quebrar o código deles)
    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Seu Construtor (Para o seu CRUD)
    public Servico(int id, String nome, double preco, int duracaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public void ejecutarServico() {
        System.out.println("Executando o serviço de " + this.nome + " com todo cuidado!");
    }

    // Sobrecarga de Métodos (Preço)
    public double calcularPreco() { return this.preco; }
    public double calcularPreco(double taxaUrgencia) { return this.preco + taxaUrgencia; }
    public double calcularPreco(double taxaUrgencia, double desconto) { return (this.preco + taxaUrgencia) - desconto; }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
}