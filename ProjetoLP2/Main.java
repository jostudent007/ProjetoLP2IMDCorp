
import dao.BancoDAO;
import java.util.Scanner;
import operations.Operacoes;

public class Main {

    public static void main(String[] args) {

        BancoDAO banco = BancoDAO.getInstance();
        Operacoes operacoes = new Operacoes();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> banco.salvarDados()));

        //Menu interativo para o usuário
        while (true) {
            System.out.println("\nSistema de Gerenciamento IMDCorp");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Técnico ADM");
            System.out.println("3. Listar Professores");
            System.out.println("4. Listar Técnicos ADM");
            System.out.println("5. Buscar Professor");
            System.out.println("6. Buscar Técnico ADM");
            System.out.println("7. Deletar Professor");
            System.out.println("8. Deletar Técnico ADM");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 ->
                    operacoes.cadastrarProfessor();
                case 2 ->
                    operacoes.cadastrarTecnicoADM();
                case 3 ->
                    operacoes.listarProfessores();
                case 4 ->
                    operacoes.listarTecnicosADM();
                case 5 -> {
                    System.out.print("Informe a matrícula do professor: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    operacoes.buscarProfessor(matricula);
                }
                case 6 -> {
                    System.out.print("Informe a matrícula do técnico: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    operacoes.buscarTecnicoADM(matricula);
                }
                case 7 -> {
                    System.out.print("Informe a matrícula do professor a ser deletado: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    operacoes.deletarProfessor(matricula);
                }
                case 8 -> {
                    System.out.print("Informe a matrícula do técnico a ser deletado: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    operacoes.deletarTecnicoADM(matricula);
                }
                case 9 -> {
                    System.out.println("Encerrando o sistema...");
                    System.exit(0);
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        }

    }
}
