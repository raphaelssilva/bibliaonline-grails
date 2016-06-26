package biz.r2s.security

class UsuarioService {

    public Usuario getUsuarioByLogin(String login){
		return Usuario.find("from Usuario where login=='${login}'");
	}
}
