package controller;

import model.Agendamento;
import model.Relatorio;
import java.util.List;

// Este controlador analisa a lista de agendamentos para calcular o faturamento.
public class RelatorioController {
    private AgendamentoController agendamentoController;

    // Recebe o controlador de agendamentos para ler os dados da memória.
    public RelatorioController(AgendamentoController agendamentoController) {
        this.agendamentoController = agendamentoController;
    }

    // Algoritmo que calcula as métricas financeiras.
    public Relatorio gerarRelatorioGeral() {
        List<Agendamento> lista = agendamentoController.listarTodos();
        
        int total = lista.size();
        int concluidos = 0;
        double faturamento = 0.0;

        // Passa por cada agendamento somando os valores se o status for "Concluído".
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
