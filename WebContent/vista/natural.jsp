<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <input type="text" class="form-control" name="ApallidoPaterno">

          </div>
          <div class="col-md-4">
            <label for="ApallidoMaterno">Apallido Materno</label>
            <input type="text" class="form-control" name="ApallidoMaterno">

          </div>
          <div class="col-md-4">
            <label for="Nombre">Nombre </label>
            <input type="text" class="form-control" name="Nombre">
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
            <input type="text" class="form-control" name="Profesion">
          </div>

          <div class="col-md-4">
            <label for="NivelEducativo">Nivel Educativo</label>
            <input type="text" class="form-control" name="NivelEducativo">
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label for="Estado Civil">Estado Civil</label>
            <input type="text" class="form-control" name="Estado Civil">
          </div>

          <div class="col-md-4">
            <label for="FechaNacimiento">Fecha de Nacimiento</label>
            <input type="text" class="form-control" name="FechaNacimiento">
          </div>

          <div class="col-md-4">
            <label for="TipoVivienda">Tipo de Vivienda</label>
            <input type="text" class="form-control" name="TipoVivienda">
          </div>
        </div>

        <div class="row">

          <div class="col-md-6">
            <label for="NumeroDependencias">Numero de Dependencias</label>
            <input type="text" class="form-control" name="NumeroDependencias">
          </div>

          <div class="col-md-6">
            <label for="SectorEconomico">Sector Economico</label>
            <input type="text" class="form-control" name="SectorEconomico">
          </div>
        </div>

        <div class="row">
          <div class="col-md-6">
            <label for="ActividadPrincipal">Actividad Principal</label>
            <input type="text" class="form-control" name="ActividadPrincipal">
          </div>

            <div class="col-md-6">
              <label for="ActividadSecundaria">Actividad Secundaria</label>
              <input type="text" class="form-control" name="ActividadSecundaria">
            </div>
        </div>


        <label for="Ocupacion">Ocupacion</label>
        <input type="text" class="form-control" name="Ocupacion">

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
