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
  <title>Socio Natural</title>
</head>

<body>
  <h3 class="text-center">Mas datos acerca del Socio</h3>
  <div class="row">


    <div class="col-md-2"></div>
    <div class="col-md-8">

      <form action="crearNaturalServlet" method="post">

        <div class="row">
          <div class="col-md-4">

            <label for="ApallidoPaterno">Apallido Paterno</label>
            <input type="text" class="form-control" name="ApallidoPaterno" value="<c:out value='${natural.apellidoPaterno}'></c:out>">

          </div>
          <div class="col-md-4">
            <label for="ApallidoMaterno">Apallido Materno</label>
            <input type="text" class="form-control" name="ApallidoMaterno" value="<c:out value='${natural.apellidoMaterno}'></c:out>">

          </div>
          <div class="col-md-4">
            <label for="Nombre">Nombre </label>
            <input type="text" class="form-control" name="Nombre" value="<c:out value='${natural.nombres}'></c:out>">
          </div>
        </div>

        <div class="row">
          <div class="col-md-4">
            <label for="Nacionalidad">Nacionalidad</label>
            <select class="form-control" id="exampleFormControlSelect1" name="Nacionalidad">
              <option>Nicaraguense</option>
              <option>Guatemalteco</option>
              <option>Salvadoreño</option>
              <option>Panameño</option>
              <option>Costarricense</option>
              <option></option>
            </select>
          </div>

          <div class="col-md-4">
            <label for="Profesion">Profesion</label>
            <input type="text" class="form-control" name="Profesion"value="<c:out value='${natural.profesion}'></c:out>">
          </div>

          <div class="col-md-4">
            <label for="NivelEducativo">Nivel Educativo</label>
            <input type="text" class="form-control" name="NivelEducativo" value="<c:out value='${natural.nivelEducacional}'></c:out>">
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label for="Estado Civil">Estado Civil</label>
            <input type="text" class="form-control" name="Estado Civil"value="<c:out value='${natural.estadoCivil}'></c:out>">
          </div>

          <div class="col-md-4">
            <label for="FechaNacimiento">Fecha de Nacimiento</label>
            <input type="text" class="form-control" name="FechaNacimiento" value="<c:out value='${natural.fechaNacimiento}'></c:out>">
          </div>

          <div class="col-md-4">
            <label for="TipoVivienda">Tipo de Vivienda</label>
            <input type="text" class="form-control" name="TipoVivienda" value="<c:out value='${natural.tipoVivienda}'></c:out>">
          </div>
        </div>

        <div class="row">

          <div class="col-md-6">
            <label for="NumeroDependencias">Numero de Dependencias</label>
            <input type="text" class="form-control" name="NumeroDependencias" value="<c:out value='${natural.numeroDependencia}'></c:out>">
          </div>

          <div class="col-md-6">
            <label for="SectorEconomico">Sector Economico</label>
            <input type="text" class="form-control" name="SectorEconomico" value="<c:out value='${natural.sectorEconomico}'></c:out>">
          </div>
        </div>

        <div class="row">
          <div class="col-md-6">
            <label for="ActividadPrincipal">Actividad Principal</label>
            <input type="text" class="form-control" name="ActividadPrincipal" value="<c:out value='${natural.actividadPrincipal}'></c:out>">
          </div>

            <div class="col-md-6">
              <label for="ActividadSecundaria">Actividad Secundaria</label>
              <input type="text" class="form-control" name="ActividadSecundaria" value="<c:out value='${natural.actividadSecundaria}'></c:out>">
            </div>
        </div>


        <label for="Ocupacion">Ocupacion</label>
        <input type="text" class="form-control" name="Ocupacion"value="<c:out value='${natural.ocupacion}'></c:out>">

        <br>
        <div class="row">

          <div class="col-md-9"></div>
          <div class="col-md-3">

            <button type="submit" value="Socio" class="btn btn-primary">Siguiente -></button>
          </div>
        </div>
      </form>
    </div>

  </div>

</html>
</body>