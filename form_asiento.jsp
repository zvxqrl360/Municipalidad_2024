<%-- 
    Document   : form_partida
    Created on : 28 jun. 2023, 11:07:04
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema Incidencias| Inicio</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <!-- Data table -->
        <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">


    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <!-- Main Header -->
          <c:import url="/menu_user.jsp" />
            <!-- Left side column. contains the logo and sidebar -->
            

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        SUNARP 
                        <small> Asiento</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li><a href=""><i class="fa fa-dashboard"></i> Formulario asiento</a></li>
                    </ol>
                </section>

                </section>
                <section class="content">
                    <div class="box">
                        <div class="box-header with-border">
                            <i class="fa fa-edit"></i> <h3 class="box-title">Formulario de Asientos</h3>
                        </div>
                        <div class="box-body">

                            <form class="form-horizontal" action="srvSunarp?accion=buscar_partida" method="post">
                                <div class="box-body">

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Zona :</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                            <select class="form-control form-select-sm" aria-label=".form-select-sm example"  name="cboZona" autofocus=""  required="">
                                                <option value="0">Seleccionar Zona</option>
                                                <option value="01">Zona Registral N IX - Sede Lima-01</option>
                                                <option value="02">Zona Registral N VIII - Sede Huancayo-02</option>
                                                <option value="03">Zona Registral N XII - Arequipa-03</option>
                                                <option value="04">Zona Registral N VII - Huaraz-04</option>
                                                <option value="05">Zona Registral N I - Sede Piura-05</option>
                                                <option value="06">Zona Registral N X - Sede Cusco-06</option>
                                                <option value="07">Zona Registral N XIII - Sede Tacna-07</option>
                                                <option value="08">Zona Registral N V - Sede Trujillo-08</option>
                                                <option value="09">Zona Registral N IV - Sede Iquitos-09</option>
                                                <option value="10">Zona Registral N XI - Sede Ica-10</option>
                                                <option value="11">Zona Registral N II - Sede Chiclayo-11</option>
                                                <option value="12">Zona Registral N III - Sede Moyabamba-12</option>
                                                <option value="13">Zona Registral N VI - Sede Pucallpa-13</option>
                                                <option value="14">Zona Registral N XIV - Sede Ayacucho-14</option>
                                            </select>
                                        </div>                                  
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Oficina :</label>
                                        <div class="col-sm-4 input-group">
                                            <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                            <select class="form-control form-select-sm" aria-label=".form-select-sm example"  name="cboOficina" autofocus=""  required="">
                                                <option value="0">Seleccionar Oficina</option>
                                                <c:forEach items=" " var="contac">
                                                    <option value=" "  

                                                            > </option>
                                                </c:forEach>
                                            </select>
                                        </div>                                  
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Registro :</label>
                                        <div class="col-sm-6 input-group">
                                            <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                            <select class="form-control form-select-sm" aria-label=".form-select-sm example"  name="cboRegistro" autofocus=""  required="">
                                                <option value="0">Seleccionar Registro</option>
                                                <c:forEach items=" " var="contac">
                                                    <option value=" "  

                                                            > </option>
                                                </c:forEach>
                                            </select>
                                        </div>                                  
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Numero de Partida :</label>
                                        <div class="col-sm-6 input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                            <input type="text" name="txtNumeroPartida" placeholder="Ingrese numero de partida" class="form-control" required />
                                        </div>
                                    </div>

                                    <!--BOTONES DEL FORM-->
                                    <div class="text-center box-footer">
                                        <button onclick="modificarCajaTexto2()" type="submit" id="btnBuscar" name="btnRegistrar" value="Registrar" class="btn btn-success" ><i class="fa fa-floppy-o"></i> Realizar Búsqueda</button>
                                       
                                    </div>



                                    <!--FIN BOTONES DEL FORM-->
                                </div>
                            </form>

                        </div>
                    </div>


            </div>

            <!-- Firma inferior footer -->
            <footer class="main-footer">
                <!-- codigo para poner a la derecha -->
                <div class="pull-right hidden-xs">
                    Todos los derechos reservados.
                </div>
                <!-- por defecto a la izquierda -->
                <strong>Copyright &copy; 2023 </strong>
            </footer>
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->
<!-- Modal-->
<div class="modal fade" id="progressModal" tabindex="-1" role="dialog" aria-labelledby="progressModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="progressModalLabel">Cargando</h5>
      </div>
      <div class="modal-body">
        <div class="progress">
          <div id="progressBar" class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <div id="progressText" class="text-center mt-2">0%</div>

      </div>

      </div>
      <div class="modal-footer" style="display: none;">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>





        <!-- REQUIRED JS SCRIPTS -->





        <!-- jQuery 3      -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7        -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>

        <script >

                function modificarCajaTexto2() {
                var progressModal = $("#progressModal");
                var progressBar = $("#progressBar");
                var progressText = $("#progressText");
                var modalFooter = $(".modal-footer");
                // Mostrar el modal de progreso
                    progressModal.modal("show");

  // Definir la función de solicitud AJAX
function realizarSolicitud() {
  $.ajax({
    url: 'pruebajax',
    type: 'GET',
    success: function(data) {
      // Actualizar el contenido de la caja de texto con la respuesta del servidor
      $('#cajaTexto').val(data);
      
      // Calcular el porcentaje con solo 2 decimales
      var porcent = (parseFloat(data) / 100).toFixed(2) * 100;
      
      // Actualizar el progreso en la barra de progreso y en el texto
      progressBar.css("width", porcent + "%").attr("aria-valuenow", porcent);
      progressText.text(porcent.toFixed(2) + "%");

      // Verificar si el valor final alcanzó 100
      if (porcent !== 100) {
        // Realizar otra solicitud después de un breve tiempo
        setTimeout(realizarSolicitud, 1000); // Esperar 1 segundo (1000 ms) antes de realizar la siguiente solicitud
      } else {
        // Mostrar el botón de cerrar cuando el proceso ha terminado
        modalFooter.show();
      }
    },
    error: function(xhr, status, error) {
      console.error(error);

      // Cerrar el modal de progreso en caso de error
      progressModal.modal("hide");
    }
  });
}


  // Iniciar la solicitud inicial
  realizarSolicitud();
}

        </script>








    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>


