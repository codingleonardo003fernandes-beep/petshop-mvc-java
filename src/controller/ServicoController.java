package controller;

import model.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoController {
    private List<Servico> servicos = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrar(String nome, double preco, int duracao) {
        Servico novoServico = new Servico(proximoId++, nome, preco, duracao);
        servicos.add(novoServico);
    }

    public List<Servico> listar() { return servicos; }

    public Servico buscarPorId(int id) {
        for (Servico s : servicos) {
            if (s.getId() == id) return s;
        }
        throw new IllegalArgumentException("Erro: Serviço com ID " + id + " não encontrado.");
    }

    public void alterar(int id, String novoNome, double novoPreco) {
        Servico s = buscarPorId(id);
        s.setNome(novoNome);
        s.setPreco(novoPreco);
    }

    public void deletar(int id) {
        Servico s = buscarPorId(id);
        servicos.remove(s);
    }
}