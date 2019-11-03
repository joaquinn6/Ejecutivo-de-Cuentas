package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Socio;
import com.cuentasejecutivo.model.Conexion;

public class SocioDAO {
	private Conexion con;
	private Connection connection;

	public SocioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}

	// insertar socio
	public boolean insertar(Socio socio) throws SQLException {
		String sql = "INSERT INTO socio (codigoSocio, tipoId, identificacion, nombreUsual, relacion, grupoEconomico, exoneradoImpuesto, relacionAseguradora, sucursalOrigen, oficinaOrigen, fechaIngreso, ejecutivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, socio.getTipoId());
		statement.setString(3, socio.getIdentificacion());
		statement.setString(4, socio.getNombreUsual());
		statement.setString(5, socio.getRelacion());
		statement.setString(6, socio.getGrupoEconomico());
		statement.setBoolean(7, socio.isExoneradoImpuesto());
		statement.setString(8, socio.getRelacionAseguradora());
		statement.setString(9, socio.getSucursalOrigen());
		statement.setString(10, socio.getOficinaOrigen());
		statement.setString(11, socio.getFechaIngreso());
		statement.setString(12, socio.getEjecutivo());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Socio> listarSocios() throws SQLException {
		List<Socio> listaSocios = new ArrayList<Socio>();
		String sql = "SELECT * FROM socio";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {			
			Socio socio = new Socio(resulSet.getInt("codigoSocio"), resulSet.getString("tipoId"), resulSet.getString("identificacion"), resulSet.getString("nombreUsual"),
					resulSet.getString("relacion"),
					resulSet.getString("grupoEconomico"),
					resulSet.getBoolean("exoneradoImpuesto"),
					resulSet.getString("relacionAseguradora"),
					resulSet.getString("sucursalOrigen"),
					resulSet.getString("oficinaOrigen"),
					resulSet.getString("fechaIngreso"),
					resulSet.getString("ejecutivo"));
			
			listaSocios.add(socio);
		}
		con.desconectar();
		return listaSocios;
	}

	// obtener por id
	public Socio obtenerPorId(Integer codigoSocio) throws SQLException {
		Socio socio = null;

		String sql = "SELECT * FROM socio WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
		if (resulSet.next()) {
			socio = new Socio(resulSet.getInt("codigoSocio"), resulSet.getString("tipoId"), resulSet.getString("identificacion"), resulSet.getString("nombreUsual"),
					resulSet.getString("relacion"),
					resulSet.getString("grupoEconomico"),
					resulSet.getBoolean("exoneradoImpuesto"),
					resulSet.getString("relacionAseguradora"),
					resulSet.getString("sucursalOrigen"),
					resulSet.getString("oficinaOrigen"),
					resulSet.getString("fechaIngreso"),
					resulSet.getString("ejecutivo"));
		}
		resulSet.close();
		con.desconectar();

		return socio;
	}

	// actualizar
	public boolean actualizar(Socio socio) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE socio SET tipoId=?,identificacion=?,nombreUsual=?,relacion=?,grupoEconomico=?,exoneradoImpuesto=?,relacionAseguradora=?,sucursalOrigen=?,oficinaOrigen=?,fechaIngreso=?,ejecutivo=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
statement.setString(1, socio.getTipoId());
statement.setString(2, socio.getIdentificacion());
statement.setString(3, socio.getNombreUsual());
statement.setString(4, socio.getRelacion());
statement.setString(5, socio.getGrupoEconomico());
statement.setBoolean(6, socio.isExoneradoImpuesto());
statement.setString(7, socio.getRelacionAseguradora());
statement.setString(8, socio.getSucursalOrigen());
statement.setString(9, socio.getOficinaOrigen());
statement.setString(10, socio.getFechaIngreso());
statement.setString(11, socio.getEjecutivo());
statement.setInt(12, socio.getCodigoSocio());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Socio socio) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM socio WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, socio.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
