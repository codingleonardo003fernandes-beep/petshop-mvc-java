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


    public void registrarEvento(String nomePet, String mensagem) {
        Historico novo = new Historico(proximoId++, nomePet, mensagem, LocalDateTime.now());
        historicos.add(novo);
    }


    public List<Historico> listarTodos() {
        return this.historicos;
    }


    public List<Historico> listarPorPet(String nomePet) {
        List<Historico> filtrado = new ArrayList<>();
        for (Historico h : historicos) {
            if (h.getNomePet().equalsIgnoreCase(nomePet)) {
                filtrado.add(h);
            }
        }
        return filtrado;
    }
    public int getProximoId() {
        return this.proximoId;
    }

    public void setHistoricos(List<Historico> lista, int proximoId) {
        this.historicos = lista;
        this.proximoId = proximoId;
    }
}