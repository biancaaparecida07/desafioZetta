package com.desafiobianca.gerenciamento.domain.usuario;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity //A classe filme é uma entidade, representando uma tabela no banco, que é a Usuários
@Table(name="usuarios")
@PrimaryKeyJoinColumn(name = "cpf")
public class Usuario extends Pessoa{

    private String cargo;
    private LocalDateTime datacadastro;

    public Usuario(){}

    public Usuario(DadosCadastroUsuario dados) {
        super(dados.nome(), dados.cpf(), dados.datanasc(), dados.sexo());
        this.cargo = dados.cargo();
        this.datacadastro = LocalDateTime.now();
    }

    public String getCargo() {
        return cargo;
    }

    public LocalDateTime getDataCadastro() {
        return datacadastro;
    }

    @Override
    public String toString() {
        return super.toString()+", cargo=" + cargo + ", Data de Cadastro=" + datacadastro + "]";
    }
    
}
