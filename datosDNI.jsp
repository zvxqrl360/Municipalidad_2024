<%-- 
    Document   : datosDNI
    Created on : 27 jun. 2023, 12:20:07
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
        <link rel="stylesheet" href="dist/css/skins/skin-green.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">


        <style>
            .profile-img {
                width: 300px;
                height: 200px;
                object-fit: cover;
            }
        </style>
    </head>

    <body class="hold-transition skin-green sidebar-mini">
        <div class="wrapper">

            <!-- Main -->
            <c:import url="/menu_user.jsp" />
            <!-- apartado izquierdo del menu -->
        
            <!-- Detalles de la envoltura para los accesos rapidos a reportes -->
            <div class="content-wrapper">
                <!-- envoltura header -->
                <section class="content-header">
                    <h1>
                        Resultados
                        <small>DNI</small>
                    </h1>
                </section>
                <section class="content-header">
                    <a href="" class="btn btn-danger">
                        <i class="fa fa-file-pdf-o" aria-hidden="true"></i>   
                        <span>&nbsp;&nbsp;PDF DNI</span>
                    </a>
                    <ol class="breadcrumb">
                        <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li><a href="srvReniec?accion=cargar_vista"><i class="fa fa-dashboard"></i> Generar Consulta</a></li>
                        <li class="active">Resultados</li>
                    </ol>
                </section>


                <section class="content">
                    <div class="box">    
                        <div class="box-header with-border">             
                            <h3 class="box-title">Datos de la Consulta</h3>
                        </div>
                        <div class="box-body">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <h2>${datos_dni.dni}:${datos_dni.nombres} ${datos_dni.apellidoPaterno} ${datos_dni.apellidoMaterno}</h2>

                                        <div class="row">
                                            <div class="col-xs-3">
                                                <img src="data:image/jpeg;base64,${datos_dni.imgb64}" class="profile-img img-thumbnail">
                                            </div>

                                            <div class="col-xs-9">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <div class="form-group">
                                                            <label for="nombre">Nombre:</label>
                                                            <input type="text" class="form-control" id="nombre" value="${datos_dni.nombres}" readonly>
                                                        </div>
                                                    </div>

                                                </div>

                                                <div class="row">
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label for="apellido">Apellido Paterno:</label>
                                                            <input type="text" class="form-control" id="apellido" value="${datos_dni.apellidoPaterno}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label for="apellido">Apellido Materno:</label>
                                                            <input type="text" class="form-control" id="apellido" value="${datos_dni.apellidoMaterno}" readonly>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <div class="form-group">
                                                            <label for="direccion">Dirección:</label>
                                                            <input type="text" class="form-control" id="direccion" value="${datos_dni.direccion}" readonly>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">

                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label for="estado_civil">Departamento:</label>
                                                            <input type="text" class="form-control" id="estado_civil" value="${datos_dni.departamento}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label for="estado_civil">Provincia:</label>
                                                            <input type="text" class="form-control" id="estado_civil" value="${datos_dni.provincia}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <div class="form-group">
                                                            <label for="estado_civil">Distrito:</label>
                                                            <input type="text" class="form-control" id="estado_civil" value="${datos_dni.distrito}" readonly>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label for="estado_civil">Estado Civil:</label>
                                                            <input type="text" class="form-control" id="estado_civil" value="${datos_dni.estadoCivil}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="form-group">
                                                            <label for="estado_civil">Restriccion:</label>
                                                            <input type="text" class="form-control" id="estado_civil" value="${datos_dni.restriccion}" readonly>
                                                        </div>
                                                    </div>
                                                </div>        
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

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

