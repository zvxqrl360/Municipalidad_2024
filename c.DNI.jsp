<%-- Document : C.DNI Created on : 27 jun. 2023, 11:43:49 Author : Admin --%>

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
                    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
                        name="viewport">



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
                                    Generar Consulta
                                    <small>DNI</small>
                                </h1>
                                <ol class="breadcrumb">
                                    <li><a href="srvUsuario?accion=index"><i class="fa fa-dashboard"></i> Inicio</a>
                                    </li>
                                    <li class="active">Generar consulta</li>
                                </ol>
                            </section>

                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Rellena los datos</h3>
                                </div>
                                <div class="box-body">





                                    <form class="form-horizontal" action="srvReniec?accion=generar_consulta"
                                        method="post">
                                        <div class="box-body">


                                            <div class="col-md-4">
                                                <label class="col-md-2 control-label">DNI :</label>


                                                <div class="col-md-10 input-group">
                                                    <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                                    <input maxlength="8" type="text" inputmode="numeric"
                                                        class="form-control" id="txtDNI" name="txtDNI"
                                                        oninput="validateInput()" required>
                                                </div>

                                                <script>
                                                    function validateInput() {
                                                        var inputField = document.getElementById('txtDNI');
                                                        var submitButton = document.getElementById('submitBtn');

                                                        // Obtener el valor del campo de entrada
                                                        var inputValue = inputField.value.trim();

                                                        // Validar si el valor contiene solo números y tiene exactamente 8 dígitos
                                                        if (/^\d{8}$/.test(inputValue)) {
                                                            // Habilitar el botón si el valor es válido
                                                            submitButton.disabled = false;
                                                        } else {
                                                            // Deshabilitar el botón si el valor no es válido
                                                            submitButton.disabled = true;
                                                        }
                                                    }
                                                </script>

                                            </div>
                                            <div class="row">
                                                <button type="submit" id="submitBtn"
                                                    class="btn btn-primary ">Buscar</button>
                                            </div>
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
                <% } else { response.sendRedirect("identificar.jsp"); } %>