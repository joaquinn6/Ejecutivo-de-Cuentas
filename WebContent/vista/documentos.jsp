<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
  <title>Documento Socio</title>
</head>
<body>
  <h3 class="text-center">Documento</h3>
  <div class="row">


    <div class="col-md-2"></div>
    <div class="col-md-8">

      <form action="crearTelefonoServlet" method="post">


        <label for="TipoDocumento">Tipo de Documento</label>
        <input type="text" class="form-control" name="TipoDocumento" >

        <label for="FechaReferencia">Fecha de Referencia</label>
        <input type="text" class="form-control" name="FechaReferencia" >

        <label for="FechaCaducidad">Fecha de Caducidad</label>
        <input type="text" class="form-control" name="FechaCaducidad" >

        <label for="PaisEmision">Pais de Emision</label>
        <input type="text" class="form-control" name="PaisEmision" >
        <br>
        <div class="row">

          <div class="col-md-9">
            <button type="submit" value="Socio" class="btn btn-primary">Agregar Otro Documento</button>
          </div>
          <div class="col-md-3">

            <button type="submit" value="Socio" class="btn btn-primary">¡Finalizar!</button>
          </div>
        </div>
      </form>
    </div>

  </div>
  </html>
</body>
