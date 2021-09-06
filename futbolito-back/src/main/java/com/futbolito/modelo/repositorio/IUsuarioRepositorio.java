package com.futbolito.modelo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futbolito.modelo.entidades.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByMail(String nombreUsuario);
    boolean existsByMail(String email);

}
