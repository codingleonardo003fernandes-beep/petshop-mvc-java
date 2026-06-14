package view;

import controller.ServicoController;
import model.Servico;
import java.util.Scanner;

public class ServicoView {
    private ServicoController controller;
    private Scanner scanner;

    public ServicoView(ServicoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== MENU DE SERVIÇOS ===");
            System.out.println("1 - Cadastrar Serviço");
            System.out.println("2 - Listar Serviços");
            System.out.println("3 - Alterar Serviço");
            System.out.println("4 - Deletar Serviço");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do serviço: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço (ex: 50,00): ");
                        double preco = scanner.nextDouble();
                        System.out.print("Duração em minutos: ");
                        int duracao = scanner.nextInt();
                        controller.cadastrar(nome, preco, duracao);
                        System.out.println("Serviço cadastrado com sucesso!");
                        break;
                    case 2:
                        System.out.println("\n--- Lista de Serviços ---");
                        for (Servico s : controller.listar()) {
                            System.out.println("ID: " + s.getId() + " | " + s.getNome() + " | R$ " + s.calcularPreco());
                        }
                        break;
                    case 3:
                        System.out.print("ID do serviço a alterar: ");
                        int idAlt = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        controller.alterar(idAlt, novoNome, novoPreco);
                        System.out.println("Alterado com sucesso!");
                        break;
                    case 4:
                        System.out.print("ID do serviço a deletar: ");
                        int idDel = scanner.nextInt();
                        controller.deletar(idDel);
                        System.out.println("Deletado com sucesso!");
                        break;
                    case 5:
                        System.out.println("Voltando...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado na digitação.");
                scanner.nextLine();
            }
        }
    }
}