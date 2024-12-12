package entities;

import java.time.LocalDate;
import java.util.List;
import model.Endereco;
import model.Formacao;
import model.Funcionario;
import model.Genero;
import model.Nivel;

public class Professor extends Pessoa implements Funcionario{

    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;

    //Construtor parametrizado
    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
            Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
            Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso);
        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
    }

    //Método para calcular salário
    @Override
    public Double calculaSalario() {
        double salarioBase = 4000.0;
        double nivelBonus = 1 + (nivelProfessor.ordinal() * 0.05);
        double formacaoBonus = switch (formacaoProfessor) {
            case ESPECIALIZACAO ->
                0.25;
            case MESTRADO ->
                0.50;
            case DOUTORADO ->
                0.75;
        };
        return salarioBase * nivelBonus * (1 + formacaoBonus);
    }

    //Gets e Sets
    public Nivel getNivelProfessor() {
        return nivelProfessor;
    }

    public void setNivelProfessor(Nivel nivelProfessor) {
        this.nivelProfessor = nivelProfessor;
    }

    public Formacao getFormacaoProfessor() {
        return formacaoProfessor;
    }

    public void setFormacaoProfessor(Formacao formacaoProfessor) {
        this.formacaoProfessor = formacaoProfessor;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
