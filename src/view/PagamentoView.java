package view;

import controller.PagamentoController;
import controller.AgendamentoController;
import model.Pagamento;
import model.Agendamento;

import java.util.Scanner;

public class PagamentoView {
    private PagamentoController controller;
    private AgendamentoController agendamentoController;
    private Scanner scanner;

    public PagamentoView(PagamentoController controller, AgendamentoController agendamentoController) {
        this.controller = controller;
        this.agendamentoController = agendamentoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== MENU DE PAGAMENTOS ===");
            System.out.println("1 - Registrar Novo Pagamento");
            System.out.println("2 - Listar Pagamentos");
            System.out.println("3 - Quitar Pagamento (Mudar para Pago)");
            System.out.println("4 - Alterar Pagamento");
            System.out.println("5 - Deletar Pagamento");
            System.out.println("6 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        if (agendamentoController.listarTodos().isEmpty()) {
                            System.out.println("Nenhum agendamento cadastrado. Cadastre um agendamento antes de registrar pagamento.");
                            break;
                        }

                        System.out.println("\n--- Agendamentos Disponíveis ---");
                        for (Agendamento a : agendamentoController.listarTodos()) {
                            System.out.println(a);
                        }

                        System.out.print("ID do agendamento que será pago: ");
                        int idAgendamento = scanner.nextInt();
                        scanner.nextLine();

                        Agendamento agendamento = agendamentoController.buscarPorId(idAgendamento);

                        System.out.print("Valor do pagamento: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Método (PIX, Cartão, Dinheiro): ");
                        String metodo = scanner.nextLine();

                        controller.registrarPagamento(valor, metodo, agendamento);
                        System.out.println("Pagamento registrado como Pendente.");
                        break;

                    case 2:
                        System.out.println("\n--- Lista de Pagamentos ---");

                        if (controller.listar().isEmpty()) {
                            System.out.println("Nenhum pagamento cadastrado.");
                            break;
                        }

                        for (Pagamento p : controller.listar()) {
                            System.out.println(p);
                        }
                        break;

                    case 3:
                        System.out.print("ID do pagamento a quitar: ");
                        int idQuit = scanner.nextInt();
                        scanner.nextLine();

                        controller.quitarPagamento(idQuit);
                        System.out.println("Pagamento quitado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID do pagamento a alterar: ");
                        int idAlt = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Novo valor: ");
                        double novoValor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Novo método (PIX, Cartão, Dinheiro): ");
                        String novoMetodo = scanner.nextLine();

                        controller.alterarPagamento(idAlt, novoValor, novoMetodo);
                        System.out.println("Pagamento alterado com sucesso!");
                        break;

                    case 5:
                        System.out.print("ID do pagamento a deletar: ");
                        int idDel = scanner.nextInt();
                        scanner.nextLine();

                        controller.deletarPagamento(idDel);
                        System.out.println("Pagamento deletado com sucesso!");
                        break;

                    case 6:
                        System.out.println("Voltando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro na digitação.");
                scanner.nextLine();
            }
        }
    }
}