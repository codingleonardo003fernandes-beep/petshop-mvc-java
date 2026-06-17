package controller;

import model.Agendamento;
import model.Animal;
import model.Servico;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class AgendamentoController implements Serializable {
    private static final long serialVersionUID = 1L;
    

    private List<Agendamento> agendamentos;
    private int proximoId;

    public AgendamentoController() {
        this.agendamentos = new ArrayList<>();
        this.proximoId = 1;
    }

    public void cadastrar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        System.out.println("Agendamento inserido com sucesso! ID: " + agendamento.getId());
    }


    public void cadastrar(Animal pet, Servico servico, LocalDateTime dataHora) {
        Agendamento novo = new Agendamento(proximoId++, pet, servico, dataHora);
        agendamentos.add(novo);
        System.out.println("Agendamento gerado! ID: " + novo.getId());
    }

    public List<Agendamento> listarTodos() {
        return this.agendamentos;
    }

    public Agendamento buscarPorId(int id) {
        for (Agendamento a : agendamentos) {
            if (a.getId() == id) {
                return a; 
            }
        }
        return null; 
    }


    public boolean alterar(int id, LocalDateTime novaData, String novoStatus) {
        Agendamento a = buscarPorId(id);
        if (a != null) {
            a.setDataHora(novaData);
            a.setStatus(novoStatus);
            return true;
        }
        return false;
    }


    public boolean deletar(int id) {
        Agendamento a = buscarPorId(id);
        if (a != null) {
            agendamentos.remove(a);
            return true;
        }
        return false;
    }

    public int getProximoId() {
        return this.proximoId;
    }
    

    public void setAgendamentos(List<Agendamento> lista, int proximoId) {
        this.agendamentos = lista;
        this.proximoId = proximoId;
    }
}
