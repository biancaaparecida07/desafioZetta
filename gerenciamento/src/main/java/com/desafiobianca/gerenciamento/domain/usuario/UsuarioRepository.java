package com.desafiobianca.gerenciamento.domain.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    public List<Usuario> findAllByOrderByNomeAsc();
}
