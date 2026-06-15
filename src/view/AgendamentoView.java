package view;

import controller.AgendamentoController;
import controller.PetController;
import controller.ServicoController;
import model.Agendamento;
import model.Animal;
import model.Servico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendamentoView {
    private AgendamentoController controller;
    private PetController petController;
    private ServicoController servicoController;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public AgendamentoView(AgendamentoController controller, PetController petController, ServicoController servicoController) {
        this.controller = controller;
        this.petController = petController;
        this.servicoController = servicoController;
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    public void exibirMenu() {
        int opcao = -1;

        do {
            System.out.println("\n--- GESTÃO DE AGENDAMENTOS ---");
            System.out.println("1. Novo Agendamento");
            System.out.println("2. Listar Agendamentos");
            System.out.println("3. Atualizar Agendamento (Data/Status)");
            System.out.println("4. Cancelar/Remover Agendamento");
            System.out.println("0. Voltar ao Menu Anterior");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: menuCadastrar(); break;
                    case 2: menuListar(); break;
                    case 3: menuAtualizar(); break;
                    case 4: menuDeletar(); break;
                    case 0: System.out.println("Retornando..."); break;
                    default: System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("[ERRO] Digite apenas números inteiros.");
                scanner.nextLine();
            }

        } while (opcao != 0);
    }

    private void menuCadastrar() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");

        if (petController.listarTodos().isEmpty()) {
            System.out.println("Nenhum pet cadastrado. Cadastre um pet antes de criar agendamento.");
            return;
        }

        if (servicoController.listar().isEmpty()) {
            System.out.println("Nenhum serviço cadastrado. Cadastre um serviço antes de criar agendamento.");
            return;
        }

        System.out.println("\n--- PETS CADASTRADOS ---");
        for (Animal pet : petController.listarTodos()) {
            System.out.println(pet);
        }

        System.out.print("Digite o nome do pet: ");
        String nomePet = scanner.nextLine();

        Animal petSelecionado = petController.buscarPorNome(nomePet);

        if (petSelecionado == null) {
            System.out.println("[ERRO] Pet não encontrado.");
            return;
        }

        System.out.println("\n--- SERVIÇOS CADASTRADOS ---");
        for (Servico servico : servicoController.listar()) {
            System.out.println("ID: " + servico.getId()
                    + " | " + servico.getNome()
                    + " | R$ " + servico.getPreco()
                    + " | Duração: " + servico.getDuracaoMinutos() + " min");
        }

        System.out.print("Digite o ID do serviço: ");
        int idServico = scanner.nextInt();
        scanner.nextLine();

        Servico servicoSelecionado = servicoController.buscarPorId(idServico);

        System.out.print("Digite a data e hora (Ex: 25/06/2026 14:30): ");
        String dataStr = scanner.nextLine();

        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataStr, formatter);
            controller.cadastrar(petSelecionado, servicoSelecionado, dataHora);
            System.out.println("Agendamento cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("[ERRO] Formato de data errado. Use dd/MM/yyyy HH:mm");
        }
    }

    private void menuListar() {
        System.out.println("\n--- LISTA DE AGENDAMENTOS ATIVOS ---");

        if (controller.listarTodos().isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
            return;
        }

        for (Agendamento a : controller.listarTodos()) {
            System.out.println(a);
        }
    }

    private void menuAtualizar() {
        System.out.println("\n--- ATUALIZAR AGENDAMENTO ---");
        System.out.print("Digite o ID do agendamento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Agendamento a = controller.buscarPorId(id);

        if (a == null) {
            System.out.println("Agendamento não localizado.");
            return;
        }

        System.out.print("Nova data e hora (Ex: 25/06/2026 16:00): ");
        String dataStr = scanner.nextLine();

        System.out.print("Novo Status (Pendente / Concluído / Cancelado): ");
        String status = scanner.nextLine();

        try {
            LocalDateTime novaData = LocalDateTime.parse(dataStr, formatter);

            if (controller.alterar(id, novaData, status)) {
                System.out.println("Agendamento modificado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("[ERRO] Erro ao processar a data.");
        }
    }

    private void menuDeletar() {
        System.out.println("\n--- EXCLUIR REGISTRO ---");
        System.out.print("Digite o ID a ser apagado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (controller.deletar(id)) {
            System.out.println("Agendamento removido.");
        } else {
            System.out.println("ID não encontrado.");
        }
    }
}