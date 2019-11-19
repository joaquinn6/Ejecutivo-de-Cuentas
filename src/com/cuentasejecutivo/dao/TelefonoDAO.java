package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Telefono;
import com.cuentasejecutivo.model.Conexion;
public class TelefonoDAO {
  private Conexion con;
	private Connection connection;
  public TelefonoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Telefono telefono) throws SQLException {
    String sql = "INSERT INTO telefono (codigoSocio, tipoTelefono, numero, extension ) VALUES (?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,telefono.getCodigoSocio());
		statement.setString(2,telefono.getTipoTelefono());
		statement.setInt(3,telefono.getNumero());
		statement.setString(4,telefono.getExtension());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Telefono> listarTelefono() throws SQLException {
		List<Telefono> listarTelefono = new ArrayList<Telefono>();
		String sql = "SELECT * FROM telefono";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Telefono telefono = new Telefono(resulSet.getInt("codigoSocio"),
          resulSet.getString("tipoTelefono"),
          resulSet.getInt("numero"),
          resulSet.getString("extension"));

			listarTelefono.add(telefono);
		}
		con.desconectar();
		return listarTelefono;
	}
  // obtener por id
  public Telefono obtenerPorId(Integer codigoSocio) throws SQLException {
		Telefono telefono = null;

		String sql = "SELECT * FROM telefono WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      telefono = new Telefono(resulSet.getInt("codigoSocio"),
      resulSet.getString("tipoTelefono"),
      resulSet.getInt("numero"),
      resulSet.getString("extension"));
    }
    resulSet.close();
		con.desconectar();

		return telefono;
  }
  // actualizar
	public boolean actualizar(Telefono telefono) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE telefono SET tipoTelefono=?, numero=?, extension=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,telefono.getTipoTelefono());
		statement.setInt(2,telefono.getNumero());
		statement.setString(3,telefono.getExtension());
    statement.setInt(4,telefono.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Telefono telefono) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM telefono WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, telefono.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
