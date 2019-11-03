package com.cuentasejecutivo.model;

public class Direccion {
	private Integer codigoSocio;
	private String tipoDireccion;
	private String pais;
	private String departamento;
	private String Ciudad;
	private String barrioComarca;
	private String dirrecionDomiciliar;
	private String tipoPropiedad;
	public Direccion(Integer codigoSocio, String tipoDireccion, String pais, String departamento, String Ciudad,
			String barrioComarca, String dirrecionDomiciliar, String tipoPropiedad) {
		super();
		this.codigoSocio = codigoSocio;
		this.tipoDireccion = tipoDireccion;
		this.pais = pais;
		this.departamento = departamento;
		this.Ciudad = Ciudad;
		this.barrioComarca = barrioComarca;
		this.dirrecionDomiciliar = dirrecionDomiciliar;
		this.tipoPropiedad = tipoPropiedad;
  }
	public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String Ciudad) {
		this.Ciudad = Ciudad;
	}
	public String getBarrioComarca() {
		return barrioComarca;
	}
	public void setBarrioComarca(String barrioComarca) {
		this.barrioComarca = barrioComarca;
	}
	public String getDirrecionDomiciliar() {
		return dirrecionDomiciliar;
	}
	public void setDirrecionDomiciliar(String dirrecionDomiciliar) {
		this.dirrecionDomiciliar = dirrecionDomiciliar;
	}
	public String getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
}
