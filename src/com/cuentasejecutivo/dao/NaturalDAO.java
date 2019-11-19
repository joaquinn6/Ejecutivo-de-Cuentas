package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Natural;
import com.cuentasejecutivo.model.Conexion;
public class NaturalDAO {
  private Conexion con;
	private Connection connection;
  public NaturalDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Natural natural) throws SQLException {
    String sql = "INSERT INTO natural (codigoSocio, apellidoPaterno, apellidoMaterno, nombres, nacionalidad, profesion, nivelEducacional, estadoCivil, fechaNacimiento, tipoVivienda, numeroDependencia, estado, sectorEconomico, actividadPrincipal, actividadSecundaria, ocupacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1,natural.getCodigoSocio());
		statement.setString(2,natural.getApellidoPaterno());
		statement.setString(3,natural.getApellidoMaterno());
		statement.setString(4,natural.getNombres());
		statement.setString(5,natural.getNacionalidad());
		statement.setString(6,natural.getProfesion());
		statement.setString(7,natural.getNivelEducacional());
    statement.setString(8,natural.getEstadoCivil());
		statement.setString(9,natural.getFechaNacimiento());
		statement.setString(10,natural.getTipoVivienda());
		statement.setInt(11,natural.getNumeroDependencia());
    statement.setString(12,natural.getEstado());
		statement.setString(13,natural.getSectorEconomico());
		statement.setString(14,natural.getActividadPrincipal());
		statement.setString(15,natural.getactividadSecundaria());
    statement.setString(16,natural.getOcupacion());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Natural> listarNatural() throws SQLException {
		List<Natural> listarNatural = new ArrayList<Natural>();
		String sql = "SELECT * FROM natural";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Natural natural = new Natural(resulSet.getInt("codigoSocio"),
          resulSet.getString("apellidoPaterno"),
          resulSet.getString("apellidoMaterno"),
          resulSet.getString("nombres"),
					resulSet.getString("nacionalidad"),
					resulSet.getString("profesion"),
					resulSet.getString("nivelEducacional"),
					resulSet.getString("estadoCivil"),
          resulSet.getString("fechaNacimiento"),
					resulSet.getString("tipoVivienda"),
					resulSet.getInt("numeroDependencia"),
					resulSet.getString("estado"),
          resulSet.getString("sectorEconomico"),
					resulSet.getString("actividadPrincipal"),
					resulSet.getString("actividadSecundaria"),
					resulSet.getString("ocupacion"));
			listarNatural.add(natural);
		}
		con.desconectar();
		return listarNatural;
	}
  // obtener por id
  public Natural obtenerPorId(Integer codigoSocio) throws SQLException {
		Natural natural = null;

		String sql = "SELECT * FROM socio WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      natural = new Natural(resulSet.getInt("codigoSocio"),
          resulSet.getString("apellidoPaterno"),
          resulSet.getString("apellidoMaterno"),
          resulSet.getString("nombres"),
          resulSet.getString("nacionalidad"),
          resulSet.getString("profesion"),
          resulSet.getString("nivelEducacional"),
          resulSet.getString("estadoCivil"),
          resulSet.getString("fechaNacimiento"),
          resulSet.getString("tipoVivienda"),
          resulSet.getInt("numeroDependencia"),
          resulSet.getString("estado"),
          resulSet.getString("sectorEconomico"),
          resulSet.getString("actividadPrincipal"),
          resulSet.getString("actividadSecundaria"),
          resulSet.getString("ocupacion"));
    }
    resulSet.close();
		con.desconectar();

		return natural;
  }
  // actualizar
	public boolean actualizar(Natural natural) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE natural SET apellidoPaterno=?, apellidoMaterno=?, nombres=?, nacionalidad=?, profesion=?, nivelEducacional=?, estadoCivil=?, fechaNacimiento=?, tipoVivienda=?, numeroDependencia=?, estado=?, sectorEconomico=?, actividadPrincipal=?, actividadSecundaria=?, ocupacion=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,natural.getApellidoPaterno());
		statement.setString(2,natural.getApellidoMaterno());
		statement.setString(3,natural.getNombres());
		statement.setString(4,natural.getNacionalidad());
		statement.setString(5,natural.getProfesion());
		statement.setString(6,natural.getNivelEducacional());
    statement.setString(7,natural.getEstadoCivil());
		statement.setString(8,natural.getFechaNacimiento());
		statement.setString(9,natural.getTipoVivienda());
		statement.setInt(10,natural.getNumeroDependencia());
    statement.setString(11,natural.getEstado());
		statement.setString(12,natural.getSectorEconomico());
		statement.setString(13,natural.getActividadPrincipal());
		statement.setString(14,natural.getactividadSecundaria());
    statement.setString(15,natural.getOcupacion());
    statement.setInt(16,natural.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Natural natural) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM natural WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, natural.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
