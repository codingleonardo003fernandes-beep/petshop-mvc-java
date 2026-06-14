package controller;

import model.Historico;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoController implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Historico> historicos;
    private int proximoId;

    public HistoricoController() {
        this.historicos = new ArrayList<>();
        this.proximoId = 1;
    }

    // Adiciona uma linha de histórico nova
    public void registrarEvento(String nomePet, String mensagem) {
        Historico novo = new Historico(proximoId++, nomePet, mensagem, LocalDateTime.now());
        historicos.add(novo);
    }

    // Retorna todos os históricos
    public List<Historico> listarTodos() {
        return this.historicos;
    }

    // Filtra o histórico mostrando apenas as ações de um pet específico
    public List<Historico> listarPorPet(String nomePet) {
        List<Historico> filtrado = new ArrayList<>();
        for (Historico h : historicos) {
            if (h.getNomePet().equalsIgnoreCase(nomePet)) {
                filtrado.add(h);
            }
        }
        return filtrado;
    }
}