<%-- 
    Document   : actualizar_empleado
    Created on : 16 jun. 2023, 01:12:02
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
                    <div class="row">
                        <div class="col-xs-12 col-md-3">
                        </div>
                        <div class="col-md-3 hidden-xs"></div>
                        <div class="col-xs-2 col-md-1">
                        </div>
                        <div class="col-xs-10 col-md-5 ">
                            <div class="btn-group pull-right">
                                <a href="srvEmpleado?accion=listar_empleados" class="btn btn-default">
                                    <i class="fa fa-align-justify"></i> Ver listado</a>                                              
                            </div>
                        </div>
                    </div>
                </section>
                <section class="content">
                    <div class="box">
                        <div class="box-header with-border">
                            <i class="fa fa-edit"></i> <h3 class="box-title">Actualizar Datos del Empleado</h3>  
                        </div>
                        <form class="form-horizontal" action="srvEmpleado?accion=actualizar_empleado" method="post">
                            
                            
                            <input type="hidden" name="hCodigo_empleado" value="${empleado.idempleado}">
                            
                            
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Nombre</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="" name="txtNombre" maxlength="100"
                                               value="${empleado.nombre}">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Apellidos</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="Apellido" name="txtApellidos" maxlength="100"
                                               value="${empleado.apellidos}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Sexo</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="" name="txtSexo" maxlength="100"
                                               value="${empleado.sexo}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Telefono</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="" name="txtTelefono" maxlength="100"
                                               value="${empleado.telefono}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Fecha de Nacimiento</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="date" class="form-control" placeholder="" name="txtFechaNacimiento" maxlength="100"
                                               value="${empleado.fechaNacimiento}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Tipo Documento</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="" name="txtTipoDocumento" maxlength="1"
                                               value="${empleado.tipoDocumento}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Numero de Documento</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input id="nombre" type="text" class="form-control" placeholder="" name="txtNumeroDocumento" maxlength="11"
                                               value="${empleado.numeroDocumento}">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Usuario</label>
                                    <div class="col-sm-4 input-group">
                                        <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                        <select class="form-control"  name="cboUsuarios" autofocus=""  required="">
                                            <option value="0">Seleccione un Usuario</option>
                                            <c:forEach items="${usuarios}" var="usu">
                                                <option value="${usu.id_usuario}"  
                                                        <c:if test="${usu.id_usuario == 
                                                                      empleado.idUsuario.id_usuario}">
                                                              selected
                                                        </c:if>
                                                        >${usu.id_usuario}-${usu.nombreUsuario}</option>
                                            </c:forEach>
                                        </select>
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
    </body>
</html>
<%
    } else {
        response.sendRedirect("identificar.jsp");
    }
%>

