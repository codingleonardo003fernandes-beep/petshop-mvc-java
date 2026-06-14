package model.controller;

import model.Tutor;
import java.util.ArrayList;
import java.util.List;

public class TutorController {
    private List<Tutor> tutores = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrar(String nome, String telefone, String endereco) {
        Tutor t = new Tutor(proximoId++, nome, telefone, endereco);
        tutores.add(t);
    }

    public List<Tutor> listar() { return tutores; }

    public Tutor buscarPorId(int id) {
        for (Tutor t : tutores) {
            if (t.getId() == id) return t;
        }
        throw new IllegalArgumentException("Erro: Tutor com ID " + id + " não encontrado.");
    }

    public void alterar(int id, String novoNome, String novoTelefone, String novoEndereco) {
        Tutor t = buscarPorId(id);
        t.setNome(novoNome);
        t.setTelefone(novoTelefone);
        t.setEndereco(novoEndereco);
    }

    public void deletar(int id) {
        Tutor t = buscarPorId(id);
        tutores.remove(t);
    }

    public void adicionarPet(int idTutor, String nomePet) {
        Tutor t = buscarPorId(idTutor);
        t.adicionarPet(nomePet);
    }

    public void removerPet(int idTutor, String nomePet) {
        Tutor t = buscarPorId(idTutor);
        t.removerPet(nomePet);
    }
}
