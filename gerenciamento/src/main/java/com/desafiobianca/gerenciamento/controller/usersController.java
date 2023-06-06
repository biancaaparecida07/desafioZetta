package com.desafiobianca.gerenciamento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Window;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/formeditar")//verbo HTTP
    public String carregaPaginaFormeditar(String cpf, Model model) {
        var usuario = repository.getReferenceById(cpf);
        model.addAttribute("usuario", usuario);
        return "usuarios/formeditar"; 
    }

    @GetMapping("/formulario")//verbo HTTP
    public String carregaPaginaFormulario(Model model) {
        return "usuarios/formulario"; 
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAllByOrderByNomeAsc());
        return "usuarios/listagem";
    }

    @PostMapping
    public String cadastraUser(DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);

        if((dados.sexo()=='M')||(dados.sexo()=='F')){
                repository.save(usuario);
        }
        return "redirect:/usuarios"; }

        //     return "redirect:/usuarios"; //uso da palavra chave redirect que é um recurdo do spring com a url para redirecionar e então não duplica código do método carregaPaginaListagem. O redirect é via método get, então é como se estivéssemos chamando o carregaPaginaListagem. Então não precisamos também passar o Model novamente e nem editar a variavel lista em vários lugares caso um dia altere algo.

    @DeleteMapping
    public String removeUsuario(String cpf){
        repository.deleteById(cpf);
        return "redirect:/usuarios";
    }

    // public Boolean VerificaCampoVazio(String campo){
    //     return((campo!=null)&&(campo.isBlank()==false));
    // }
    
}

/*A Servlet que aplica o new na classe controladora (usersController) e chama o método carregaPaginaFormulario(). */
