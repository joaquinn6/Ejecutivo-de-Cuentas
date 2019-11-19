package com.cuentasejecutivo.model;

public class Documento {
	private Integer codigoSocio;
	private String tipoDocumento;
	private String fechaReferencia;
	private String fechaCaducidad;
	private String paisEmision;

	
	public Documento() {
		super();
	}
	public Documento(Integer codigoSocio, String tipoDocumento, String fechaReferencia, String fechaCaducidad,
			String paisEmision) {
		super();
		this.codigoSocio = codigoSocio;
		this.tipoDocumento = tipoDocumento;
		this.fechaReferencia = fechaReferencia;
		this.fechaCaducidad = fechaCaducidad;
		this.paisEmision = paisEmision;
  }
	public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getFechaReferencia() {
		return fechaReferencia;
	}
	public void setFechaReferencia(String fechaReferencia) {
		this.fechaReferencia = fechaReferencia;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(String paisEmision) {
		this.paisEmision = paisEmision;
	}
	
}
