package FactoryMethod;

import java.util.List;

import com.cuentasejecutivo.model.*;

public abstract class SocioF {
	Natural natural;
	List<Direccion> direcciones;
	List<Documento> documentos;
	List<Referencia> referencias;
	Socio socio;
	List<Telefono> telefonos;
	Trabajo trabajo;
	public SocioF(Natural natural, List<Direccion> direcciones, List<Documento> documentos,
			List<Referencia> referencias, Socio socio, List<Telefono> telefonos, Trabajo trabajo) {
		super();
		this.natural = natural;
		this.direcciones = direcciones;
		this.documentos = documentos;
		this.referencias = referencias;
		this.socio = socio;
		this.telefonos = telefonos;
		this.trabajo = trabajo;
	}
	
	
	public abstract void insertar();
	
	public abstract void actualizar();
	
	public abstract void eliminar();
	
	public abstract void mostrarTodos();
	
	public abstract void mostrarUno();
	
}
