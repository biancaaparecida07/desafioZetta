package com.desafiobianca.gerenciamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiobianca.gerenciamento.domain.usuario.DadosCadastroUsuario;
import com.desafiobianca.gerenciamento.domain.usuario.Usuario;
import com.desafiobianca.gerenciamento.domain.usuario.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class usersController { 

    @Autowired //instanciado quando necessário
    private UsuarioRepository repository;

    /*Quando uma requisição com a URL /usuarios é recebida, a Servlet do Spring analisa a URL e identifica qual controlador está mapeado para /usuários. */

    @GetMapping("/formulario")//verbo HTTP
    public String carregaPaginaFormulario() {
        return "usuarios/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "usuarios/listagem";
    }

    @PostMapping
    public String cadastraUser(DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        return "redirect:/usuarios"; //uso da palavra chave redirect que é um recurdo do spring com a url para redirecionar e então não duplica código do método carregaPaginaListagem. O redirect é via método get, então é como se estivéssemos chamando o carregaPaginaListagem. Então não precisamos também passar o Model novamente e nem editar a variavel lista em vários lugares caso um dia altere algo. 
    }
    
}

/*A Servlet que aplica o new na classe controladora (usersController) e chama o método carregaPaginaFormulario(). */
