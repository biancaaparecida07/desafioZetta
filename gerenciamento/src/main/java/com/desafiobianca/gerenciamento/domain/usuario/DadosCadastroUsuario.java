package com.desafiobianca.gerenciamento.domain.usuario;

import java.sql.Date;

//O Record foi utilizado por representar uma classe imutável.
public record DadosCadastroUsuario (String nome, Integer cpf, Date data, Character sexo, String cargo){

}
