package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Documento;
import com.cuentasejecutivo.model.Conexion;
public class DocumentoDAO {
  private Conexion con;
	private Connection connection;
  public DocumentoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Documento documento) throws SQLException {
    String sql = "INSERT INTO documento (codigoSocio, tipoDocumento, fechaReferencia, fechaCaducidad, paisEmision ) VALUES (?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1,documento.getCodigoSocio());
		statement.setString(2,documento.getTipoDocumento());
		statement.setString(3,documento.getFechaReferencia());
		statement.setString(4,documento.getFechaCaducidad());
		statement.setString(5,documento.getPaisEmision());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Documento> listarDocumento() throws SQLException {
		List<Documento> listarDocumento = new ArrayList<Documento>();
		String sql = "SELECT * FROM documento";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Documento documento = new Documento(resulSet.getInt("codigoSocio"),
          resulSet.getString("tipoDocumento"),
          resulSet.getString("fechaReferencia"),
          resulSet.getString("fechaCaducidad"),
          resulSet.getString("paisEmision"));
			listarDocumento.add(documento);
		}
		con.desconectar();
		return listarDocumento;
	}
  // obtener por id
  public Documento obtenerPorId(Integer codigoSocio) throws SQLException {
		Documento documento = null;

		String sql = "SELECT * FROM documento WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      documento = new Documento(resulSet.getInt("codigoSocio"),
      resulSet.getString("tipoDocumento"),
      resulSet.getString("fechaReferencia"),
      resulSet.getString("fechaCaducidad"),
      resulSet.getString("paisEmision"));
    }
    resulSet.close();
		con.desconectar();

		return documento;
  }
  // actualizar
	public boolean actualizar(Documento documento) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE documento SET tipoDocumento=?, fechaReferencia=?, fechaCaducidad=?, paisEmision=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,documento.getTipoDocumento());
		statement.setString(2,documento.getFechaReferencia());
		statement.setString(3,documento.getFechaCaducidad());
		statement.setString(4,documento.getPaisEmision());
    statement.setInt(5,documento.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Documento documento) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM documento WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, documento.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
