package com.cuentasejecutivo.model;

public class Referencia {
	private Integer codigoSocio;
	private String tipoReferencia;
	private String nombre;
	private String nombreTrabajo;
	private Integer mail;
	private String telefono;
	private String observacion;

	public Referencia(Integer codigoSocio, String tipoReferencia, String nombre, String nombreTrabajo, Integer mail,
			String telefono, String observacion) {
		super();
		this.codigoSocio = codigoSocio;
		this.tipoReferencia = tipoReferencia;
		this.nombre = nombre;
		this.nombreTrabajo = nombreTrabajo;
		this.mail = mail;
		this.telefono = telefono;
		this.observacion = observacion;
  }
	public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getTipoReferencia() {
		return tipoReferencia;
	}
	public void setTipoReferencia(String tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreTrabajo() {
		return nombreTrabajo;
	}
	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}
	public Integer getMail() {
		return mail;
	}
	public void setMail(Integer mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
