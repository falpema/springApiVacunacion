package com.falpema.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author fabian.peñaloza
 *
 */
@Entity
@Table(name = "T_TIPO_VACUNA")
public class TTipoVacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo", nullable = false, precision = 4, scale = 0)
	private String codigo;
	@Column(name = "descripcion", nullable = false, precision = 20, scale = 0)
	private String descripcion;

	public TTipoVacuna(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public TTipoVacuna() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
