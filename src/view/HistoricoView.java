package view;

import controller.HistoricoController;
import model.Historico;
import java.util.Scanner;

public class HistoricoView {
    private HistoricoController controller;
    private Scanner scanner;

    public HistoricoView(HistoricoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("\n--- CONSULTA DE HISTÓRICOS ---");
            System.out.println("1. Ver Histórico Geral do Pet Shop");
            System.out.println("2. Filtrar Histórico por Pet");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    mostrarGeral();
                } else if (opcao == 2) {
                    filtrarPorPet();
                }
            } catch (Exception e) {
                System.out.println("Erro na leitura da opção.");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    private void mostrarGeral() {
        System.out.println("\n--- HISTÓRICO COMPLETO ---");
        if (controller.listarTodos().isEmpty()) {
            System.out.println("Nenhum evento registrado.");
            return;
        }
        for (Historico h : controller.listarTodos()) {
            System.out.println(h);
        }
    }

    private void filtrarPorPet() {
        System.out.print("Digite o nome do Pet: ");
        String nome = scanner.nextLine();
        System.out.println("\n--- HISTÓRICO DO PET: " + nome + " ---");

        if (controller.listarPorPet(nome).isEmpty()) {
            System.out.println("Nenhum evento para este animal.");
            return;
        }
        for (Historico h : controller.listarPorPet(nome)) {
            System.out.println(h);
        }
    }
}