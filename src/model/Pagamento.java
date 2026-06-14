package model;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private double valor;
    private String metodoPagamento;
    private String status;

    public Pagamento(int id, double valor, String metodoPagamento) {
        this.id = id;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.status = "Pendente";
    }

    public int getId() { return id; }
    public double getValor() { return valor; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}