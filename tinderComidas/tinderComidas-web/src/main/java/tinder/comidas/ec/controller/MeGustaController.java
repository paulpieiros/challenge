package tinder.comidas.ec.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.model.StreamedContent;

import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.model.Usuario;
import tinder.comidas.ec.service.ComidaService;
import tinder.comidas.ec.util.SessionUtils;

@ManagedBean(name = "meGustaManager")
@ViewScoped
public class MeGustaController {

	@Inject
	ComidaService comidaService;
	
	private Comida comida;
	
	private Queue<Comida> colaComida;
	
	private StreamedContent imagenContent;
	
	@PostConstruct
	private void init() {
		
		comida = new Comida();
		colaComida = new LinkedList<>();
		
		HttpSession session = SessionUtils.getSession();
		
		Usuario usuario = new Usuario();
		usuario.setId(Long.valueOf(session.getAttribute("userid").toString()));
		List<Comida> listaComidaSinMegusta = comidaService.findComidaSinMeGustaByUsuario(usuario);
		
		for(Comida comida :listaComidaSinMegusta) {
			colaComida.add(comida);
		}
		
		if(!colaComida.isEmpty()) {
			this.comida = colaComida.peek();
			session.setAttribute("comidaId", this.comida.getId());
			
		}
		
	}
	
	
	public void guardarMeGusta(Boolean meGusta) {
	
		HttpSession session = SessionUtils.getSession();
		Usuario usuario = new Usuario();
		usuario.setId(Long.valueOf(session.getAttribute("userid").toString()));
		comidaService.guardarMeGusta(usuario, this.comida, meGusta);
		cambiarSiguiente();
	}
	
	private void cambiarSiguiente() {
		HttpSession session = SessionUtils.getSession();
		if(colaComida.poll() != null){
			this.comida = colaComida.peek();
			if(this.comida!=null)
			session.setAttribute("comidaId", this.comida.getId());
		}
	}
	
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public Queue<Comida> getColaComida() {
		return colaComida;
	}

	public void setColaComida(Queue<Comida> colaComida) {
		this.colaComida = colaComida;
	}

	public StreamedContent getImagenContent() {
		return imagenContent;
	}

	public void setImagenContent(StreamedContent imagenContent) {
		this.imagenContent = imagenContent;
	}
	
	
}
