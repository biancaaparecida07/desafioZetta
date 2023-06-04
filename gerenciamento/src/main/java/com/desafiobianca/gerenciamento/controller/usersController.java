package com.desafiobianca.gerenciamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiobianca.gerenciamento.domain.usuario.DadosCadastroUsuario;
import com.desafiobianca.gerenciamento.domain.usuario.Usuario;

@Controller
@RequestMapping("/usuarios")
public class usersController { 

    private List<Usuario> usuarios = new ArrayList<>(); //Armazenamento inicial em lista. 
 
    /*Quando uma requisição com a URL /usuarios é recebida, a Servlet do Spring analisa a URL e identifica qual controlador está mapeado para /usuários. */
    @GetMapping //verbo HTTP
    public String carregaPaginaFormulario(){
        return "usuarios/formulario";
    }


    @PostMapping
    public String cadastraUser(DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        usuarios.add(usuario);
        System.out.println(usuarios);
        return "usuarios/formulario";
    }
    
}

/*A Servlet que aplica o new na classe controladora (usersController) e chama o método carregaPaginaFormulario(). */
