package view;

import controller.PetController;
import controller.HistoricoController;
import model.Cachorro;
import model.Gato;
import model.Animal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetView {
    private PetController petController;
    private HistoricoController historicoController;
    private Scanner scanner;

    public PetView(PetController petController, HistoricoController historicoController) {
        this.petController = petController;
        this.historicoController = historicoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        do {
            System.out.println("\n--- GESTÃO DE PETS ---");
            System.out.println("1. Cadastrar Cachorro");
            System.out.println("2. Cadastrar Gato");
            System.out.println("3. Listar todos os Pets");
            System.out.println("4. Alterar Pet");
            System.out.println("5. Remover Pet");
            System.out.println("0. Voltar");
            printSemQuebra("Escolha: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: cadastrarCachorro(); break;
                    case 2: cadastrarGato(); break;
                    case 3: listarPets(); break;
                    case 4: alterarPet(); break;
                    case 5: removerPet(); break;
                    case 0: System.out.println("Retornando..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERRO] Digite apenas números inteiros.");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    private void cadastrarCachorro() {
        System.out.println("\n--- NOVO CACHORRO ---");
        printSemQuebra("Nome: ");
        String nome = scanner.nextLine();

        printSemQuebra("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        printSemQuebra("Raça: ");
        String raca = scanner.nextLine();

        printSemQuebra("Dono/Tutor: ");
        String tutor = scanner.nextLine();

        printSemQuebra("Porte (Pequeno/Médio/Grande): ");
        String porte = scanner.nextLine();

        Cachorro c = new Cachorro(nome, idade, raca, tutor, porte);
        petController.cadastrar(c);

        historicoController.registrarEvento(nome, "Cadastrado como Cachorro.");
    }

    private void cadastrarGato() {
        System.out.println("\n--- NOVO GATO ---");
        printSemQuebra("Nome: ");
        String nome = scanner.nextLine();

        printSemQuebra("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        printSemQuebra("Raça: ");
        String raca = scanner.nextLine();

        printSemQuebra("Dono/Tutor: ");
        String tutor = scanner.nextLine();

        printSemQuebra("É castrado? (true/false): ");
        boolean castrado = scanner.nextBoolean();
        scanner.nextLine();

        Gato g = new Gato(nome, idade, raca, tutor, castrado);
        petController.cadastrar(g);

        historicoController.registrarEvento(nome, "Cadastrado como Gato.");
    }

    private void listarPets() {
        System.out.println("\n--- LISTA DE ANIMAIS ---");

        if (petController.listarTodos().isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        for (Animal a : petController.listarTodos()) {
            System.out.println(a + " | Som: " + a.emitirSom());
        }
    }

    private void alterarPet() {
        System.out.println("\n--- ALTERAR PET ---");

        printSemQuebra("Digite o nome atual do pet: ");
        String nomeAtual = scanner.nextLine();

        Animal pet = petController.buscarPorNome(nomeAtual);

        if (pet == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        printSemQuebra("Novo nome: ");
        String novoNome = scanner.nextLine();

        printSemQuebra("Nova idade: ");
        int novaIdade = scanner.nextInt();
        scanner.nextLine();

        printSemQuebra("Nova raça: ");
        String novaRaca = scanner.nextLine();

        printSemQuebra("Novo dono/tutor: ");
        String novoTutor = scanner.nextLine();

        if (petController.alterar(nomeAtual, novoNome, novaIdade, novaRaca, novoTutor)) {
            System.out.println("Pet alterado com sucesso!");
            historicoController.registrarEvento(novoNome, "Dados do pet alterados.");
        } else {
            System.out.println("Erro ao alterar pet.");
        }
    }

    private void removerPet() {
        printSemQuebra("Digite o nome do pet para remover: ");
        String nome = scanner.nextLine();

        if (petController.deletar(nome)) {
            System.out.println("Pet removido!");
            historicoController.registrarEvento(nome, "Removido do cadastro.");
        } else {
            System.out.println("Pet não encontrado.");
        }
    }

    private void printSemQuebra(String texto) {
        System.out.print(texto);
    }
}