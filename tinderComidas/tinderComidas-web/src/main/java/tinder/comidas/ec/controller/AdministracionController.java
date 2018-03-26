package tinder.comidas.ec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;

import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.service.ComidaService;

@ManagedBean(name = "adminManager")
@ViewScoped
public class AdministracionController {

	@Inject
	ComidaService comidaService;
	
	private List<Comida> comidaList;
	
	private Comida comida;
	
	private String nombreImagen;
	
	
	@PostConstruct
	private void init() {
	
		comidaList = new ArrayList<>();
		comida = new Comida();
		nombreImagen = "";
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		this.comida.setImagen(event.getFile().getContents());
		this.nombreImagen = event.getFile().getFileName();
	}
	public void guardarComida(){
		
		comidaService.create(comida);
		cleanVariables();
	}
	
	public void cleanVariables(){
		this.comida = new Comida();
		this.nombreImagen = "";
	}
	
	public List<Comida> getComidaList() {
		
		comidaList = comidaService.findAll();
		return comidaList;
	}
	public void setComidaList(List<Comida> comidaList) {
		this.comidaList = comidaList;
	}


	public Comida getComida() {
		return comida;
	}


	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	
	
}
