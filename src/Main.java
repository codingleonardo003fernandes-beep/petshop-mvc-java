import controller.AgendamentoController;
import controller.FuncionarioController;
import controller.HistoricoController;
import controller.PagamentoController;
import controller.PetController;
import controller.RelatorioController;
import controller.ServicoController;
import controller.TutorController;

import view.AgendamentoView;
import view.FuncionarioView;
import view.HistoricoView;
import view.PagamentoView;
import view.PetView;
import view.RelatorioView;
import view.ServicoView;
import view.TutorView;

import util.ArquivoUtil;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final String PASTA_DADOS = "dados";
    private static final String ARQUIVO_ESTADO = "dados/sistema_petshop.dat";

    public static void main(String[] args) {
        EstadoSistema estado = carregarEstado();

        TutorView tutorView = new TutorView(estado.tutorController);
        FuncionarioView funcionarioView = new FuncionarioView(estado.funcionarioController);
        HistoricoView historicoView = new HistoricoView(estado.historicoController);
        PetView petView = new PetView(estado.petController, estado.historicoController);
        ServicoView servicoView = new ServicoView(estado.servicoController);

        AgendamentoView agendamentoView = new AgendamentoView(
                estado.agendamentoController,
                estado.petController,
                estado.servicoController
        );

        PagamentoView pagamentoView = new PagamentoView(
                estado.pagamentoController,
                estado.agendamentoController
        );

        RelatorioController relatorioController = new RelatorioController(estado.agendamentoController);
        RelatorioView relatorioView = new RelatorioView(relatorioController);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
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
                        salvarEstado(estado);
                        break;

                    case 0:
                        salvarEstado(estado);
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
        System.out.println("       SISTEMA PET SHOP MVC");
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

    private static EstadoSistema carregarEstado() {
        try {
            EstadoSistema estado = (EstadoSistema) ArquivoUtil.carregarObjeto(ARQUIVO_ESTADO);
            System.out.println("Dados carregados com sucesso!");
            return estado;

        } catch (Exception e) {
            System.out.println("Nenhum dado salvo encontrado. Iniciando sistema novo.");
            return new EstadoSistema();
        }
    }

    private static void salvarEstado(EstadoSistema estado) {
        try {
            Files.createDirectories(Path.of(PASTA_DADOS));
            ArquivoUtil.salvarObjeto(estado, ARQUIVO_ESTADO);
            System.out.println("Dados salvos com sucesso!");

        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível salvar os dados: " + e.getMessage());
        }
    }

    private static class EstadoSistema implements Serializable {
        private static final long serialVersionUID = 1L;

        private TutorController tutorController = new TutorController();
        private FuncionarioController funcionarioController = new FuncionarioController();
        private PetController petController = new PetController();
        private HistoricoController historicoController = new HistoricoController();
        private ServicoController servicoController = new ServicoController();
        private AgendamentoController agendamentoController = new AgendamentoController();
        private PagamentoController pagamentoController = new PagamentoController();
    }
}