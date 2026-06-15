package view;

import controller.TutorController;
import model.Tutor;

import java.util.Scanner;

public class TutorView {
    private TutorController controller;
    private Scanner scanner;

    public TutorView(TutorController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n=== MENU DE TUTORES ===");
            System.out.println("1 - Cadastrar Tutor");
            System.out.println("2 - Listar Tutores");
            System.out.println("3 - Alterar Tutor");
            System.out.println("4 - Deletar Tutor");
            System.out.println("5 - Gerenciar Pets do Tutor");
            System.out.println("6 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("Endereço: ");
                        String endereco = scanner.nextLine();

                        controller.cadastrar(nome, telefone, endereco);
                        System.out.println("Tutor cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("\n--- Lista de Tutores ---");

                        if (controller.listar().isEmpty()) {
                            System.out.println("Nenhum tutor cadastrado.");
                            break;
                        }

                        for (Tutor t : controller.listar()) {
                            System.out.println("ID: " + t.getId()
                                    + " | Nome: " + t.getNome()
                                    + " | Tel: " + t.getTelefone()
                                    + " | End: " + t.getEndereco()
                                    + " | Pets: " + t.getPets());
                        }
                        break;

                    case 3:
                        System.out.print("ID do tutor a alterar: ");
                        int idAlt = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Novo telefone: ");
                        String novoTelefone = scanner.nextLine();

                        System.out.print("Novo endereço: ");
                        String novoEndereco = scanner.nextLine();

                        controller.alterar(idAlt, novoNome, novoTelefone, novoEndereco);
                        System.out.println("Tutor alterado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID do tutor a deletar: ");
                        int idDel = scanner.nextInt();
                        scanner.nextLine();

                        controller.deletar(idDel);
                        System.out.println("Tutor deletado com sucesso!");
                        break;

                    case 5:
                        System.out.print("ID do tutor: ");
                        int idPet = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("1 - Adicionar Pet");
                        System.out.println("2 - Remover Pet");
                        System.out.print("Escolha: ");
                        int opcaoPet = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome do pet: ");
                        String nomePet = scanner.nextLine();

                        if (opcaoPet == 1) {
                            controller.adicionarPet(idPet, nomePet);
                            System.out.println("Pet adicionado com sucesso!");
                        } else if (opcaoPet == 2) {
                            controller.removerPet(idPet, nomePet);
                            System.out.println("Pet removido com sucesso!");
                        } else {
                            System.out.println("Opção inválida!");
                        }
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