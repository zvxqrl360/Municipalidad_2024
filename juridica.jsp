<%-- 
    Document   : juridica
    Created on : 28 jun. 2023, 17:22:05
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
        <!-- Implementacion de SweetAlert para Eliminar -->
        <link href="SweetAlert/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <!-- Main Header -->
            <c:import url="/menu_user.jsp" />
           

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                    Pagina Bienes
                        <small> juridica</small>
                    </h1>
                </section>
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <a href="srvCargo?accion=nuevo" class="btn btn-success">
                        <i class="fa fa-plus"></i> Nuevo Consulta </a>

                    <ol class="breadcrumb">
                        <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li><a href="srvSunarp?accion=busqueda_natural"><i class="fa fa-dashboard"></i> Busqueda</a></li>
                        <li>Resultados</li>
                        <li class="active">Bienes</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="box">    
                        <div class="box-header with-border">             
                            <h3 class="box-title">Listado de Resultados</h3>
                        </div>
                        <div class="box-body">
                            <div class="table-responsive" >                                 
                                <table class="table table-bordered table-striped dataTable table-hover" id="tablaJuridica" class="display">
                                    <thead>
                                        <tr>
                                            <th>Indice</th>
                                            <th>Registro</th>
                                            <th>Libro</th>
                                            <th>Razon Social</th>
                                            <th>Tipo Documento</th>
                                            <th>Numero Documento</th>
                                            <th>Numero Partida</th>
                                            <th>Numero Placa</th>
                                            <th>Estado</th>
                                            <th>Zona</th>
                                            <th>Oficina</th>
                                            <th>PDF</th>
                                        </tr>
                                    </thead>

                                    <!-- comment -->
                                    <c:forEach var="bie" items="${bienes}" varStatus="iteracion">                                                    
                                        <tr>
                                            <td>${iteracion.index + 1}</td>
                                            <td>${bie.registro}</td>
                                            <td>${bie.libro}</td>
                                            <td>${bie.razon}</td>
                                            <td>${bie.tipoDocumento}</td>
                                            <td>${bie.numeroDocumento}</td>
                                            <td>${bie.numeroPartida}</td>
                                            <td>${bie.numeroPlaca}</td>
                                            <td>${bie.estado}</td>
                                            <td>${bie.zona}</td>
                                            <td>${bie.oficina}</td>

                                            <!-- PARA EL PDF -->
                                            <td><a href="<c:url value="srvSunarp">
                                                       <c:param name="accion" value=" "/>
                                                       <c:param name="cod_" value="" />
                                                   </c:url>"><button type="button" class="btn btn-danger" data-toggle="tooltip"  title="Editar" data-original-title="Editar">
                                                        <i class="fa fa-file-pdf-o"></i></button></a>



                                            </td>
                                        </tr>                                                    
                                    </c:forEach>                                               
                                </table>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <!--Pie de página-->
                        </div>
                        <!-- /.box-footer-->
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                    Todos los derechos reservados.
                </div>
                <!-- Default to the left -->
                <strong>Copyright &copy; 2023 </strong>
            </footer>

            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>
        <!--data table -->
        <script src="bower_components/datatables.net/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <!--SweetAlert -->
        <script src="SweetAlert/sweetalert.js" type="text/javascript"></script>
        <!--Funcion js -->
        <script src="js/funcionesUsuario.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('#tablaJuridica').DataTable();
            });
        </script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>


