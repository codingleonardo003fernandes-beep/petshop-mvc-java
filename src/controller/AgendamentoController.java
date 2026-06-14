package controller;

import model.Agendamento;
import model.Animal;
import model.Servico;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Este controlador guarda a lista de agendamentos e faz o CRUD (ações do sistema).
public class AgendamentoController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Lista dinâmica (Coleção) para guardar os agendamentos na memória.
    private List<Agendamento> agendamentos;
    private int proximoId;

    public AgendamentoController() {
        this.agendamentos = new ArrayList<>();
        this.proximoId = 1;
    }

    // C - Cadastrar (Método Base)
    public void cadastrar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        System.out.println("Agendamento inserido com sucesso! ID: " + agendamento.getId());
    }

    // Polimorfismo de Sobrecarga: Método com o mesmo nome, mas recebe parâmetros diferentes.
    public void cadastrar(Animal pet, Servico servico, LocalDateTime dataHora) {
        Agendamento novo = new Agendamento(proximoId++, pet, servico, dataHora);
        agendamentos.add(novo);
        System.out.println("Agendamento gerado! ID: " + novo.getId());
    }

    // R - Listar Todos
    public List<Agendamento> listarTodos() {
        return this.agendamentos;
    }

    // R - Buscar por ID individual
    public Agendamento buscarPorId(int id) {
        for (Agendamento a : agendamentos) {
            if (a.getId() == id) {
                return a; 
            }
        }
        return null; 
    }

    // U - Alterar (Atualizar dados)
    public boolean alterar(int id, LocalDateTime novaData, String novoStatus) {
        Agendamento a = buscarPorId(id);
        if (a != null) {
            a.setDataHora(novaData);
            a.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    // D - Deletar (Apagar da lista)
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
    
    // Injeta a lista quando os dados forem carregados de um arquivo pelo Leonardo.
    public void setAgendamentos(List<Agendamento> lista, int proximoId) {
        this.agendamentos = lista;
        this.proximoId = proximoId;
    }
}
