package com.falpema.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "T_EMPLEADO")
public class TEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cedula", nullable = false, precision = 19, scale = 0)
	private String cedula;
	
	@Column(name = "NOMBRES", length = 30, nullable = false)
	private String nombres; 
	
	@Column(name = "APELLIDOS", length = 40, nullable = false)
	private String apellidos; 
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "direccion", length = 50, nullable = true)
	private String direccion;
	
	@Column(name = "telefonoMovil", length = 15, nullable = true)
	private String telefonoMovil;
	
	@Column(name = "vacunado", length = 2, nullable = true)
	private String vacunado;
	
	@Column(name = "usuario", length = 12, nullable = true)
	private String usuario;
	
	@Column(name = "password", length = 12, nullable = true)
	private String password;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getVacunado() {
		return vacunado;
	}

	public void setVacunado(String vacunado) {
		this.vacunado = vacunado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TEmpleado(String cedula, String nombres, String apellidos, String email, Date fechaNacimiento,
			String direccion, String telefonoMovil, String vacunado, String usuario, String password) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefonoMovil = telefonoMovil;
		this.vacunado = vacunado;
		this.usuario = usuario;
		this.password = password;
	}
	
	
    
}
