import controller.PersistenciaController;
import controller.RelatorioController;

import model.EstadoSistema;

import view.AgendamentoView;
import view.FuncionarioView;
import view.HistoricoView;
import view.PagamentoView;
import view.PetView;
import view.RelatorioView;
import view.ServicoView;
import view.TutorView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PersistenciaController persistenciaController = new PersistenciaController();
        EstadoSistema estado = persistenciaController.carregarEstado();

        TutorView tutorView = new TutorView(estado.getTutorController());
        FuncionarioView funcionarioView = new FuncionarioView(estado.getFuncionarioController());
        HistoricoView historicoView = new HistoricoView(estado.getHistoricoController());
        PetView petView = new PetView(estado.getPetController(), estado.getHistoricoController());
        ServicoView servicoView = new ServicoView(estado.getServicoController());

        AgendamentoView agendamentoView = new AgendamentoView(
                estado.getAgendamentoController(),
                estado.getPetController(),
                estado.getServicoController()
        );

        PagamentoView pagamentoView = new PagamentoView(
                estado.getPagamentoController(),
                estado.getAgendamentoController()
        );

        RelatorioController relatorioController = new RelatorioController(estado.getAgendamentoController());
        RelatorioView relatorioView = new RelatorioView(relatorioController);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            limparTela();
            exibirMenuPrincipal();

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        tutorView.exibirMenu();
                        break;
                    case 2:
                        funcionarioView.exibirMenu();
                        break;
                    case 3:
                        petView.exibirMenu();
                        break;
                    case 4:
                        servicoView.exibirMenu();
                        break;
                    case 5:
                        agendamentoView.exibirMenu();
                        break;
                    case 6:
                        pagamentoView.exibirMenu();
                        break;
                    case 7:
                        historicoView.exibirMenu();
                        break;
                    case 8:
                        relatorioView.exibirMenu();
                        break;
                    case 9:
                        persistenciaController.salvarEstado(estado);
                        break;
                    case 0:
                        persistenciaController.salvarEstado(estado);
                        System.out.println("Sistema encerrado. Dados salvos com sucesso!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Digite apenas números.");
            } catch (Exception e) {
                System.out.println("[ERRO] Ocorreu um problema no sistema: " + e.getMessage());
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n====================================");
        System.out.println("       SISTEMA - PET COM PET");
        System.out.println("====================================");
        System.out.println("1 - Gerenciar Tutores");
        System.out.println("2 - Gerenciar Funcionários");
        System.out.println("3 - Gerenciar Pets");
        System.out.println("4 - Gerenciar Serviços");
        System.out.println("5 - Gerenciar Agendamentos");
        System.out.println("6 - Gerenciar Pagamentos");
        System.out.println("7 - Consultar Histórico");
        System.out.println("8 - Emitir Relatórios");
        System.out.println("9 - Salvar Dados");
        System.out.println("0 - Salvar e Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}