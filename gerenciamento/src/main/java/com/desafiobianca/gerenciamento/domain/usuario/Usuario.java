package com.desafiobianca.gerenciamento.domain.usuario;

public class Usuario extends Pessoa{
    private String cargo;

    public Usuario(DadosCadastroUsuario dados) {
        super(dados.nome(), dados.cpf(), dados.datanasc(), dados.sexo());
        this.cargo = dados.cargo();
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return super.toString()+", cargo=" + cargo + "]";
    }
    
}
