package tinder.comidas.ec.model;

import java.sql.Blob;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@TableGenerator(name = "comidaSeq", initialValue = 10, table = "secuencias", allocationSize = 1, pkColumnName="Seq", pkColumnValue="comida")
public class Comida extends EntidadBasica {

	@Id
	@GeneratedValue(generator = "comidaSeq")
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 100)
	private String descripcion;
	
	
	@Lob
	private byte[] imagen;
	
	
	@Transient
	private Integer numeroMeGustan;
	
	@Transient
	private Integer numeroNoMeGustan;
	
	@Transient
	private Integer numeroNoContestados;
	
	@OneToMany(mappedBy="comida", cascade=CascadeType.ALL , fetch = FetchType.LAZY )  
	private Set<ComidaUsuario>comidaUsuarios = new LinkedHashSet<ComidaUsuario>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumeroMeGustan() {
		return numeroMeGustan;
	}

	public void setNumeroMeGustan(Integer numeroMeGustan) {
		this.numeroMeGustan = numeroMeGustan;
	}

	public Integer getNumeroNoMeGustan() {
		return numeroNoMeGustan;
	}

	public void setNumeroNoMeGustan(Integer numeroNoMeGustan) {
		this.numeroNoMeGustan = numeroNoMeGustan;
	}

	public Integer getNumeroNoContestados() {
		return numeroNoContestados;
	}

	public void setNumeroNoContestados(Integer numeroNoContestados) {
		this.numeroNoContestados = numeroNoContestados;
	}

	public Set<ComidaUsuario> getComidaUsuarios() {
		return comidaUsuarios;
	}

	public void setComidaUsuarios(Set<ComidaUsuario> comidaUsuarios) {
		this.comidaUsuarios = comidaUsuarios;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	

	
}
