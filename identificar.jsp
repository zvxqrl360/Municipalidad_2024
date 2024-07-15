<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Sistema Incidencias | Iniciar Session</title>
  <!-- apartado responsive -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Iconos -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>


<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
      <!-- Titulo -->
    <a href="#"><b>Sistema P.I.D.E. </b>Municipalidad de Huaral
            
            <!-- Imagen de logo de la empresa -->
            <div>
                <img src="img/municipalidad.jpg">
            </div>
        <!-- Mensaje inferior a la imagen -->        
        </a>
  </div>
    <!-- login-box-body -->
  <div class="login-box-body">
    <p class="login-box-msg">Inicio de Sesion</p>
    <form action="srvUsuario?accion=verificar" method="POST">
      <div class="form-group has-feedback">
          <!-- Input para obtener el usuario ingresado -->
          <input type="text" name="txtUsu" id="txtUsu" value="" class="form-control"  placeholder="Usuario">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <!-- Input para obtener la contrase;a ingresado -->
          <input type="password" name="txtPass" id="txtPass" value="" class="form-control" placeholder="******">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
       <!-- codigo del boton recuerdame -->
      <div class="row">
        <div class="col-xs-8">
          
        </div>
    </form>
    <!-- Boton que permite iniciar el metodo verificar para ingresar al sistema -->
        <div class="col-xs-12">
          <input type="submit" name="verificar" value="Ingresar" class="btn btn-primary btn-block"/>
        </div>
      </div>
        <!-- Codigo del sistema de notificacion del error dentro del intento de login -->
  
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Codigo opcional para personalizar la entrada input(checkbox) -->
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' 
    });
  });
</script>
</body>
</html>
