package com.cuentasejecutivo.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
 
import com.cuentasejecutivo.dao.SocioDAO;
import com.cuentasejecutivo.model.Direccion;
import com.cuentasejecutivo.model.Documento;
import com.cuentasejecutivo.model.Natural;
import com.cuentasejecutivo.model.Referencia;
import com.cuentasejecutivo.model.Socio;
import com.cuentasejecutivo.model.Telefono;
import com.cuentasejecutivo.model.Trabajo;

/**
 * Servlet implementation class SocioController
 */
@WebServlet("/socioController")
public class SocioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	SocioDAO socioDao;
	boolean nuevo;
	Socio socio;
	Natural natural;
	List<Direccion> direcciones;
	List<Documento> documentos;
	List<Referencia> referencias;
	List<Telefono> telefonos;
	Trabajo trabajo;
	
	int codigoSocio=0;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			socioDao = new SocioDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SocioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "socioGet":
				socioGet(request, response);
				break;
			case "socioPost":
				socioPost(request, response);
				break;
			case "naturalGet":
				naturalGet(request, response);
				break;
			case "naturalPost":
				naturalPost(request, response);
				break;
			case "direccionGet":
				direccionGet(request, response);
				break;
			case "direccionPost":
				direccionPost(request, response);
				break;
			case "documentoGet":
				documentoGet(request, response);
				break;
			case "documentoPost":
				documentoPost(request, response);
				break;
			case "referenciaGet":
				referenciaGet(request, response);
				break;
			case "referenciaPost":
				referenciaPost(request, response);
				break;
			case "telefonoGet":
				telefonoGet(request, response);
				break;
			case "telefonoPost":
				telefonoPost(request, response);
				break;
			case "trabajoGet":
				trabajoGet(request, response);
				break;
			case "trabajoPost":
				trabajoPost(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}
	
	private void socioGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		socio = new Socio();
		if(Integer.parseInt(request.getParameter("id"))==0){
			nuevo=true;
		}else{
			socio = socioDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
			codigoSocio=Integer.parseInt(request.getParameter("id"));
			//jalar aqui los demas datoss
			request.setAttribute("socio", socio);
			nuevo=false;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/crearSocio.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void socioPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Calendar now= Calendar.getInstance();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    String n="Natural";
	    boolean impuestoLibre = false;

		System.out.println("Antes o despues del error");
		if (request.getParameter("Natural")==null){
	    	n="Juridico";
	    }
		if (request.getParameter("ExoneradoImpuesto")!=null){
	    	impuestoLibre=true;
	    }
		
		socio = new Socio(codigoSocio,
				n, 
				request.getParameter("Identificacion"), 
				request.getParameter("NombreUsual"), 
				request.getParameter("Relacion"), 
				request.getParameter("GrupoEconomico"),
				impuestoLibre,
				request.getParameter("RelacionAseguradora"),
				"Leon",
				"01",
				formato.format(now.getTime()),
				"Alondra Ruiz"
			);

		if (n=="Natural")
			naturalGet(request, response);
		else
			direccionGet(request, response);
	}
	
	private void naturalGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo){
			request.setAttribute("natural", natural);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/natural.jsp");
		dispatcher.forward(request, response);
	}
	private void naturalPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		natural = new Natural(codigoSocio,
				request.getParameter("ApellidoPaterno"),
				request.getParameter("ApellidoMaterno"),
				request.getParameter("Nombres"), 
				request.getParameter("Nacionalidad"), 
				request.getParameter("Profesion"),
				request.getParameter("NivelEducacional"),
				request.getParameter("EstadoCivil"),
				request.getParameter("FechaNacimiento"),
				request.getParameter("TipoVivienda"),
				Integer.parseInt(request.getParameter("NumeroDependencia")),
				request.getParameter("Estado"),
				request.getParameter("SectorEconomico"),
				request.getParameter("ActividadPrincipal"),
				request.getParameter("ActividadSecundaria"),
				request.getParameter("Ocupacion")
			);
		
		direccionGet(request, response);
	}

	private void direccionGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo){
			request.setAttribute("direccion", direcciones.get(0));
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/direccion.jsp");
		dispatcher.forward(request, response);
	}
	
	private void direccionPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo){
			direcciones.clear();
		
		direcciones.add(new Direccion(codigoSocio,
				request.getParameter("TipoDireccion"),
				request.getParameter("Pais"),
				request.getParameter("Departamento"), 
				request.getParameter("Ciudad"), 
				request.getParameter("BarrioComarca"),
				request.getParameter("DireccionDomiciliar"),
				request.getParameter("TipoPropiedad"))
				);
		
		telefonoGet(request, response);
	}
}
		
	private void telefonoGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			request.setAttribute("telefono", telefonos.get(0));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/telefono.jsp");
		dispatcher.forward(request, response);
	}
	
	private void telefonoPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			telefonos.clear();
		
		telefonos.add(new Telefono(codigoSocio,
				request.getParameter("TipoTelefono"),
				Integer.parseInt(request.getParameter("Numero")),
				request.getParameter("Extension")
			));
		trabajoGet(request, response);
	}
	

	private void trabajoGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo){
			request.setAttribute("trabajo", trabajo);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/trabajo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void trabajoPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
	trabajo =new Trabajo(codigoSocio,
				request.getParameter("TipoEmpresa"),
				request.getParameter("NombreEmpresa"),
				request.getParameter("FechaIngreso"),
				request.getParameter("Direccion"),
				request.getParameter("Telefono"),
				request.getParameter("Funcion"),
				request.getParameter("TipoContrato"),
				request.getParameter("Cargo"));
	
		referenciaGet(request, response);
	}
	
	private void referenciaGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			request.setAttribute("referencia", referencias.get(0));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/referencia.jsp");
		dispatcher.forward(request, response);
	}
	
	private void referenciaPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			referencias.clear();
		
		referencias.add(new Referencia(codigoSocio,
				request.getParameter("TipoReferencia"),
				request.getParameter("Nombre"),
				request.getParameter("NombreTrabajo"),
				request.getParameter("Mail"),
				request.getParameter("Telefono"),
				request.getParameter("Observacion")
			));
		documentoGet(request, response);
	}
	
	private void documentoGet(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			request.setAttribute("documento", documentos.get(0));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/documento.jsp");
		dispatcher.forward(request, response);
	}
	
	private void documentoPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(!nuevo)
			documentos.clear();
		
		documentos.add(new Documento(codigoSocio,
				request.getParameter("TipoDocumento"),
				request.getParameter("FechaReferencia"),
				request.getParameter("FechaCaducidad"),
				request.getParameter("PaisEmision")
			));
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostrarSocio.jsp");
		List<Socio> listaSocios= socioDao.listarSocios();
		request.setAttribute("listaSocios", listaSocios);
		dispatcher.forward(request, response);
	}	
	
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Calendar now= Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Socio socio = new Socio(Integer.parseInt(request.getParameter("id")), request.getParameter("tipoId"), 
				request.getParameter("identificacion"), 
				request.getParameter("nombreUsual"), 
				request.getParameter("relacion"), 
				request.getParameter("grupoEconomico"),
				true,
				request.getParameter("relacionAseguradora"),
				"Leon",
				"01",
				formato.format(now.getTime()),
				"Alondra Ruiz"
			);
		socioDao.actualizar(socio);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Socio socio = socioDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		socioDao.eliminar(socio);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
}
