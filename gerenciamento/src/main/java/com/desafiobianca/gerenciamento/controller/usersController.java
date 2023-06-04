package com.desafiobianca.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiobianca.gerenciamento.domain.usuario.DadosCadastroUsuario;

@Controller
@RequestMapping("/usuarios")
public class usersController { 
 
    /*Quando uma requisição com a URL /usuarios é recebida, a Servlet do Spring analisa a URL e identifica qual controlador está mapeado para /usuários. */
    @GetMapping //verbo HTTP
    public String carregaPaginaFormulario(){
        return "usuarios/formulario";
    }


    @PostMapping
    public String cadastraUser(DadosCadastroUsuario dados){
        System.out.println(dados);
        return "usuarios/formulario";
    }
    
}

/*A Servlet que aplica o new na classe controladora (usersController) e chama o método carregaPaginaFormulario(). */
