package tinder.comidas.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tinder.comidas.ec.enums.Estado;
import tinder.comidas.ec.enums.TipoUsuario;
import tinder.comidas.ec.model.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Usuario> findAll(){
		
		TypedQuery<Usuario> q = em.createQuery("Select distinct u from Usuario u where u.estado = :estado and u.tipoUsuario = :tipoUsuario", Usuario.class);
		q.setParameter("estado", Estado.ACT);
		q.setParameter("tipoUsuario", TipoUsuario.NORMAL);
		return q.getResultList();
		
	}
	
	public Usuario validate(String usuario, String password){
		
		try {
			TypedQuery<Usuario> q = em.createQuery("Select distinct u from Usuario u where u.estado = :estado and u.nombre = :usuario and u.password = :password", Usuario.class);
			q.setParameter("estado", Estado.ACT);
			q.setParameter("usuario", usuario);
			q.setParameter("password", password);
			return q.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	
	
}
