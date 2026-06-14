import controller.AgendamentoController;
import controller.RelatorioController;
import view.AgendamentoView;
import view.RelatorioView;
import java.util.Scanner;

// Classe principal que une as suas duas telas de teste em um menu unificado.
public class Main {
    public static void main(String[] args) {
        // Inicialização dos controladores
        AgendamentoController agendamentoController = new AgendamentoController();
        RelatorioController relatorioController = new RelatorioController(agendamentoController);

        // Inicialização das telas (Views)
        AgendamentoView agendamentoView = new AgendamentoView(agendamentoController);
        RelatorioView relatorioView = new RelatorioView(relatorioController);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Loop do menu inicial do programa
        do {
            System.out.println("\n=================================");
            System.out.println("    PET SHOP - MENU PRINCIPAL    ");
            System.out.println("=================================");
            System.out.println("1. Menu de Agendamentos (Sua Parte)");
            System.out.println("2. Menu de Relatórios (Sua Parte)");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        agendamentoView.exibirMenu();
                        break;
                    case 2:
                        relatorioView.exibirMenu();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("[ERRO] Escolha uma opção válida.");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}
