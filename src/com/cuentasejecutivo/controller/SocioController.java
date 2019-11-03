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
import com.cuentasejecutivo.model.Socio;

/**
 * Servlet implementation class SocioController
 */
@WebServlet("/socioController")
public class SocioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	SocioDAO socioDao;

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
				System.out.println("entro");
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
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

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Calendar now= Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
		Socio socio= new Socio(
				0, 
				request.getParameter("tipoId"), 
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
		socioDao.insertar(socio);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mostrarSocio.jsp");
		List<Socio> listaSocios= socioDao.listarSocios();
		request.setAttribute("listaSocios", listaSocios);
		dispatcher.forward(request, response);
		System.out.println(listaSocios.get(0).getNombreUsual());
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Socio socio = socioDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("articulo", socio);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
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
