package controller;

import model.Pagamento;
import model.Agendamento;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class PagamentoController implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Pagamento> pagamentos = new ArrayList<>();
    private int proximoId = 1;

    public void registrarPagamento(double valor, String metodo) {
        Pagamento p = new Pagamento(proximoId++, valor, metodo);
        pagamentos.add(p);
    }

    public void registrarPagamento(double valor, String metodo, Agendamento agendamento){
        Pagamento p = new Pagamento(proximoId++, valor, metodo, agendamento);
        pagamentos.add(p);
    }

    public List<Pagamento> listar() { return pagamentos; }

    public Pagamento buscarPorId(int id) {
        for (Pagamento p : pagamentos) {
            if (p.getId() == id) return p;
        }
        throw new IllegalArgumentException("Erro: Pagamento com ID " + id + " não encontrado.");
    }

    public void quitarPagamento(int id) {
        Pagamento p = buscarPorId(id);
        p.setStatus("Pago");
    }
    public void alterarPagamento(int id, double novoValor, String novoMetodo) {
        Pagamento p = buscarPorId(id);
        p.setValor(novoValor);
        p.setMetodoPagamento(novoMetodo);
    }

    public void deletarPagamento(int id) {
        Pagamento p = buscarPorId(id);
        pagamentos.remove(p);
    }

}