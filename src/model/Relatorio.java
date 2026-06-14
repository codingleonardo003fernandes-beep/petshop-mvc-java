package model;

// Esta classe guarda as informações calculadas para o relatório geral.
public class Relatorio {
    private int totalAgendamentos;
    private double faturamentoTotal;
    private int totalConcluidos;

    // Construtor do Relatório
    public Relatorio(int totalAgendamentos, double faturamentoTotal, int totalConcluidos) {
        this.totalAgendamentos = totalAgendamentos;
        this.faturamentoTotal = faturamentoTotal;
        this.totalConcluidos = totalConcluidos;
    }

    // Exibe os números na tela de forma visual e organizada.
    public void exibirResumo() {
        System.out.println("\n====== RESUMO DO RELATÓRIO GERADO ======");
        System.out.println("Total de Agendamentos no Sistema : " + totalAgendamentos);
        System.out.println("Agendamentos Concluídos/Pagos    : " + totalConcluidos);
        System.out.println("Faturamento Total Acumulado      : R$ " + faturamentoTotal);
        System.out.println("===========================================");
    }
}
