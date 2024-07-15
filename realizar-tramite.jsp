<%-- 
    Document   : realizar-tramite
    Created on : 12 jun. 2024, 2:25:59 p. m.
    Author     : Luis Armando Bailon Victorio - luis_abv@outlook.com
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- apartado de java dentro del JSP para hacer el ingreso correcto al Index -->
    <% if (session.getAttribute("usuario") !=null) { %>
        <html>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Sistema Incidencias| Inicio</title>
            <!-- apartado responsive -->
            <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"  name="viewport">

            <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
            <!-- Font Awesome -->
            <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
            <!-- Iconos -->
            <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
            <!-- Theme style -->
            <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
            <!-- seleccion de la skin del adminLTE -->
            <link rel="stylesheet" href="dist/css/skins/skin-green.min.css">
            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
                            Generar Trámite
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a>
                            </li>
                            <li class="active">Generar Trámite</li>
                        </ol>
                    </section>

                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">Rellena los datos</h3>
                        </div>
                        <div class="box-body">
                            <form action="svrtramite?accion=guardartramite" method="post" style="max-width: 500px; margin-left: auto; margin-right: auto;">
                                <div class="mb-3">
                                    
                                    <label for="form-label nombre">Nombres</label>
                                    <input class="form-control" type="text" id="nombre" name="nombrePAG" placeholder="example" equired="">
                                </div>
                                <div class="mb-3">
                                    <label for="form-label apellido">Apellidos</label>
                                    <input class="form-control" type="text" id="apellido" name="apellidoPAG" placeholder="example" required="">
                                </div>
                                <div class="mb-3">
                                    <label for=" form-label dni">Número de DNI</label>
                                    <input class="form-control" type="text" id="dni" name="dniPAG" placeholder="example" required="" inputmode="numeric">
                                </div>
                                <div class="mb-3 mt-3">
                                    <br> 
                                    <label for="form-label tipo-tramite">Tipo de trámite</label>
                                    <select class="form-select" id="tipo-tramite" name="tipo-tramitePAG" required="">
                                        <option value="">Seleccione el tipo de trámite</option>
                                        <option value="contancia-domicilio">Constancia de domicilio</option>
                                        <option value="certificado-posesion">Certificado de Posesión</option>
                                    </select>
                                    <br>
                                </div>  
                                <br>
                                
                                    <input class="btn btn-primary" type="submit" value="Generar Trámite">
                            </form>
                            
                            <form>
                                
                                
                                
                                
                                
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
        <% } else { response.sendRedirect("identificar.jsp"); } %>