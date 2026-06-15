package model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Pessoa {
    private static final long serialVersionUID = 1L;

    private int id;
    private List<String> pets;

    public Tutor(int id, String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        this.id = id;
        this.pets = new ArrayList<>();
    }

    public void adicionarPet(String nomePet) { pets.add(nomePet); }
    public void removerPet(String nomePet) { pets.remove(nomePet); }

    public int getId() { return id; }
    public List<String> getPets() { return pets; }
}
