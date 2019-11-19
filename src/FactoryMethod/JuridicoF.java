package FactoryMethod;

import java.util.List;

import com.cuentasejecutivo.model.Direccion;
import com.cuentasejecutivo.model.Documento;
import com.cuentasejecutivo.model.Referencia;
import com.cuentasejecutivo.model.Socio;
import com.cuentasejecutivo.model.Telefono;
import com.cuentasejecutivo.model.Trabajo;

public class JuridicoF extends SocioF{
	
	public JuridicoF(List<Direccion> direcciones, List<Documento> documentos,
			List<Referencia> referencias, Socio socio, List<Telefono> telefonos, Trabajo trabajo) {
		super(null, direcciones, documentos, referencias, socio, telefonos, trabajo);
		this.direcciones = direcciones;
		this.documentos = documentos;
		this.referencias = referencias;
		this.socio = socio;
		this.telefonos = telefonos;
		this.trabajo = trabajo;
	}
	
	public void insertar(){
	
	}
	
	public void actualizar(){
		
	}
	
	public void eliminar(){
		
	}
	
	public void mostrarTodos(){
		
	}
	
	public void mostrarUno(){
		
	}
	
}
