package view;

import controller.RelatorioController;
import model.Relatorio;
import java.util.Scanner;

// Esta classe cuida da tela do menu de relatórios do Petshop.
public class RelatorioView {
    private RelatorioController controller;
    private Scanner scanner;

    public RelatorioView(RelatorioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("\n--- PAINEL DE RELATÓRIOS DO PET SHOP ---");
            System.out.println("1. Emitir Balanço Geral");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Digite sua opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                if (opcao == 1) {
                    Relatorio relatorioGerado = controller.gerarRelatorioGeral();
                    relatorioGerado.exibirResumo();
                } else if (opcao != 0) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao carregar o menu de relatórios.");
                scanner.nextLine(); 
            }
        } while (opcao != 0);
    }
}
