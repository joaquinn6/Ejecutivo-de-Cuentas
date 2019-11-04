<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
  
<title>Socios</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
	<a class="navbar-brand" href="socioController?action=mostrar">Socios</a>
</nav>

<h3 class="text-center">Socios</h3>
  <div class="row">
    <div class="col-md-12">

      <table class="table table-striped">
  		<tr>
          <td><strong>#</strong></td>
          <td><strong>Tipo Id</strong></td>
          <td><strong>Identificacion</strong></td>
          <td><strong>Nombre Usual</strong></td>
          <td><strong>Relacion</strong></td>
          <td><strong>Grupo Economico</strong></td>
          <td><strong>Exonerado de Impuesto</strong></td>
          <td><strong>Relacion Aseguradora</strong></td>
          <td><strong>Sucursal Origen</strong></td>
          <td><strong>Oficina Origen</strong></td>
          <td><strong>Fecha de Ingreso</strong></td>
          <td><strong>Ejecutivo</strong></td>
          <td></td>
          <td></td>
        </tr>
        <c:forEach var="socio" items="${listaSocios}">
        	<tr>
          		<td><c:out value="${socio.codigoSocio}"/></td>
          		<td><c:out value="${socio.tipoId}"/></td>
          		<td><c:out value="${socio.identificacion}"/></td>
          		<td><c:out value="${socio.nombreUsual}"/></td>
          		<td><c:out value="${socio.relacion}"/></td>
          		<td><c:out value="${socio.grupoEconomico}"/></td>
          		<td><c:out value="${socio.exoneradoImpuesto}"/></td>
          		<td><c:out value="${socio.relacionAseguradora}"/></td>
          		<td><c:out value="${socio.sucursalOrigen}"/></td>
          		<td><c:out value="${socio.oficinaOrigen}"/></td>
          		<td><c:out value="${socio.fechaIngreso}"/></td>
          		<td><c:out value="${socio.ejecutivo}"/></td>
          		<td><a href="adminArticulo?action=showedit&id=<c:out value="${socio.codigoSocio}" />">Editar</a></td>
          		<td><a href="adminArticulo?action=eliminar&id=<c:out value="${socio.codigoSocio}"/>">Eliminar</a> </td>       
        	</tr>
      </c:forEach>
      </table>
    </div>

  </div>
</body>
</html>