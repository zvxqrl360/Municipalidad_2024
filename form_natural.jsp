<%-- 
    Document   : form_natural
    Created on : 28 jun. 2023, 15:40:12
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- apartado de java dentro del JSP para hacer el ingreso correcto al Index -->
<%
    if (session.getAttribute("usuario") != null) {
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema Incidencias| Inicio</title>
        <!-- apartado responsive -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">



        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Iconos -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <!-- seleccion de la skin del adminLTE -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">

            <!-- Main -->
            <c:import url="/menu_user.jsp" />
            <!-- apartado izquierdo del menu -->
          
            <!-- Detalles de la envoltura para los accesos rapidos a reportes -->
            <div class="content-wrapper">
                <!-- envoltura header -->
                <section class="content-header">
                    <h1>
                        Persona Natural
                        <small> busqueda</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Busqueda persona natural</li>
                    </ol>
                </section>


                <div class="box">    
                    <div class="box-header with-border">             
                        <h3 class="box-title">Ingrese los datos</h3>
                    </div>
                    <div class="box-body">


                        <form class="form-horizontal" action="srvSunarp?accion=busqueda_natural" method="post">
                            <div class="box-body">



<div class="form-group">
    <label class="col-sm-2 control-label">Nombres</label>
    <div class="col-sm-4 input-group">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name="txtNombres" id="txtNombres" class="form-control" required />
    </div>
</div>

<div class="form-group">
    <label class="col-sm-2 control-label">Apellido Paterno</label>
    <div class="col-sm-4 input-group">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name="txtApellidoPaterno" id="txtApellidoPaterno" class="form-control" required />
    </div>
</div>                                

<div class="form-group">
    <label class="col-sm-2 control-label">Apellido Materno</label>
    <div class="col-sm-4 input-group">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name="txtApellidoMaterno" id="txtApellidoMaterno" class="form-control" required />
    </div>
</div>


<script>
    // Obtener referencias a los campos de texto
    var txtNombres = document.getElementById('txtNombres');
    var txtApellidoPaterno = document.getElementById('txtApellidoPatern');
    var txtApellidoMaterno = document.getElementById('txtApellidoMaterno');

    // Agregar evento de cambio a los campos de texto
    txtNombres.addEventListener('input', function() {
        // Remover caracteres no permitidos y convertir a mayúsculas
        this.value = this.value.replace(/[^a-zA-Z.\s]/g, '').toUpperCase();
    });

    txtApellidoPaterno.addEventListener('input', function() {
        // Remover caracteres no permitidos y convertir a mayúsculas
        this.value = this.value.replace(/[^a-zA-Z\s]/g, '').toUpperCase();
    });

    txtApellidoMaterno.addEventListener('input', function() {
        // Remover caracteres no permitidos y convertir a mayúsculas
        this.value = this.value.replace(/[^a-zA-Z\s]/g, '').toUpperCase();
    });
</script>



                                <!--BOTONES DEL FORM-->
                                <div class="pull-right-container box-footer">
                                    <button type="submit" id="" name="btnRegistrar" value="Registrar" class="btn btn-success" ><i class="fa fa-floppy-o"></i> Buscar</button>
                                    <button type="reset" class="btn btn-danger" ><i class="fa fa-close red"></i> Cancelar</button>
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






        <!-- REQUIRED JS SCRIPTS -->
        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>

        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>


        <!--pruebas-->


    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>
