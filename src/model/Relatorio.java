package model;

import java.io.Serializable;

public class Relatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    private int totalAgendamentos;
    private double faturamentoTotal;
    private int totalConcluidos;

    public Relatorio(int totalAgendamentos, double faturamentoTotal, int totalConcluidos) {
        this.totalAgendamentos = totalAgendamentos;
        this.faturamentoTotal = faturamentoTotal;
        this.totalConcluidos = totalConcluidos;
    }


    public void exibirResumo() {
        System.out.println("\n====== RESUMO DO RELATÓRIO GERADO ======");
        System.out.println("Total de Agendamentos no Sistema : " + totalAgendamentos);
        System.out.println("Agendamentos Concluídos/Pagos    : " + totalConcluidos);
        System.out.println("Faturamento Total Acumulado      : R$ " + faturamentoTotal);
        System.out.println("===========================================");
    }
}
