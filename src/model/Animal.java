package model;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos protegidos por encapsulamento (private)
    private String nome;
    private int idade;
    private String raca;
    private String tutor;

    // Construtor base para a herança
    public Animal(String nome, int idade, String raca, String tutor) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.tutor = tutor;
    }

    // Getters e Setters obrigatórios para o encapsulamento
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public String getTutor() { return tutor; }
    public void setTutor(String tutor) { this.tutor = tutor; }

    // Método abstrato: não tem código aqui, as filhas vão ter que criar o seu próprio som.
    public abstract String emitirSom();
}