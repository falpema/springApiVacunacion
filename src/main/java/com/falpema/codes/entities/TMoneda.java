package com.falpema.codes.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author falpema
 */
@Entity
@Table(name = "T_MONEDA")
public class TMoneda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MON_CODIGO")
	private String monCodigo;
	@Basic(optional = false)
	@Column(name = "MON_DESCRIPCION")
	private String monDescripcion;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "MON_COTIZACION")
	private BigDecimal monCotizacion;
	@Basic(optional = false)
	@Column(name = "MON_USUARIO_CREO")
	private String monUsuarioCreo;
	@Basic(optional = false)
	@Column(name = "MON_FECHA_CREO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date monFechaCreo;
	@Column(name = "MON_USUARIO_MODIFICO")
	private String monUsuarioModifico;
	@Column(name = "MON_FECHA_MODIFICO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date monFechaModifico;
	@Column(name = "MON_USUARIO_ELIMINO")
	private String monUsuarioElimino;
	@Column(name = "MON_FECHA_ELIMINO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date monFechaElimino;
	@Basic(optional = false)
	@Column(name = "MON_ESTADO")
	private short monEstado;

	public TMoneda() {
	}

	public TMoneda(String monCodigo) {
		this.monCodigo = monCodigo;
	}

	public TMoneda(String monCodigo, String monDescripcion, BigDecimal monCotizacion, String monUsuarioCreo,
			Date monFechaCreo, short monEstado) {
		this.monCodigo = monCodigo;
		this.monDescripcion = monDescripcion;
		this.monCotizacion = monCotizacion;
		this.monUsuarioCreo = monUsuarioCreo;
		this.monFechaCreo = monFechaCreo;
		this.monEstado = monEstado;
	}

	public String getMonCodigo() {
		return monCodigo;
	}

	public void setMonCodigo(String monCodigo) {
		this.monCodigo = monCodigo;
	}

	public String getMonDescripcion() {
		return monDescripcion;
	}

	public void setMonDescripcion(String monDescripcion) {
		this.monDescripcion = monDescripcion;
	}

	public BigDecimal getMonCotizacion() {
		return monCotizacion;
	}

	public void setMonCotizacion(BigDecimal monCotizacion) {
		this.monCotizacion = monCotizacion;
	}

	public String getMonUsuarioCreo() {
		return monUsuarioCreo;
	}

	public void setMonUsuarioCreo(String monUsuarioCreo) {
		this.monUsuarioCreo = monUsuarioCreo;
	}

	public Date getMonFechaCreo() {
		return monFechaCreo;
	}

	public void setMonFechaCreo(Date monFechaCreo) {
		this.monFechaCreo = monFechaCreo;
	}

	public String getMonUsuarioModifico() {
		return monUsuarioModifico;
	}

	public void setMonUsuarioModifico(String monUsuarioModifico) {
		this.monUsuarioModifico = monUsuarioModifico;
	}

	public Date getMonFechaModifico() {
		return monFechaModifico;
	}

	public void setMonFechaModifico(Date monFechaModifico) {
		this.monFechaModifico = monFechaModifico;
	}

	public String getMonUsuarioElimino() {
		return monUsuarioElimino;
	}

	public void setMonUsuarioElimino(String monUsuarioElimino) {
		this.monUsuarioElimino = monUsuarioElimino;
	}

	public Date getMonFechaElimino() {
		return monFechaElimino;
	}

	public void setMonFechaElimino(Date monFechaElimino) {
		this.monFechaElimino = monFechaElimino;
	}

	public short getMonEstado() {
		return monEstado;
	}

	public void setMonEstado(short monEstado) {
		this.monEstado = monEstado;
	}

	@Override
	public String toString() {
		return "CODES.TMoneda[ monCodigo=" + monCodigo + " ]";
	}

}
