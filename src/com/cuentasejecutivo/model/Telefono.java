package com.cuentasejecutivo.model;

public class Telefono {
	private Integer codigoSocio;
	private String tipoTelefono;
	private Integer numero;
	private String extension;

	public Telefono(Integer codigoSocio, String tipoTelefono, Integer numero, String extension) {
		super();
		this.codigoSocio = codigoSocio;
		this.tipoTelefono = tipoTelefono;
		this.numero = numero;
		this.extension = extension;
  }
	public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setFechaReferencia(Integer numero) {
		this.numero = numero;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

}
