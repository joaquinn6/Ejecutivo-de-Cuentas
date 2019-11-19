package com.cuentasejecutivo.controller;

import java.util.ArrayList;
import java.util.List;

import com.cuentasejecutivo.model.Direccion;
import com.cuentasejecutivo.model.Documento;
import com.cuentasejecutivo.model.Natural;
import com.cuentasejecutivo.model.Referencia;
import com.cuentasejecutivo.model.Socio;
import com.cuentasejecutivo.model.Telefono;
import com.cuentasejecutivo.model.Trabajo;

import FactoryMethod.FactoriaDeSocios;
import FactoryMethod.SocioF;


public class ExampleFinalSubmit {
    private FactoriaDeSocios factoria = new FactoriaDeSocios();
	private void submit(){
		//datos optenido de la web
		boolean natOJur = true; 
		Natural natural = new Natural(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		List<Direccion> direcciones = new ArrayList();
		List<Documento> documentos=new ArrayList();
		List<Referencia> referencias=new ArrayList();;
		Socio s= new Socio(null, null, null, null, null, null, null, null, null, null, null, null);
		List<Telefono> telefonos =new ArrayList();;
		Trabajo trabajo = new Trabajo(null, null, null, null, null, null, null, null, null);		
		
		SocioF socio = factoria.getSocio(natOJur, natural, direcciones, documentos, referencias, s, telefonos, trabajo);
        socio.insertar();
	}
	
}
