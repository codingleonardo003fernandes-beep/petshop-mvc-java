package model.controller;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrar(String nome, String telefone, String endereco, String cargo, double salario) {
        Funcionario f = new Funcionario(proximoId++, nome, telefone, endereco, cargo, salario);
        funcionarios.add(f);
    }

    public List<Funcionario> listar() { return funcionarios; }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) return f;
        }
        throw new IllegalArgumentException("Erro: Funcionário com ID " + id + " não encontrado.");
    }

    public void alterar(int id, String novoNome, String novoTelefone, String novoEndereco, String novoCargo, double novoSalario) {
        Funcionario f = buscarPorId(id);
        f.setNome(novoNome);
        f.setTelefone(novoTelefone);
        f.setEndereco(novoEndereco);
        f.setCargo(novoCargo);
        f.setSalario(novoSalario);
    }

    public void deletar(int id) {
        Funcionario f = buscarPorId(id);
        funcionarios.remove(f);
    }
}
