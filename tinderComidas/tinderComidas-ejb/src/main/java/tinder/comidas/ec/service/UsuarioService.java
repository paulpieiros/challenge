package tinder.comidas.ec.service;

import javax.ejb.Local;

import tinder.comidas.ec.model.Usuario;

@Local
public interface UsuarioService {

	Usuario find(Long id);
	void create(Usuario usuario);
	Usuario validate(String usuario, String password);
}
