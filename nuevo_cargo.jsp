<%-- 
    Document   : nuevo_cargo
    Created on : 8 jun. 2023, 10:19:23
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
    </head>

    <body class="hold-transition skin-green sidebar-mini">
        
        
        
        <div class="wrapper">

            <!-- Main -->
            <c:import url="/menu_user.jsp" />
            <!-- apartado izquierdo del menu -->
           

            <!-- Detalles de la envoltura para los accesos rapidos a reportes -->
            <div class="content-wrapper">
                <section class="content-header">
                    <div class="row">
                        <div class="col-xs-12 col-md-3">
                        </div>
                        <div class="col-md-3 hidden-xs"></div>
                        <div class="col-xs-2 col-md-1">
                        </div>
                        <div class="col-xs-10 col-md-5 ">
                            <div class="btn-group pull-right">
                                <a href="srvCargo?accion=listar_cargos" class="btn btn-default">
                                    <i class="fa fa-align-justify"></i> Ver listado</a>                                              
                            </div>
                        </div>
                    </div>
                </section>
                <section class="content">
                
                    
                    <div class="box">
                        <div class="box-header with-border">
                            <i class="fa fa-edit"></i> <h3 class="box-title">Registrar Nuevo Cargo</h3>  
                        </div>
                        <form class="form-horizontal" action="srvCargo?accion=registrar_cargo" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Nombre Cargo</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="Ejem: Admin" name="txtNombreCargo" maxlength="10"
                                               value="">
                                    </div>
                                </div>
                            </div>
                            
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="reset" class="btn btn-danger" ><i class="fa fa-close red"></i> Cancelar</button>
                                <button type="submit" id="" name="btnRegistrar" value="Registrar" class="btn btn-success" ><i class="fa fa-floppy-o"></i> Registrar</button>

                            </div>
                            
    
                            <!-- /.box-footer -->
                        </form>
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

    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>
