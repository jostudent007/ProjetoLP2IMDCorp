package operations;

import dao.BancoDAO;
import entities.Pessoa;
import entities.Professor;
import entities.TecnicoADM;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.*;

//Classe Operacoes e Métodos solicitados no projeto
public class Operacoes {

    private static final Scanner scanner = new Scanner(System.in);
    private final BancoDAO banco = BancoDAO.getInstance();

    public void cadastrarProfessor() {
        System.out.println("Cadastro de Professor:");
        Professor professor = criarProfessor();
        professor.setSalario(professor.calculaSalario()); 
        banco.getFuncionarios().add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public void cadastrarTecnicoADM() {
        System.out.println("Cadastro de Técnico ADM:");
        TecnicoADM tecnicoADM = criarTecnicoADM();
        tecnicoADM.setSalario(tecnicoADM.calculaSalario()); 
        banco.getFuncionarios().add(tecnicoADM);
        System.out.println("Técnico ADM cadastrado com sucesso!");
    }

    public void listarProfessores() {
        System.out.println("Lista de Professores:");
        banco.getFuncionarios().stream()
                .filter(p -> p instanceof Professor)
                .map(p -> (Professor) p)
                .forEach(prof -> System.out.printf("Nome: %s | Disciplinas: %s\n", prof.getNome(), prof.getDisciplinas()));
    }

    public void listarTecnicosADM() {
        System.out.println("Lista de Técnicos ADM:");
        banco.getFuncionarios().stream()
                .filter(p -> p instanceof TecnicoADM)
                .map(p -> (TecnicoADM) p)
                .forEach(tecnico -> System.out.printf("Nome: %s | Função Gratificada: %b\n",
                tecnico.getNome(), tecnico.isFuncaoGratificada()));
    }

    public void buscarProfessor(int matricula) {
        Pessoa professor = banco.getFuncionarios().stream()
                .filter(p -> p instanceof Professor && p.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
        if (professor != null) {
            System.out.println(professor);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void buscarTecnicoADM(int matricula) {
        Pessoa tecnico = banco.getFuncionarios().stream()
                .filter(p -> p instanceof TecnicoADM && p.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
        if (tecnico != null) {
            System.out.println(tecnico);
        } else {
            System.out.println("Técnico ADM não encontrado.");
        }
    }

    public void deletarProfessor(int matricula) {
        boolean removido = banco.getFuncionarios().removeIf(p -> p instanceof Professor && p.getMatricula() == matricula);
        if (removido) {
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    public void deletarTecnicoADM(int matricula) {
        boolean removido = banco.getFuncionarios().removeIf(p -> p instanceof TecnicoADM && p.getMatricula() == matricula);
        if (removido) {
            System.out.println("Técnico ADM removido com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    private Professor criarProfessor() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        Genero genero = escolherGenero();
        Endereco endereco = criarEndereco();
        System.out.print("Matrícula: ");
        long matricula = Long.parseLong(scanner.nextLine());
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());
        LocalDate dataIngresso = LocalDate.now();
        Nivel nivel = escolherNivel();
        Formacao formacao = escolherFormacao();
        System.out.print("Disciplinas (separadas por vírgula): ");
        List<String> disciplinas = List.of(scanner.nextLine().split(","));

        return new Professor(nome, cpf, dataNascimento, genero, endereco, matricula, departamento,
                cargaHoraria, dataIngresso, nivel, formacao, disciplinas);
    }

    private TecnicoADM criarTecnicoADM() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        Genero genero = escolherGenero();
        Endereco endereco = criarEndereco();
        System.out.print("Matrícula: ");
        long matricula = Long.parseLong(scanner.nextLine());
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());
        LocalDate dataIngresso = LocalDate.now();
        Nivel nivel = escolherNivel();
        Formacao formacao = escolherFormacao();
        System.out.print("Insalubridade (true/false): ");
        boolean insalubridade = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Função Gratificada (true/false): ");
        boolean funcaoGratificada = Boolean.parseBoolean(scanner.nextLine());

        return new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, matricula, departamento,
                cargaHoraria, dataIngresso, nivel, formacao, insalubridade, funcaoGratificada);
    }

    private Endereco criarEndereco() {
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        return new Endereco(rua, numero, bairro, cidade, cep);
    }

    private Genero escolherGenero() {
        System.out.println("Escolha o Gênero (1-MASC, 2-FEM, 3-OUTRO):");
        int opcao = Integer.parseInt(scanner.nextLine());
        return Genero.values()[opcao - 1];
    }

    private Nivel escolherNivel() {
        System.out.println("Escolha o Nível (1 a 8):");
        int opcao = Integer.parseInt(scanner.nextLine());
        return Nivel.values()[opcao - 1];
    }

    private Formacao escolherFormacao() {
        System.out.println("Escolha a Formação (1-ESPECIALIZACAO, 2-MESTRADO, 3-DOUTORADO):");
        int opcao = Integer.parseInt(scanner.nextLine());
        return Formacao.values()[opcao - 1];
    }
}
