package com.desafiobianca.gerenciamento.domain.usuario;

import java.time.LocalDate;

public class Usuario extends Pessoa{
    private String cargo;


    private LocalDate dataCadastro;

    public Usuario(DadosCadastroUsuario dados) {
        super(dados.nome(), dados.cpf(), dados.datanasc(), dados.sexo());
        this.cargo = dados.cargo();
        this.dataCadastro = LocalDate.now();
    }

    public String getCargo() {
        return cargo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return super.toString()+", cargo=" + cargo + ", Data de Cadastro=" + dataCadastro + "]";
    }
    
}
