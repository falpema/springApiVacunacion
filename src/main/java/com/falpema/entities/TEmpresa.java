package com.falpema.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "T_EMPRESA")
public class TEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_CODIGO", nullable = false, precision = 3, scale = 0)
	private int empCodigo;
	@Column(name = "EMP_CODIGO_SAP", length = 4, nullable = true)
	private Short empCodigoSap;
	@Column(name = "EMP_ACTIVIDAD", length = 1, nullable = false)
	private String empActividad;
	@Column(name = "EMP_DESCRIPCION", length = 100, nullable = false)
	private String empDescripcion;
	@Column(name = "EMP_RUC", length = 14, nullable = false)
	private String empRuc;
	@Column(name = "EMP_FEC_CONST", nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date empFecConst;
	@Column(name = "EMP_FEC_CREO", nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP) 
	private Date empFecCreo;
	@Column(name = "EMP_FEC_MODIFICO", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date empFecModifico;
	@Column(name = "EMP_USUARIO_CREO", length = 8, nullable = false)
	private String empUsuarioCreo;
	@Column(name = "EMP_USUARIO_MODIFICO", length = 8, nullable = true)
	private String empUsuarioModifico;
	@Column(name = "EMP_GERENTE", length = 30, nullable = true)
	private String empGerente;
	@Column(name = "EMP_PRESIDENTE", length = 30, nullable = true)
	private String empPresidente;
	@Column(name = "EMP_CONTADOR", length = 30, nullable = true)
	private String empContador;
	@Column(name = "EMP_VIG_NOM_GER", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date empVigNomGer;
	@Column(name = "EMP_VIG_NOM_PRES", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date empVigNomPres;
	@Column(name = "EMP_VIG_NOM_CONT", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date empVigNomCont;
	@Column(name = "EMP_CAPITAL", nullable = true, precision = 11, scale = 2)
	private BigDecimal empCapital;
	@Column(name = "EMP_CAPITAL_PAGADO", nullable = true, precision = 11, scale = 2)
	private BigDecimal empCapitalPagado;
	@Column(name = "EMP_ESTADO", length = 1, nullable = false)
	private String empEstado;
	@Column(name = "EMP_SID", length = 15, nullable = true)
	private String empSid;
	@Column(name = "EMP_RRHH", length = 30, nullable = true)
	private String empRrhh;
	public int getEmpCodigo() {
		return empCodigo;
	}
	public void setEmpCodigo(int empCodigo) {
		this.empCodigo = empCodigo;
	}
	
	
	public Short getEmpCodigoSap() {
		return empCodigoSap;
	}
	public void setEmpCodigoSap(Short empCodigoSap) {
		this.empCodigoSap = empCodigoSap;
	}
	public String getEmpActividad() {
		return empActividad;
	}
	public void setEmpActividad(String empActividad) {
		this.empActividad = empActividad;
	}
	public String getEmpDescripcion() {
		return empDescripcion;
	}
	public void setEmpDescripcion(String empDescripcion) {
		this.empDescripcion = empDescripcion;
	}
	public String getEmpRuc() {
		return empRuc;
	}
	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}
	public Date getEmpFecConst() {
		return empFecConst;
	}
	public void setEmpFecConst(Date empFecConst) {
		this.empFecConst = empFecConst;
	}
	public Date getEmpFecCreo() {
		return empFecCreo;
	}
	public void setEmpFecCreo(Date empFecCreo) {
		this.empFecCreo = empFecCreo;
	}
	public Date getEmpFecModifico() {
		return empFecModifico;
	}
	public void setEmpFecModifico(Date empFecModifico) {
		this.empFecModifico = empFecModifico;
	}
	public String getEmpUsuarioCreo() {
		return empUsuarioCreo;
	}
	public void setEmpUsuarioCreo(String empUsuarioCreo) {
		this.empUsuarioCreo = empUsuarioCreo;
	}
	public String getEmpUsuarioModifico() {
		return empUsuarioModifico;
	}
	public void setEmpUsuarioModifico(String empUsuarioModifico) {
		this.empUsuarioModifico = empUsuarioModifico;
	}
	public String getEmpGerente() {
		return empGerente;
	}
	public void setEmpGerente(String empGerente) {
		this.empGerente = empGerente;
	}
	public String getEmpPresidente() {
		return empPresidente;
	}
	public void setEmpPresidente(String empPresidente) {
		this.empPresidente = empPresidente;
	}
	public String getEmpContador() {
		return empContador;
	}
	public void setEmpContador(String empContador) {
		this.empContador = empContador;
	}
	public Date getEmpVigNomGer() {
		return empVigNomGer;
	}
	public void setEmpVigNomGer(Date empVigNomGer) {
		this.empVigNomGer = empVigNomGer;
	}
	public Date getEmpVigNomPres() {
		return empVigNomPres;
	}
	public void setEmpVigNomPres(Date empVigNomPres) {
		this.empVigNomPres = empVigNomPres;
	}
	public Date getEmpVigNomCont() {
		return empVigNomCont;
	}
	public void setEmpVigNomCont(Date empVigNomCont) {
		this.empVigNomCont = empVigNomCont;
	}
	public BigDecimal getEmpCapital() {
		return empCapital;
	}
	public void setEmpCapital(BigDecimal empCapital) {
		this.empCapital = empCapital;
	}
	public BigDecimal getEmpCapitalPagado() {
		return empCapitalPagado;
	}
	public void setEmpCapitalPagado(BigDecimal empCapitalPagado) {
		this.empCapitalPagado = empCapitalPagado;
	}
	public String getEmpEstado() {
		return empEstado;
	}
	public void setEmpEstado(String empEstado) {
		this.empEstado = empEstado;
	}
	public String getEmpSid() {
		return empSid;
	}
	public void setEmpSid(String empSid) {
		this.empSid = empSid;
	}
	public String getEmpRrhh() {
		return empRrhh;
	}
	public void setEmpRrhh(String empRrhh) {
		this.empRrhh = empRrhh;
	}
	
	

}
