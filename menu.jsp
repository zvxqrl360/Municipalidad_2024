 <style>
    /* Estilos para el modo oscuro */
    body.dark-mode {
        background-color: black;
        color: white;
    }
    
    body.dark-mode .content-wrapper {
        background-color: #444;
        color: black;
    }

    body.dark-mode table.dataTable {
        background-color: black;
        color: white;
    }

    body.dark-mode table.dataTable th {
        background-color: #555;
        color: white;
    }

    body.dark-mode table.dataTable tr.even {
        background-color: #333;
    }

    body.dark-mode table.dataTable tr.odd {
        background-color: #444;
    }

    body.dark-mode table.dataTable td {
        border-color: #777;
    }

    body.dark-mode .breadcrumb li a,
    body.dark-mode .breadcrumb li.active {
        color: white;
    }

    body.dark-mode .content-header h1 {
        color: white;
    }
    #modoOscuro {
        margin-top: 7px;
        margin-left: 10px;
        background-color: #444; 
        color: #ffffff; /* Color de texto blanco */
         border:#ffffff;
    }
</style>



<ul class="sidebar-menu" data-widget="tree">
    <li class="header">INICIO</li>
    <!-- Apartados que se pueden ingresar -->
    <li class="${menu_index}" ><a href="srvUsuario?accion=index"><i class="fa fa-link"></i> <span>Panel Administrativo</span></a></li>

    <li class="treeview">
        <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>REGISTROS</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
            <li id="cargos" class="${urlActual.contains('srvCargo') ? 'active' : ''}"><a href="srvCargo?accion=listar_cargos"><i class="fa fa-sharp fa-regular fa-user-secret"></i>Cargos</a></li>
            <li id="usuarios" class="${urlActual.contains('srvUsuario') ? 'active' : ''}"><a href="srvUsuario?accion=listar_usuarios"><i class="fa fa-users"></i>Usuarios</a></li>
            <li id="empleados" class="${urlActual.contains('srvEmpleado') ? 'active' : ''}"><a href="srvEmpleado?accion=listar_empleados"><i class="fa fa-user-plus"></i>Empleados</a></li>
        </ul>
    </li>
    <li class="treeview ${menu_reniec}" >
        <a href="#"><i class="fa fa-cart-arrow-down"></i> <span>RENIEC</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">

            <li class="${menu_reniec}"><a href="srvReniec?accion=cargar_vista"><i class="fa fa-address-card-o "></i>Consultar DNI</a></li>

        </ul>
    </li>
    <li class="treeview ${menu_sunarp_titu} ${menu_sunarp_parti}">
        <a href="#"><i class="fa fa-area-chart"></i> <span>SUNARP</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">

            <li class="${menu_sunarp_titu}"><a href="srvSunarp?accion=vista_titularidad"><i class="fa fa-bar-chart"></i>Titularidad</a></li>
            <li class="${menu_sunarp_parti}"> <a href="srvSunarp?accion=vista_asientos"><i class="fa fa-bar-chart"></i>Asientos</a></li>

        </ul>
            
    </li>
    <li class="treeview">
        <a href="#"><i class="fa fa-area-chart"></i> <span>TRAMITES</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">

            <li><a href="TramiteServlet?accion=generar-tramite"><i class="fa fa-bar-chart"></i>Generar Tr�mite</a></li>

        </ul>
            
    </li>
</ul>
 <button id="modoOscuro" class="btn btn-default slide-out pull-left">
                    <i class="fa fa-eye"></i> Modo Oscuro
                  </button>           
            
                            <script>
            document.getElementById("modoOscuro").addEventListener("click", function() {
              document.body.classList.toggle("dark-mode");
              this.classList.toggle("slide-in");
              this.innerHTML = this.classList.contains("slide-in") ? '<i class="fa fa-eye-slash"></i> Modo Claro' : '<i class="fa fa-eye"></i> Modo Oscuro';
            });
        </script>