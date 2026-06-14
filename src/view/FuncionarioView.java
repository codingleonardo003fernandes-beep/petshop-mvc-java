package model.view;

import model.controller.FuncionarioController;
import model.model.Funcionario;
import java.util.Scanner;

public class FuncionarioView {
    private FuncionarioController controller;
    private Scanner scanner;

    public FuncionarioView(FuncionarioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n=== MENU DE FUNCIONÁRIOS ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Alterar Funcionário");
            System.out.println("4 - Deletar Funcionário");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = scanner.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Salário: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine();
                        controller.cadastrar(nome, telefone, endereco, cargo, salario);
                        System.out.println("Funcionário cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("\n--- Lista de Funcionários ---");
                        for (Funcionario f : controller.listar()) {
                            System.out.println("ID: " + f.getId()
                                + " | Nome: " + f.getNome()
                                + " | Tel: " + f.getTelefone()
                                + " | Cargo: " + f.getCargo()
                                + " | Salário: R$ " + f.getSalario());
                        }
                        break;

                    case 3:
                        System.out.print("ID do funcionário a alterar: ");
                        int idAlt = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo telefone: ");
                        String novoTelefone = scanner.nextLine();
                        System.out.print("Novo endereço: ");
                        String novoEndereco = scanner.nextLine();
                        System.out.print("Novo cargo: ");
                        String novoCargo = scanner.nextLine();
                        System.out.print("Novo salário: ");
                        double novoSalario = scanner.nextDouble();
                        scanner.nextLine();
                        controller.alterar(idAlt, novoNome, novoTelefone, novoEndereco, novoCargo, novoSalario);
                        System.out.println("Funcionário alterado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID do funcionário a deletar: ");
                        int idDel = scanner.nextInt();
                        controller.deletar(idDel);
                        System.out.println("Funcionário deletado com sucesso!");
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
                System.out.println("Erro na digitação.");
                scanner.nextLine();
            }
        }
    }
}
