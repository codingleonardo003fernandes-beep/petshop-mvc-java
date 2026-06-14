package controller;

import model.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PetController implements Serializable {
    private static final long serialVersionUID = 1L;

    // Lista dinâmica (Coleção) contendo os pets cadastrados
    private List<Animal> pets;

    public PetController() {
        this.pets = new ArrayList<>();
    }

    // C - Cadastrar Pet
    public void cadastrar(Animal pet) {
        pets.add(pet);
        System.out.println("Pet cadastrado com sucesso: " + pet.getNome());
    }

    // R - Listar todos
    public List<Animal> listarTodos() {
        return this.pets;
    }

    // R - Buscar pet individual pelo nome
    public Animal buscarPorNome(String nome) {
        for (Animal a : pets) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    // D - Deletar pet da lista
    public boolean deletar(String nome) {
        Animal a = buscarPorNome(nome);
        if (a != null) {
            pets.remove(a);
            return true;
        }
        return false;
    }
}