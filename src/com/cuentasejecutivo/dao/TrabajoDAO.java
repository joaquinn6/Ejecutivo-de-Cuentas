package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Trabajo;
import com.cuentasejecutivo.model.Conexion;
public class TrabajoDAO {
  private Conexion con;
	private Connection connection;
  public TrabajoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Trabajo trabajo) throws SQLException {
    String sql = "INSERT INTO trabajo (codigoSocio, tipoEmpresa, nombreEmpresa, fechaIngreso, direccion, telefono, funcion, tipoContrato, cargo ) VALUES (?, ?, ?, ?, ?, ?, ?, ?. ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1,trabajo.getCodigoSocio());
		statement.setString(2,trabajo.getTipoEmpresa());
		statement.setString(3,trabajo.getNombreEmpresa());
		statement.setString(4,trabajo.getFechaIngreso());
		statement.setString(5,trabajo.getDireccion());
		statement.setString(6,trabajo.getTelefono());
		statement.setString(7,trabajo.getFuncion());
    statement.setString(8,trabajo.getTipoContrato());
    statement.setString(9,trabajo.getCargo());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Trabajo> listarTrabajo() throws SQLException {
		List<Trabajo> listarTrabajo = new ArrayList<Trabajo>();
		String sql = "SELECT * FROM trabajo";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			Trabajo trabajo = new Trabajo(resulSet.getInt("codigoSocio"),
          resulSet.getString("tipoEmpresa"),
          resulSet.getString("nombreEmpresa"),
          resulSet.getString("fechaIngreso"),
          resulSet.getString("direccion"),
          resulSet.getString("telefono"),
					resulSet.getString("funcion"),
					resulSet.getString("tipoContrato"),
					resulSet.getString("cargo"));
			listarTrabajo.add(trabajo);
		}
		con.desconectar();
		return listarTrabajo;
	}
  // obtener por id
  public Trabajo obtenerPorId(Integer codigoSocio) throws SQLException {
		Trabajo trabajo = null;

		String sql = "SELECT * FROM trabajo WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      trabajo = new Trabajo(resulSet.getInt("codigoSocio"),
      resulSet.getString("tipoEmpresa"),
      resulSet.getString("nombreEmpresa"),
      resulSet.getString("fechaIngreso"),
      resulSet.getString("direccion"),
      resulSet.getString("telefono"),
      resulSet.getString("funcion"),
      resulSet.getString("tipoContrato"),
      resulSet.getString("cargo"));
    }
    resulSet.close();
		con.desconectar();

		return trabajo;
  }
  // actualizar
	public boolean actualizar(Trabajo trabajo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE trabajo SET tipoEmpresa=?, nombreEmpresa=?, fechaIngreso=?, direccion=?, telefono=?, funcion=?, tipoContrato=?, cargo=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,trabajo.getTipoEmpresa());
		statement.setString(2,trabajo.getNombreEmpresa());
		statement.setString(3,trabajo.getFechaIngreso());
		statement.setString(4,trabajo.getDireccion());
		statement.setString(5,trabajo.getTelefono());
		statement.setString(6,trabajo.getFuncion());
    statement.setString(7,trabajo.getTipoContrato());
    statement.setString(8,trabajo.getCargo());
    statement.setInt(9,trabajo.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Trabajo trabajo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM trabajo WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, trabajo.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
