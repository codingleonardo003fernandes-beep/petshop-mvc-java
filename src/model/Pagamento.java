package model;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private double valor;
    private String metodoPagamento;
    private String status;
    private Agendamento agendamento;

    public Pagamento(int id, double valor, String metodoPagamento) {
        this.id = id;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.status = "Pendente";
    }

    public Pagamento(int id, double valor, String metodoPagamento, Agendamento agendamento) {
        this.id = id;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.agendamento = agendamento;
        this.status = "Pendente";
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public String toString() {
        String infoAgendamento = "Sem agendamento vinculado";

        if (agendamento != null) {
            infoAgendamento = "Agendamento #" + agendamento.getId();
        }

        return "Pagamento #" + id
                + " | Valor: R$ " + valor
                + " | Método: " + metodoPagamento
                + " | Status: " + status
                + " | " + infoAgendamento;
    }
}