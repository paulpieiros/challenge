package tinder.comidas.ec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@TableGenerator(name = "comidaUsuarioSeq", initialValue = 10, table = "secuencias", allocationSize = 1, pkColumnName="Seq", pkColumnValue="comidaUsuario")
public class ComidaUsuario extends EntidadBasica {

	@Id
	@GeneratedValue(generator = "comidaUsuarioSeq")
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Comida comida;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	private Boolean meGusta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Boolean meGusta) {
		this.meGusta = meGusta;
	}
}
