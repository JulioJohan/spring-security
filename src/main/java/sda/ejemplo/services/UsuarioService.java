package sda.ejemplo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sda.ejemplo.dao.IUsuarioDao;
import sda.ejemplo.entity.Usuario;
import sda.ejemplo.utils.LoginUsuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{

	private Logger logger= LoggerFactory.getLogger(UsuarioService.class);

	
	@Autowired
	IUsuarioDao usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);

	}

	@Override
	@Transactional(readOnly= true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario==null) {
			throw new UsernameNotFoundException("Error: no existe el usuario"+ username);
		}
		
		logger.info("Usuario: "+ usuario.getUsername());
		
		return LoginUsuario.build(usuario);		
	}

}
