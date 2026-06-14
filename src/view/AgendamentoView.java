package view;

import controller.AgendamentoController;
import model.Agendamento;
import model.Animal;
import model.Servico;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

// Esta classe cuida dos menus interativos de agendamento no terminal.
public class AgendamentoView {
    private AgendamentoController controller;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public AgendamentoView(AgendamentoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    // Exibe o menu usando um loop do-while.
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

            // Tratamento de Exceção: Protege o sistema se o usuário digitar letras por engano.
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
                scanner.nextLine(); // Limpa o erro do teclado
            }
        } while (opcao != 0);
    }

    // Tela para cadastrar agendamento
    private void menuCadastrar() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");
        System.out.print("Digite o nome do Pet: ");
        String nomePet = scanner.nextLine();
        Animal petMock = new Animal(nomePet); 

        System.out.print("Digite o Serviço (Banho / Tosa / Consulta): ");
        String nomeServico = scanner.nextLine();
        System.out.print("Digite o preço: R$ ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); 

        Servico servicoMock = new Servico(nomeServico, preco); 

        System.out.print("Digite a data e hora (Ex: 25/06/2026 14:30): ");
        String dataStr = scanner.nextLine();

        try {
            LocalDateTime dataHora = LocalDateTime.parse(dataStr, formatter);
            controller.cadastrar(petMock, servicoMock, dataHora);
        } catch (Exception e) {
            System.out.println("[ERRO] Formato de data errado. Use dd/MM/yyyy HH:mm");
        }
    }

    // Tela de listagem
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

    // Tela de alteração
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

    // Tela de exclusão
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
