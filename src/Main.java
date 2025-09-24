import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Tarefa> tarefas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar o buffer
            } else {
                System.out.println("Opção inválida!");
                scanner.nextLine(); // limpar entrada inválida
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> marcarTarefa();
                case 4 -> desmarcarTarefa();
                case 5 -> removerTarefa();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void mostrarMenu() {
        System.out.println("""
                ===== TODO LIST =====
                1 - Adicionar tarefa
                2 - Listar tarefas
                3 - Marcar tarefa como concluída
                4 - Desmarcar tarefa
                5 - Remover tarefa
                0 - Sair
                Escolha uma opção:
                """);
    }

    static void adicionarTarefa() {
        System.out.println("Digite o título da tarefa: ");
        String titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("Título inválido! A tarefa não pode estar vazia.");
            return;
        }

        tarefas.add(new Tarefa(proximoId++, titulo));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
        } else {
            System.out.println("\n----- Suas Tarefas -----");
            for (Tarefa t : tarefas) {
                System.out.println(t);
            }
        }
    }

    static Tarefa encontrarTarefaPorId(int id) {
        for (Tarefa t : tarefas) {
            if (t.id == id) return t;
        }
        return null;
    }

    static void marcarTarefa() {
        listarTarefas();
        if (tarefas.isEmpty()) return;

        System.out.println("Digite o ID da tarefa para marcar como concluída: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ID inválido!");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa t = encontrarTarefaPorId(id);
        if (t != null) {
            t.marcarConcluida();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    static void desmarcarTarefa() {
        listarTarefas();
        if (tarefas.isEmpty()) return;

        System.out.println("Digite o ID da tarefa para desmarcar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ID inválido!");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa t = encontrarTarefaPorId(id);
        if (t != null) {
            t.desmarcarConcluida();
            System.out.println("Tarefa desmarcada com sucesso!");
        } else {
            System.out.println("ID não encontrado!");
        }
    }

    static void removerTarefa() {
        listarTarefas();
        if (tarefas.isEmpty()) return;

        System.out.println("Digite o ID da tarefa que deseja remover: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ID inválido!");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa t = encontrarTarefaPorId(id);
        if (t != null) {
            tarefas.remove(t);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("ID não encontrado!");
        }
    }
}
