package com.desafiobianca.gerenciamento.domain.usuario;

import java.sql.Date;

//O Record foi utilizado por representar uma classe imutável.
public record DadosCadastroUsuario (String nome, String cpf, Date datanasc, Character sexo, String cargo){

}
