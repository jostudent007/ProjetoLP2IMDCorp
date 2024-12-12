package model;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    //Construtor Parametrizado
    public Endereco(String rua, Integer numero, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return rua + ", " + numero + ", " + bairro + ", " + cidade + ", CEP: " + cep;
    }

    //Gets e Sets
    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
