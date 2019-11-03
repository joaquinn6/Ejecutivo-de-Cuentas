package com.cuentasejecutivo.model;

public class Trabajo {
	private Integer codigoSocio;
	private String tipoEmpresa;
	private String nombreEmpresa;
	private String fechaIngreso;
	private String direccion;
	private String telefono;
	private String funcion;
	private String tipoContrato;
  private String cargo;
	public Trabajo(Integer codigoSocio, String tipoEmpresa, String nombreEmpresa, String fechaIngreso, String direccion,
			String telefono, String funcion, String tipoContrato, String cargo) {
		super();
		this.codigoSocio = codigoSocio;
		this.tipoEmpresa = tipoEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.fechaIngreso = fechaIngreso;
		this.direccion = direccion;
		this.telefono = telefono;
		this.funcion = funcion;
		this.tipoContrato = tipoContrato;
    this.cargo = cargo;
  }
	public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
  public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
