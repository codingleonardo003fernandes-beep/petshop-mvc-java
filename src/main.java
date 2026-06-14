import controller.AgendamentoController;
import controller.RelatorioController;
import controller.PetController;
import controller.HistoricoController;
import view.AgendamentoView;
import view.RelatorioView;
import view.PetView;
import view.HistoricoView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa os controladores do sistema
        AgendamentoController agendamentoController = new AgendamentoController();
        RelatorioController relatorioController = new RelatorioController(agendamentoController);
        PetController petController = new PetController();
        HistoricoController historicoController = new HistoricoController();

        // Inicializa as telas do sistema
        AgendamentoView agendamentoView = new AgendamentoView(agendamentoController);
        RelatorioView relatorioView = new RelatorioView(relatorioController);
        PetView petView = new PetView(petController, historicoController);
        HistoricoView historicoView = new HistoricoView(historicoController);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Loop principal do terminal
        do {
            System.out.println("\n=================================");
            System.out.println("    PET SHOP - MENU CENTRAL      ");
            System.out.println("=================================");
            System.out.println("1. Módulo de Agendamentos");
            System.out.println("2. Módulo de Relatórios");
            System.out.println("3. Módulo de Pets");
            System.out.println("4. Módulo de Históricos");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: agendamentoView.exibirMenu(); break;
                    case 2: relatorioView.exibirMenu(); break;
                    case 3: petView.exibirMenu(); break;
                    case 4: historicoView.exibirMenu(); break;
                    case 0: System.out.println("Encerrando o sistema. Até logo!"); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("[ERRO] Escolha uma opção válida.");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}
