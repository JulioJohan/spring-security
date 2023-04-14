package sda.ejemplo.auth.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sda.ejemplo.services.UsuarioService;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
	
	private Logger logger= LoggerFactory.getLogger(JwtEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		logger.error("Fallo al iniciar");
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Su inicio de sesion no esta autorizado");
	}
	

}
