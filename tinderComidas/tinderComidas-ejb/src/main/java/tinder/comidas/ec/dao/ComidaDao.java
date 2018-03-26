package tinder.comidas.ec.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tinder.comidas.ec.enums.Estado;
import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.model.ComidaUsuario;
import tinder.comidas.ec.model.Usuario;

@Stateless
public class ComidaDao {

	@PersistenceContext
	EntityManager em;
	
	@EJB
	UsuarioDao usuarioDao;
	
	public List<Comida>findAll(){
		List<Comida> result = new ArrayList<>();
		try {
			String sql = "SELECT COM.ID, COM.NOMBRE, COM.DESCRIPCION, COM.FECHA_CREACION, "
					+"(SELECT COUNT (*) FROM COMIDA C JOIN COMIDAUSUARIO CU ON C.ID = CU.COMIDA_ID WHERE CU.MEGUSTA = TRUE AND C.ID = COM.ID ) AS MEGUSTAN, "
					+"(SELECT COUNT (*) FROM COMIDA C JOIN COMIDAUSUARIO CU ON C.ID = CU.COMIDA_ID WHERE CU.MEGUSTA = FALSE AND C.ID = COM.ID ) AS NOMEGUSTAN, "
					+"(SELECT COUNT (*) FROM COMIDA C JOIN COMIDAUSUARIO CU ON C.ID = CU.COMIDA_ID WHERE CU.MEGUSTA IS NULL AND C.ID = COM.ID ) AS NOCONTESTADAS "
					+"FROM COMIDA AS COM";
			
			StringBuilder sb = new StringBuilder();
			sb.append(sql);
			Query query = em.createNativeQuery(sb.toString());
			
			
			List<Object[]> arrayDatos = query.getResultList();
			 for (Object[] datos : arrayDatos) {
				 Comida comida = new Comida();
				 comida.setId(Long.valueOf(datos[0].toString()));
				 comida.setNombre((String)datos[1]);
				 comida.setDescripcion((String)datos[2]);
				 comida.setFechaCreacion(Date.valueOf(datos[3].toString()));
				 comida.setNumeroMeGustan(Integer.valueOf(datos[4].toString()));
				 comida.setNumeroNoMeGustan(Integer.valueOf(datos[5].toString()));
				 comida.setNumeroNoContestados(Integer.valueOf(datos[6].toString()));
				 result.add(comida);
			 }
			
			
		}catch (Exception e) {

			return null;
		}
		
		return result;
	}
	
	public List<Comida>findComidaSinMeGustaByUsuario(Usuario usuario){
		
		TypedQuery<Comida> q = em.createQuery("Select distinct c from Comida c join c.comidaUsuarios cu where c.estado = :estado and cu.estado = :estado and cu.usuario.id =:usuarioId and cu.meGusta IS NULL", Comida.class);
		q.setParameter("estado", Estado.ACT);
		q.setParameter("usuarioId", usuario.getId());
		return q.getResultList();
	}
	
	public void create(Comida comida) {
		comida.setFechaCreacion(Calendar.getInstance().getTime());
		em.persist(comida);
		
		List<Usuario> listaUsuarios = usuarioDao.findAll();
		
		for(Usuario usuario : listaUsuarios){
			ComidaUsuario comidaUsuario = new ComidaUsuario();
			comidaUsuario.setUsuario(usuario);
			comidaUsuario.setComida(comida);
			comidaUsuario.setFechaCreacion(Calendar.getInstance().getTime());
			em.persist(comidaUsuario);
		}

	}
	
	public void guardarMeGusta(Usuario usuario, Comida comida, Boolean meGusta) {
		TypedQuery<ComidaUsuario> q = em.createQuery("Select distinct cu from ComidaUsuario cu where cu.estado = :estado and cu.usuario.id =:usuarioId and cu.comida.id = :comidaId and cu.meGusta IS NULL", ComidaUsuario.class);
		q.setParameter("estado", Estado.ACT);
		q.setParameter("usuarioId", usuario.getId());
		q.setParameter("comidaId", comida.getId());
		
		ComidaUsuario comidaUsuario= q.getSingleResult();
		comidaUsuario.setMeGusta(meGusta);
		comidaUsuario.setFechaActualizacion(Calendar.getInstance().getTime());
		
		em.merge(comidaUsuario);
	}
	
	public void delete(Comida comida) {
		
	}
	
	public Comida find(Long id){
		TypedQuery<Comida> q = em.createQuery("Select distinct c from Comida c where c.estado = :estado and c.id =:id", Comida.class);
		q.setParameter("estado", Estado.ACT);
		q.setParameter("id", id);
		
		return q.getSingleResult();
	}
	
}
