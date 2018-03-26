package tinder.comidas.ec.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tinder.comidas.ec.dao.UsuarioDao;
import tinder.comidas.ec.model.Usuario;
import tinder.comidas.ec.service.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@EJB
	UsuarioDao usuarioDao;
	
	@Override
	public Usuario validate(String usuario, String password) {
		
		return usuarioDao.validate(usuario, password);
	}

	@Override
	public Usuario find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub

	}
	
	

}
