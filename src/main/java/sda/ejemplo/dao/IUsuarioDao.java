package sda.ejemplo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sda.ejemplo.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
