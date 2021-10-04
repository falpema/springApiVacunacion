package com.falpema.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 
 * @author fabian.peñaloza
 *
 */
@Entity
@Table(name = "t_empleado_vacuna")
public class TEmpleadoVacuna implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TEmpleadoVacunaPK empleadoVacunaPK;
	
	@Column(name = "fecha_vacuna")
	private Date fechaVacuna;

	public TEmpleadoVacuna(TEmpleadoVacunaPK empleadoVacunaPK, Date fechaVacuna) {
		super();
		this.empleadoVacunaPK = empleadoVacunaPK;
		this.fechaVacuna = fechaVacuna;
	}

	public TEmpleadoVacuna() {
		super();
	}

	public TEmpleadoVacunaPK getEmpleadoVacunaPK() {
		return empleadoVacunaPK;
	}

	public void setEmpleadoVacunaPK(TEmpleadoVacunaPK empleadoVacunaPK) {
		this.empleadoVacunaPK = empleadoVacunaPK;
	}

	public Date getFechaVacuna() {
		return fechaVacuna;
	}

	public void setFechaVacuna(Date fechaVacuna) {
		this.fechaVacuna = fechaVacuna;
	}
	
	
}
