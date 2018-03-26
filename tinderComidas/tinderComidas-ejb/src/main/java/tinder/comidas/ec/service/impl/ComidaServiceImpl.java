package tinder.comidas.ec.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tinder.comidas.ec.dao.ComidaDao;
import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.model.Usuario;
import tinder.comidas.ec.service.ComidaService;

@Stateless
public class ComidaServiceImpl implements ComidaService {

	@EJB
	ComidaDao comidaDao;
	
	
	
	@Override
	public Comida find(Long id) {
		// TODO Auto-generated method stub
		return comidaDao.find(id);
	}

	@Override
	public List<Comida> findAll() {
		// TODO Auto-generated method stub
		return comidaDao.findAll();
	}

	@Override
	public List<Comida> findComidaSinMeGustaByUsuario(Usuario usuario) {
		
		return comidaDao.findComidaSinMeGustaByUsuario(usuario);
	}

	@Override
	public void create(Comida comida) {
		comidaDao.create(comida);
	}

	
	@Override
	public void guardarMeGusta(Usuario usuario, Comida comida, Boolean meGusta) {
		comidaDao.guardarMeGusta(usuario, comida, meGusta);
		
	}

	@Override
	public void delete(Comida comida) {
		// TODO Auto-generated method stub

	}

}
