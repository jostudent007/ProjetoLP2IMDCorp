package entities;

import java.time.LocalDate;
import model.Endereco;
import model.Formacao;
import model.Funcionario;
import model.Genero;
import model.Nivel;

public class TecnicoADM extends Pessoa implements Funcionario {

    private Nivel nivelTecnico;
    private Formacao formacaoTecnico;
    private boolean insalubridade;
    private boolean funcaoGratificada;

    //Construtor parametrizado
    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco,
            Long matricula, String departamento, Integer cargaHoraria, LocalDate dataIngresso,
            Nivel nivelTecnico, Formacao formacaoTecnico, boolean insalubridade, boolean funcaoGratificada) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, departamento, cargaHoraria, dataIngresso);
        this.nivelTecnico = nivelTecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
    }

    //Método para calcular salário
    @Override
    public Double calculaSalario() {
        double salarioBase = 2500.0;
        double nivelBonus = 1 + (nivelTecnico.ordinal() * 0.03);
        double formacaoBonus = switch (formacaoTecnico) {
            case ESPECIALIZACAO ->
                0.25;
            case MESTRADO ->
                0.50;
            case DOUTORADO ->
                0.75;
        };
        double insalubridadeBonus = insalubridade ? 0.50 : 0.0;
        double funcaoGratificadaBonus = funcaoGratificada ? 0.50 : 0.0;
        return salarioBase * nivelBonus * (1 + formacaoBonus + insalubridadeBonus + funcaoGratificadaBonus);
    }

    //Gets e Sets
    public Nivel getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(Nivel nivelTecnico) {
        this.nivelTecnico = nivelTecnico;
    }

    public Formacao getFormacaoTecnico() {
        return formacaoTecnico;
    }

    public void setFormacaoTecnico(Formacao formacaoTecnico) {
        this.formacaoTecnico = formacaoTecnico;
    }

    public boolean isInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(boolean insalubridade) {
        this.insalubridade = insalubridade;
    }

    public boolean isFuncaoGratificada() {
        return funcaoGratificada;
    }

    public void setFuncaoGratificada(boolean funcaoGratificada) {
        this.funcaoGratificada = funcaoGratificada;
    }

}
