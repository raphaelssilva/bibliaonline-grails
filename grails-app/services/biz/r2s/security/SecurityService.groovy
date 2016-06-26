package biz.r2s.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SecurityService{

	@Override
	public Usuario getUsuarioAutenticado() {
		return (Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

}
