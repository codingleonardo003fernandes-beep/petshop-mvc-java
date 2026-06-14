package controller;

import model.Pagamento;
import java.util.ArrayList;
import java.util.List;

public class PagamentoController {
    private List<Pagamento> pagamentos = new ArrayList<>();
    private int proximoId = 1;

    public void registrarPagamento(double valor, String metodo) {
        Pagamento p = new Pagamento(proximoId++, valor, metodo);
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
}