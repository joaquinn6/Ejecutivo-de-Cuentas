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
  <title>Direccion Socio</title>
</head>
<body>
  <h3 class="text-center">Direccion </h3>
  <div class="row">


    <div class="col-md-2"></div>
    <div class="col-md-8">

      <form action="crearSocioServlet" method="post">

        <label for="TipoDireccion">Tipo de Direccion</label>
        <select class="form-control" id="SelectDireccion" name="TipoDireccion">
          <option>Casa</option>
          <option>Trabajo</option>
        </select>
        <label for="Pais">Pais</label>
        <select class="form-control" id="SelectPais" name="Pais">
          <option>Nicaragua</option>
          <option>El Salvador</option>cambios
          <option>Costa Rica</option>
          <option>Honduras</option>
          <option>Guatemala</option>
          <option>Panama</option>
        </select>
        <label for="Departamento">Departamento</label>
        <input type="text" class="form-control" name="Departamento" value='<c:out value="${direccion.departamento}"></c:out>'>

        <label for="Ciudad">Ciudad</label>
        <input type="text" class="form-control" name="Ciudad" value='<c:out value="${direccion.ciudad}"></c:out>'>

        <label for="BarrioComarca">Barrio/Comarca</label>
        <input type="text" class="form-control" name="BarrioComarca" value='<c:out value="${direccion.barrioComarca}"></c:out>'>

        <label for="DireccionDomiciliar">Direccion Domiciliar</label>
        <input type="text" class="form-control" name="DireccionDomiciliar" value='<c:out value="${direccion.direccionDomiciliar}"></c:out>'>

        <label for="TipoPropiedad">Tipo de Propiedad</label>
        <input type="text" class="form-control" name="TipoPropiedad" value='<c:out value="${direccion.tipoPropiedad}"></c:out>'>
        <br>
        <div class="row">


          <div class="col-md-9">
            <button type="submit" value="Socio" class="btn btn-primary">Agregar mas Direcciones</button>

          </div>
          <div class="col-md-3">

            <button type="submit" value="Socio" class="btn btn-primary">Siguiente -></button>
          </div>
        </div>
      </form>
    </div>

  </div>
  </html>
</body>
