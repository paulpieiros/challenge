package tinder.comidas.ec.service;

import java.util.List;

import javax.ejb.Local;

import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.model.Usuario;

@Local
public interface ComidaService {

	Comida find(Long id);
	List<Comida>findAll();
	List<Comida>findComidaSinMeGustaByUsuario(Usuario usuario);
	void create(Comida comida);
	void guardarMeGusta(Usuario usuario, Comida comida, Boolean meGusta);
	void delete(Comida comida);
}
