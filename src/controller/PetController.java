package controller;

import model.Animal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PetController implements Serializable {
    private static final long serialVersionUID = 1L;


    private List<Animal> pets;

    public PetController() {
        this.pets = new ArrayList<>();
    }


    public void cadastrar(Animal pet) {
        pets.add(pet);
        System.out.println("Pet cadastrado com sucesso: " + pet.getNome());
    }


    public List<Animal> listarTodos() {
        return this.pets;
    }


    public Animal buscarPorNome(String nome) {
        for (Animal a : pets) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }


    public boolean alterar(String nomeAtual, String novoNome, int novaIdade, String novaRaca, String novoTutor) {
        Animal pet = buscarPorNome(nomeAtual);

        if (pet != null) {
            pet.setNome(novoNome);
            pet.setIdade(novaIdade);
            pet.setRaca(novaRaca);
            pet.setTutor(novoTutor);
            return true;
        }

        return false;
    }


    public boolean deletar(String nome) {
        Animal a = buscarPorNome(nome);
        if (a != null) {
            pets.remove(a);
            return true;
        }
        return false;
    }
}