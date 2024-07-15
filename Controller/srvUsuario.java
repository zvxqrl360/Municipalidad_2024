/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


//controller del apartado de usuario

import Model.cargo;
import DAO.cargoDAO;
import Model.usuario;
import DAO.usuarioDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})//linea para indicar la ruta
public class srvUsuario extends HttpServlet {

    //metodo para indicar acciones realizadas dentro del dashboard
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        
        
        try {
            if (accion != null) {
                switch (accion) {
                    case "index":
                        index(request, response);
                        break;
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarsession(request, response);
                        break;
                    case "listar_usuarios":
                        listar_usuarios(request, response);
                        break;
                    case "nuevo":
                        form_nuevo(request, response);
                        break;
                    case "registrar":
                        registrar_usuario(request, response);
                        break;
                    case "leer_usuario":
                        leer_usuario(request, response);
                        break;
                    case "actualizar_usuario":
                        actualizar_usuario(request, response);
                        break;
                    case "eliminar_usuario":
                        eliminar_usuario(request, response);
                        break;
                    default:
                        response.sendRedirect("identificar.jsp");
                }

            } else if (request.getParameter("cambiar") != null) {
                cambiar_estado(request, response);
            } else {
                response.sendRedirect("identificar.jsp");
            }
        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(srvUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(srvUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    //metodo que despues de identificar el tipo de cargo redirecciona a la vista predeterminada de cada cargo

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        usuarioDAO dao;
        usuario usuario;
        usuario = this.obtenerUsuario(request);
        dao = new usuarioDAO();
        usuario = dao.identificar(usuario);
        menu_controller_active.activa_menu(request, "menu_index");
        if (usuario != null && usuario.getCargo().getNombreCargo().equals("ADMINISTRADOR")) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido al sistema");
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
        } else if (usuario != null && usuario.getCargo().getNombreCargo().equals("VENTANILLA")) {
            sesion = request.getSession();
            sesion.setAttribute("ventanilla", usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
        } else {
            request.setAttribute("msje", "Credenciales Incorrectas");
            request.getRequestDispatcher("identificar.jsp").forward(request, response);
        }
    }

    //Permite cerrar sesion para ingresar con un nuev usuario
    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("identificar.jsp");
    }

    //Metodo creado dentro de la clase para obtener como objeto unicamente el Usuario y contrase;a ingresado en Form del Login
    private usuario obtenerUsuario(HttpServletRequest request) {
        usuario u = new usuario();
        u.setNombreUsuario(request.getParameter("txtUsu"));
        u.setClave(request.getParameter("txtPass"));
        return u;
    }

    //Metodo que proporciona todos los usuarios 
    private void listar_usuarios(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO dao = new usuarioDAO();
        List<usuario> usus = null;
        try {
            usus = dao.listarUsuarios();
            request.setAttribute("usuarios", usus);

        } catch (Exception e) {
            request.setAttribute("msje", "Error: No se pueden listar" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext()
                    .getRequestDispatcher("/vistas/usuario.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msje", "Error: No se puedo realizar la petición" + ex.getMessage());
        }
    }

    private void form_nuevo(HttpServletRequest request, HttpServletResponse response) {
        this.cargar_cargos(request);
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/nuevo_usuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar el formulario");
        }
    }

    private void cargar_cargos(HttpServletRequest request) {
        cargoDAO dao = new cargoDAO();
        List<cargo> car = null;
        try {
            car = dao.listarCargos();
            request.setAttribute("cargos", car);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los cargos :( " + e.getMessage());
        } finally {
            car = null;
            dao = null;
        }
    }

    private void registrar_usuario(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO daoUsu;
        usuario usu = null;
        cargo carg;
        if (request.getParameter("txtNombre") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("cboCargo") != null) {
            usu = new usuario();
            usu.setNombreUsuario(request.getParameter("txtNombre"));
            usu.setClave(request.getParameter("txtClave"));

            carg = new cargo();
            carg.setCodigo(Integer.parseInt(request.getParameter("cboCargo")));
            usu.setCargo(carg);

            usu.setEstado(true);
            daoUsu = new usuarioDAO();
            try {
                daoUsu.registrarUsuarios(usu);
                response.sendRedirect("srvUsuario?accion=listar_usuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el usuario" + e.getMessage());
                request.setAttribute("usuario", usu);
                this.form_nuevo(request, response);
            }
        }
    }

    private void leer_usuario(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO dao;
        usuario usus;
        if (request.getParameter("cod") != null) {
            usus = new usuario();
            usus.setId_usuario(Integer.parseInt(request.getParameter("cod")));
            dao = new usuarioDAO();
            try {
                usus = dao.leerUsuario(usus);
                if (usus != null) {
                    request.setAttribute("usuario", usus);
                } else {
                    request.setAttribute("msje", "No existe el usuario");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo establecer la conexion info:" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "Un dato es incorrecto");
        }
        try {
            this.cargar_cargos(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/actualizar_usuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se puedo realizar la consulta info:" + e.getMessage());
        }
    }

    private void actualizar_usuario(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO daoUsu;
        usuario usus = null;
        cargo car;
        if (request.getParameter("hCodigo") != null
                && request.getParameter("txtNombre") != null
                && request.getParameter("txtClave") != null
                && request.getParameter("cboCargo") != null) {
            usus = new usuario();
            usus.setId_usuario(Integer.parseInt(request.getParameter("hCodigo")));
            usus.setNombreUsuario(request.getParameter("txtNombre"));
            usus.setClave(request.getParameter("txtClave"));
            car = new cargo();
            car.setCodigo(Integer.parseInt(request.getParameter("cboCargo")));
            usus.setCargo(car);
            if (request.getParameter("chkEstado") != null) {
                usus.setEstado(true);
            } else {
                usus.setEstado(false);
            }
            daoUsu = new usuarioDAO();
            try {
                daoUsu.actualizarUsuarios(usus);
                response.sendRedirect("srvUsuario?accion=listar_usuarios");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el usuario info:" + e.getMessage());
                request.setAttribute("usuario", usus);
            }
            try {
                this.cargar_cargos(request);
                this.getServletConfig().getServletContext().
                        getRequestDispatcher("/vistas/actualizar_usuario.jsp"
                        ).forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());

            }
        }
    }

    private void eliminar_usuario(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO dao = new usuarioDAO();
        usuario usus = new usuario();
        if (request.getParameter("cod") != null) {
            usus.setId_usuario(Integer.parseInt(request.getParameter("cod")));
            try {
                dao.eliminarUsuario(usus);
                response.sendRedirect("srvUsuario?accion=listar_usuarios");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo acceder a la base de datos info:" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro el usuario");
        }
    }

    private void cambiar_estado(HttpServletRequest request, HttpServletResponse response) {
        usuarioDAO dao;
        usuario usu;
        try {
            dao = new usuarioDAO();
            usu = new usuario();
            if (request.getParameter("cambiar").equals("activar")) {
                usu.setEstado(true);
            } else {
                usu.setEstado(false);
            }

            if (request.getParameter("cod") != null) {
                usu.setId_usuario(Integer.parseInt(request.getParameter("cod")));
                dao.cambiarEstado(usu);
            } else {
                request.setAttribute("msje", "No es encontro el usuario");
            }

        } catch (Exception e) {
            request.setAttribute("msje", e.getMessage());
        }
        this.listar_usuarios(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        try {
            menu_controller_active.activa_menu(request, "menu_index");
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/index.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar el formulario");
        }
    }
}
