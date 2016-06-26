package biz.r2s.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

class MyAuthenticationProviderService implements AuthenticationProvider{

	static String USER_DEFAULT = "admin";
	static String PASS_DEFAULT = "r19892";
	
	def usuarioService
	

	Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		println "authenticate"
		if (!supports(auth.getClass())) {
            return null;
        }
		
		//se ja foi autenticado, ignora processo 
		if (auth.isAuthenticated()) {
			return auth;
		}
		
		String login = (String) auth.getPrincipal();
		String senha = (String) auth.getCredentials();
		boolean autenticado = false;
		Usuario usuario = null;
		
		println "USER_DEFAULT"
		try {
			if(login.equals(USER_DEFAULT)){
				println "USER_DEFAULT"
				usuario = new Usuario([login:login, senha:senha])
			}else{
				println "OUTROS"
				usuario = usuarioService.getUsuarioByLogin(login);
			}
						
			if(usuario&&usuario.senha.equals(senha)){
				println "SENHA"
				autenticado = true
			}
		} catch (Exception e) {
			throw new AuthenticationServiceException(
					"Não foi possivel autenticar o usuario'" + usuario+ "'", e);
		}
		
		if (!autenticado) {
			throw new BadCredentialsException("Credenciais inválidas");
		}

		try {
			println "SET authentication"
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					usuario, auth.getCredentials(), (usuario.login.equals(USER_DEFAULT)?[new GrantedAuthorityImpl("ROLE_ADMIN"),
							new GrantedAuthorityImpl("ROLE_USER")]:[new GrantedAuthorityImpl("ROLE_USER")]));
			return authentication;
		} catch (Exception e) {
			throw new AuthenticationServiceException(
					"Não foi possivel obter os dados do usuario '" + login + "'", e);
		}
	}

	boolean supports(Class<? extends Object> authentication) {
		return Usuario.class.isAssignableFrom(authentication) ||
				UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	

}
