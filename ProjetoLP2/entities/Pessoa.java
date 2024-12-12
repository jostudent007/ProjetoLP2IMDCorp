package entities;

import java.io.Serializable;
import java.time.LocalDate;
import model.Endereco;
import model.Genero;

public abstract class Pessoa implements Serializable {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero genero;
    private Endereco endereco;
    private Long matricula;
    private Double salario;
    private String departamento;
    private Integer cargaHoraria;
    private LocalDate dataIngresso;

    //Construtor parametrizado
    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
            Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.matricula = matricula;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.dataIngresso = dataIngresso;
    }

    //Reescrita do Método toString para impressão de dados formatados
    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nCPF: " + cpf
                + "\nData de Nascimento: " + dataNascimento
                + "\nGênero: " + genero
                + "\nEndereço: " + (endereco != null ? endereco.toString() : "Não informado")
                + "\nMatrícula: " + matricula
                + "\nSalário: R$ " + (salario != null ? String.format("%.2f", salario) : "Não calculado")
                + "\nDepartamento: " + departamento
                + "\nCarga Horária: " + cargaHoraria
                + "\nData de Ingresso: " + dataIngresso;
    }

    public abstract Double calculaSalario();

    //Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
