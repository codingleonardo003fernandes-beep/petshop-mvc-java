package view;

import controller.PagamentoController;
import model.Pagamento;
import java.util.Scanner;

public class PagamentoView {
    private PagamentoController controller;
    private Scanner scanner;

    public PagamentoView(PagamentoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n=== MENU DE PAGAMENTOS ===");
            System.out.println("1 - Registrar Novo Pagamento");
            System.out.println("2 - Listar Pagamentos");
            System.out.println("3 - Quitar Pagamento (Mudar para Pago)");
            System.out.println("4 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Valor do pagamento (ex: 100,50): ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Método (PIX, Cartão, Dinheiro): ");
                        String metodo = scanner.nextLine();
                        controller.registrarPagamento(valor, metodo);
                        System.out.println("Pagamento registrado como Pendente.");
                        break;
                    case 2:
                        System.out.println("\n--- Lista de Pagamentos ---");
                        for (Pagamento p : controller.listar()) {
                            System.out.println("ID: " + p.getId() + " | R$ " + p.getValor() + " | " + p.getMetodoPagamento() + " | Status: " + p.getStatus());
                        }
                        break;
                    case 3:
                        System.out.print("ID do pagamento a quitar: ");
                        int idQuit = scanner.nextInt();
                        controller.quitarPagamento(idQuit);
                        System.out.println("Pagamento quitado com sucesso!");
                        break;
                    case 4:
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