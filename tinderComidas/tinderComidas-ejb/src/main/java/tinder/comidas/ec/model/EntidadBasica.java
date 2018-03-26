package tinder.comidas.ec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import tinder.comidas.ec.enums.Estado;

@MappedSuperclass
public abstract class EntidadBasica {

	public abstract Long getId();

	public abstract void setId(Long id);

	public boolean isPersisted() {
		return getId() != null;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO", nullable = false)
	private Estado estado = Estado.ACT;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
