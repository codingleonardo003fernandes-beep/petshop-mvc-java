package controller;

import model.Agendamento;
import model.Relatorio;
import java.io.Serializable;
import java.util.List;



public class RelatorioController implements Serializable{
    private static final long serialVersionUID = 1L;
    private AgendamentoController agendamentoController;


    public RelatorioController(AgendamentoController agendamentoController) {
        this.agendamentoController = agendamentoController;
    }


    public Relatorio gerarRelatorioGeral() {
        List<Agendamento> lista = agendamentoController.listarTodos();
        
        int total = lista.size();
        int concluidos = 0;
        double faturamento = 0.0;


        for (Agendamento a : lista) {
            if (a.getStatus().equalsIgnoreCase("Concluído")) {
                concluidos++;
                if (a.getServico() != null) {
                    faturamento += a.getServico().getPreco();
                }
            }
        }
        return new Relatorio(total, faturamento, concluidos);
    }
}
