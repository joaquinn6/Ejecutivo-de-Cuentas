package com.cuentasejecutivo.model;

public class Natural {
	private Integer codigoSocio;
	private String apellidoPaterno;
  private String apellidoMaterno;
  private String nombres;
	private String nacionalidad;
	private String profesion;
	private String nivelEducacional;
	private String estadoCivil;
  private String fechaNacimiento;
  private String tipoVivienda;
  private Integer numeroDependencia;
  private String estado;
  private String sectorEconomico;
  private String actividadPrincipal;
  private String actividadSecundaria;
  private String ocupacion;
  
  
	public Natural() {
	super();
}
	public Natural(Integer codigoSocio, String apellidoPaterno, String apellidoMaterno, String nombres, String nacionalidad,
			String profesion, String nivelEducacional, String estadoCivil, String fechaNacimiento, String tipoVivienda,
      Integer numeroDependencia, String estado, String sectorEconomico, String actividadPrincipal, String actividadSecundaria, String ocupacion) {
		super();
		this.codigoSocio = codigoSocio;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.nacionalidad = nacionalidad;
		this.profesion = profesion;
		this.nivelEducacional = nivelEducacional;
		this.estadoCivil = estadoCivil;
    this.fechaNacimiento = fechaNacimiento;
		this.tipoVivienda = tipoVivienda;
		this.numeroDependencia = numeroDependencia;
		this.estado = estado;
		this.sectorEconomico = sectorEconomico;
		this.actividadPrincipal = actividadPrincipal;
		this.actividadSecundaria = actividadSecundaria;
		this.ocupacion = ocupacion;
  }
  public Integer getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(Integer codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }
  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }
  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }
  public String getNombres() {
    return nombres;
  }
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  public String getNacionalidad() {
    return nacionalidad;
  }
  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }
  public String getProfesion() {
    return profesion;
  }
  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }
  public String getNivelEducacional() {
    return nivelEducacional;
  }
  public void setNivelEducacional(String nivelEducacional) {
    this.nivelEducacional = nivelEducacional;
  }
  public String getEstadoCivil() {
    return estadoCivil;
  }
  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public String getTipoVivienda() {
    return tipoVivienda;
  }
  public void setTipoVivienda(String tipoVivienda) {
    this.tipoVivienda = tipoVivienda;
  }
  public Integer getNumeroDependencia() {
    return numeroDependencia;
  }
  public void setNumeroDependencia(Integer numeroDependencia) {
    this.numeroDependencia = numeroDependencia;
  }
  public String getEstado() {
    return estado;
  }
  public void setEstado(String estado) {
    this.estado = estado;
  }
  public String getSectorEconomico() {
    return sectorEconomico;
  }
  public void setSectorEconomico(String sectorEconomico) {
    this.sectorEconomico = sectorEconomico;
  }
  public String getActividadPrincipal() {
    return actividadPrincipal;
  }
  public void setActividadPrincipal(String actividadPrincipal) {
    this.actividadPrincipal = actividadPrincipal;
  }
  public String getactividadSecundaria() {
    return actividadSecundaria;
  }
  public void setActividadSecundaria(String actividadSecundaria) {
    this.actividadSecundaria = actividadSecundaria;
  }
  public String getOcupacion() {
    return ocupacion;
  }
  public void setOcupacion(String ocupacion) {
    this.ocupacion = ocupacion;
  }
}
