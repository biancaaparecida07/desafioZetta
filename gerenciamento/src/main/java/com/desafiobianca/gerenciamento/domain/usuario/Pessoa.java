package com.desafiobianca.gerenciamento.domain.usuario;

import java.sql.Date;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private Date datanasc;
    private Character sexo;


    public Pessoa(String nome, String cpf, Date datanasc, Character sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.sexo = sexo;
    }
    
    public String getNome() {
        return nome;
    }


    public String getCpf() {
        return cpf;
    }


    public Date getDatanasc() {
        return datanasc;
    }


    public Character getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", datanasc=" + datanasc + ", sexo=" + sexo + "]";
    }
}
