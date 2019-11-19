package com.cuentasejecutivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cuentasejecutivo.model.Direccion;
import com.cuentasejecutivo.model.Conexion;
public class DireccionDAO {
  private Conexion con;
	private Connection connection;
  public DireccionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion("jdbc:mysql://localhost:3306/cuentasejecutivo", "root", "");
	}
  	// insertar
  public boolean insertar(Direccion direccion) throws SQLException {
    String sql = "INSERT INTO natural (codigoSocio, tipoDireccion, pais, departamento, Ciudad, barrioComarca, dirrecionDomiciliar, tipoPropiedad ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setInt(1,direccion.getCodigoSocio());
		statement.setString(2,direccion.getTipoDireccion());
		statement.setString(3,direccion.getPais());
		statement.setString(4,direccion.getDepartamento());
		statement.setString(5,direccion.getCiudad());
		statement.setString(6,direccion.getBarrioComarca());
		statement.setString(7,direccion.getDirrecionDomiciliar());
    statement.setString(8,direccion.getTipoPropiedad());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
  // listar todos los productos
	public List<Direccion> listarDireccion() throws SQLException {
		List<Direccion> listarDireccion = new ArrayList<Direccion>();
		String sql = "SELECT * FROM direccion";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Direccion direccion = new Direccion(resulSet.getInt("codigoSocio"),
          resulSet.getString("pais"),
          resulSet.getString("tipoDireccion"),
          resulSet.getString("departamento"),
          resulSet.getString("Ciudad"),
          resulSet.getString("barrioComarca"),
          resulSet.getString("dirrecionDomiciliar"),
          resulSet.getString("tipoPropiedad"));
			listarDireccion.add(direccion);
		}
		con.desconectar();
		return listarDireccion;
	}
  // obtener por id
  public Direccion obtenerPorId(Integer codigoSocio) throws SQLException {
		Direccion direccion = null;

		String sql = "SELECT * FROM direccion WHERE codigoSocio= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, codigoSocio);

		ResultSet resulSet = statement.executeQuery();
    if (resulSet.next()) {
      direccion = new Direccion(resulSet.getInt("codigoSocio"),
      resulSet.getString("pais"),
      resulSet.getString("tipoDireccion"),
      resulSet.getString("departamento"),
      resulSet.getString("Ciudad"),
      resulSet.getString("barrioComarca"),
      resulSet.getString("dirrecionDomiciliar"),
      resulSet.getString("tipoPropiedad"));
    }
    resulSet.close();
		con.desconectar();

		return direccion;
  }
  // actualizar
	public boolean actualizar(Direccion direccion) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE direccion SET pais=?, tipoDireccion=?, departamento=?, Ciudad=?, barrioComarca=?, dirrecionDomiciliar=?, tipoPropiedad=? WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,direccion.getTipoDireccion());
		statement.setString(2,direccion.getPais());
		statement.setString(3,direccion.getDepartamento());
		statement.setString(4,direccion.getCiudad());
		statement.setString(5,direccion.getBarrioComarca());
		statement.setString(6,direccion.getDirrecionDomiciliar());
    statement.setString(7,direccion.getTipoPropiedad());
    statement.setInt(8,direccion.getCodigoSocio());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
  //eliminar
	public boolean eliminar(Direccion direccion) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM direccion WHERE codigoSocio=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, direccion.getCodigoSocio());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
