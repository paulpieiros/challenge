package tinder.comidas.ec.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import tinder.comidas.ec.enums.TipoUsuario;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@TableGenerator(name = "usuarioSeq", initialValue = 10, table = "secuencias", allocationSize = 1, pkColumnName="Seq", pkColumnValue="usuario")

public class Usuario extends EntidadBasica {

	@Id
	@GeneratedValue(generator = "usuarioSeq")
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_USUARIO", nullable = false)
	private TipoUsuario tipoUsuario = TipoUsuario.NORMAL;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL , fetch = FetchType.LAZY )  
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

	public String getPassword() {
		return password;
	}

	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ComidaUsuario> getComidaUsuarios() {
		return comidaUsuarios;
	}

	public void setComidaUsuarios(Set<ComidaUsuario> comidaUsuarios) {
		this.comidaUsuarios = comidaUsuarios;
	}

	
}
