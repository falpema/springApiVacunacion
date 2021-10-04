package com.falpema.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TEmpleadoVacunaPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cedula", nullable = false, precision = 19, scale = 0)
	private String cedula;
	@Column(name = "tipo_vacuna", nullable = false, precision = 4, scale = 0)
	private String tipoVacuna;
	public TEmpleadoVacunaPK(String cedula, String tipoVacuna) {
		super();
		this.cedula = cedula;
		this.tipoVacuna = tipoVacuna;
	}
	public TEmpleadoVacunaPK() {
		super();
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTipoVacuna() {
		return tipoVacuna;
	}
	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}
	
	
}
