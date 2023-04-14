package sda.ejemplo.services;

import sda.ejemplo.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
