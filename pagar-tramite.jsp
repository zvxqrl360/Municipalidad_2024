<%-- 
    Document   : pagar-tramite
    Created on : 12 jun. 2024, 2:26:09 p. m.
    Author     : Luis Armando Bailon Victorio - luis_abv@outlook.com
--%>

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
                        <div class="card shadow mb-3" style="max-width: 500px; margin-left: auto; margin-right: auto;">
                            <div class="card-header bg-body-secondary border-0 py-3">
                                <h6 class="m-0">Resumen de la información</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td><strong>Nombre</strong></td>
                                                <td>Luis Armando</td>
                                            </tr>
                                            <tr>
                                                <td><strong>Apellido</strong></td>
                                                <td>Bailon Victorio</td>
                                            </tr>
                                            <tr>
                                                <td><strong>DNI</strong></td>
                                                <td>12345678</td>
                                            </tr>
                                            <tr>
                                                <td><strong>Dirección</strong></td>
                                                <td>Av. Los Arquitectos Calle Los Geranios</td>
                                            </tr>
                                            <tr>
                                                <td><strong>Tipo de trámite</strong></td>
                                                <td>Constancia de Posesión</td>
                                            </tr>
                                            <tr>
                                                <td><strong><span style="color: rgb(33, 37, 41);">Total a pagar</span></strong></td>
                                                <td>S/. 50.00</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <form action="#servlet" method="post">
                                    <button class="btn btn-primary" type="button">Realizar Pago</button>
                                </form>
                            </div>
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