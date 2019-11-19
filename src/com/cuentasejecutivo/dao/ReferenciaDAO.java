package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Referencia;
import com.cuentasejecutivo.model.Conexion;
public class ReferenciaDAO {
  private Conexion con;
	private Connection connection;
  public ReferenciaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Referencia referencia) throws SQLException {
    String sql = "INSERT INTO referencia (codigoSocio, tipoReferencia, nombre, nombreTrabajo, mail, telefono, observacion ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,referencia.getCodigoSocio());
		statement.setString(2,referencia.getTipoReferencia());
		statement.setString(3,referencia.getNombre());
		statement.setString(4,referencia.getNombreTrabajo());
		statement.setString(5,referencia.getMail());
		statement.setString(6,referencia.getTelefono());
		statement.setString(7,referencia.getObservacion());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Referencia> listarReferencia() throws SQLException {
		List<Referencia> listarReferencia = new ArrayList<Referencia>();
		String sql = "SELECT * FROM referencia";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Referencia referencia = new Referencia(resulSet.getInt("codigoSocio"),
          resulSet.getString("tipoReferencia"),
          resulSet.getString("nombre"),
          resulSet.getString("nombreTrabajo"),
          resulSet.getString("mail"),
					resulSet.getString("telefono"),
					resulSet.getString("observacion"));
			listarReferencia.add(referencia);
		}
		con.desconectar();
		return listarReferencia;
	}
  // obtener por id
  public Referencia obtenerPorId(Integer codigoSocio) throws SQLException {
		Referencia referencia = null;

		String sql = "SELECT * FROM referencia WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      referencia = new Referencia(resulSet.getInt("codigoSocio"),
      resulSet.getString("tipoReferencia"),
      resulSet.getString("nombre"),
      resulSet.getString("nombreTrabajo"),
      resulSet.getString("mail"),
      resulSet.getString("telefono"),
      resulSet.getString("observacion"));
    }
    resulSet.close();
		con.desconectar();

		return referencia;
  }
  // actualizar
	public boolean actualizar(Referencia referencia) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE referencia SET tipoReferencia=?, nombre=?, nombreTrabajo=?, mail=?, telefono=?, observacion=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,referencia.getTipoReferencia());
		statement.setString(2,referencia.getNombre());
		statement.setString(3,referencia.getNombreTrabajo());
		statement.setString(4,referencia.getMail());
		statement.setString(5,referencia.getTelefono());
		statement.setString(6,referencia.getObservacion());
    statement.setInt(7,referencia.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Referencia referencia) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM referencia WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, referencia.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
