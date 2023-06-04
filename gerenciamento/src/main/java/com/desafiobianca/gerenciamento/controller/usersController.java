package com.desafiobianca.gerenciamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/formulario")//verbo HTTP
    public String carregaPaginaFormulario() {
        return "usuarios/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", usuarios);
        return "usuarios/listagem";
    }

    @PostMapping
    public String cadastraUser(DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        usuarios.add(usuario);

        return "redirect:/usuarios"; //uso da palavra chave redirect que é um recurdo do spring com a url para redirecionar e então não duplica código do método carregaPaginaListagem. O redirect é via método get, então é como se estivéssemos chamando o carregaPaginaListagem. Então não precisamos também passar o Model novamente e nem editar a variavel lista em vários lugares caso um dia altere algo. 
    }
    
}

/*A Servlet que aplica o new na classe controladora (usersController) e chama o método carregaPaginaFormulario(). */
