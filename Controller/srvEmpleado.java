/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.empleado;
import DAO.empleadoDAO;
import Model.usuario;
import DAO.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "srvEmpleado", urlPatterns = {"/srvEmpleado"})//linea para indicar la ruta
public class srvEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "listar_empleados":
                        listar_empleados(request, response);
                        break;
                    case "nuevo_empleado":
                        nuevo_empleado(request, response);
                        break;
                    case "registrar_empleado":
                        registrar_empleado(request, response);
                        break;
                    case "leer_empleado":
                        leer_empleadoo(request, response);
                        break;
                    case "actualizar_empleado":
                        actualizar_empleado(request, response);
                        break;
                    case "eliminar_empleado":
                        eliminar_empleado(request, response);
                        break;
                    default:
                        response.sendRedirect("identificar.jsp");
                }
            }

        } catch (Exception e) {

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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private void cargar_usuarios(HttpServletRequest request) {
        usuarioDAO dao = new usuarioDAO();
        List<usuario> usu = null;
        try {
            usu = dao.listarUsuarios();
            request.setAttribute("usuarios", usu);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios info:" + e.getMessage());
        } finally {
            usu = null;
            dao = null;
        }
    }

    private void cargar_usuarios_disponibles(HttpServletRequest request) {
        usuarioDAO dao = new usuarioDAO();
        List<usuario> usu = null;
        try {
            usu = dao.listarUsuariosDisponibles();
            request.setAttribute("usuarios", usu);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar los usuarios info:" + e.getMessage());
        } finally {
            usu = null;
            dao = null;
        }
    }

    private void listar_empleados(HttpServletRequest request, HttpServletResponse response) {
        empleadoDAO dao = new empleadoDAO();
        List<empleado> emple = null;
        try {
            emple = dao.listarEmpleados();
            request.setAttribute("empleados", emple);
        } catch (Exception e) {
            request.setAttribute("msje", "Error: No se pueden listar info: " + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/empleado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "Error: No se puedo realizar la peticion info: " + e.getMessage());
        }
    }

    private void nuevo_empleado(HttpServletRequest request, HttpServletResponse response) {
        this.cargar_usuarios_disponibles(request);
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/nuevo_empleado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar");
        }
    }

    private void registrar_empleado(HttpServletRequest request, HttpServletResponse response) {
        empleadoDAO daoempl = new empleadoDAO();
        empleado empl = null;
        usuario usus;
        if (request.getParameter("txtNombre") != null && request.getParameter("txtApellidos") != null
                && request.getParameter("txtSexo") != null && request.getParameter("txtTelefono") != null
                && request.getParameter("txtFechaNacimiento") != null && request.getParameter("txtTipoDocumento") != null
                && request.getParameter("txtNumeroDocumento") != null && request.getParameter("cboUsuarios") != null) {
            empl = new empleado();
            empl.setNombre(request.getParameter("txtNombre"));
            empl.setApellidos(request.getParameter("txtApellidos"));
            empl.setSexo(request.getParameter("txtSexo"));
            empl.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
            empl.setFechaNacimiento(LocalDate.parse(request.getParameter("txtFechaNacimiento")));
            empl.setTipoDocumento(request.getParameter("txtTipoDocumento"));
            empl.setNumeroDocumento(Integer.parseInt(request.getParameter("txtNumeroDocumento")));

            usus = new usuario();
            usus.setId_usuario(Integer.parseInt(request.getParameter("cboUsuarios")));
            empl.setIdUsuario(usus);

            try {
                daoempl.registrarEmpleado(empl);
                response.sendRedirect("srvEmpleado?accion=listar_empleados");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo registraar el empleado");
                request.setAttribute("empleado", empl);
                this.nuevo_empleado(request, response);
            }
        }
    }

    private void leer_empleadoo(HttpServletRequest request, HttpServletResponse response) {
        empleadoDAO dao;
        empleado emplea;
        
        if (request.getParameter("cod_empleado") != null) {
            emplea = new empleado();
            emplea.setIdempleado(Integer.parseInt(request.getParameter("cod_empleado")));
            dao = new empleadoDAO();
            try {
                emplea=dao.leerEmpleado(emplea);
                if (emplea != null) {
                    request.setAttribute("empleado", emplea);
                } else {
                    request.setAttribute("msje", "No existe el empleado");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo establecer la conexion info:" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "Un dato es incorrecto");
        }
        try {
            this.cargar_usuarios(request);
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/actualizar_empleado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo realizar la consulta info:" + e.getMessage());
        }
    }

    private void actualizar_empleado(HttpServletRequest request, HttpServletResponse response) {
        empleadoDAO daoempl;
        empleado emple;
        usuario usu;
        if (request.getParameter("txtNombre") != null) {
            emple = new empleado();
            emple.setIdempleado(Integer.parseInt(request.getParameter("hCodigo_empleado")));
            emple.setNombre(request.getParameter("txtNombre"));
            emple.setApellidos(request.getParameter("txtApellidos"));
            emple.setSexo(request.getParameter("txtSexo"));
            emple.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
            emple.setFechaNacimiento(LocalDate.parse(request.getParameter("txtFechaNacimiento")));
            emple.setTipoDocumento(request.getParameter("txtTipoDocumento"));
            emple.setNumeroDocumento(Integer.parseInt(request.getParameter("txtNumeroDocumento")));
            usu = new usuario();
            usu.setId_usuario(Integer.parseInt(request.getParameter("cboUsuarios").split("-")[0]));
            emple.setIdUsuario(usu);
            daoempl = new empleadoDAO();
            try {
                daoempl.actualizarEmpleado(emple);
                response.sendRedirect("srvEmpleado?accion=listar_empleados");
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo actualizar el empleado info:" + e.getMessage());
                request.setAttribute("empleado", emple);
            }
            try {
                this.cargar_usuarios(request);
                this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/actualizar_empleado.jsp").forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("msje", "No se pudo realizar la operacion" + ex.getMessage());
            }
        }
    }

    private void eliminar_empleado(HttpServletRequest request, HttpServletResponse response) {
        empleadoDAO dao = new empleadoDAO();
        empleado emple = new empleado();
        if (request.getParameter("cod_empleado") != null) {
            emple.setIdempleado(Integer.parseInt(request.getParameter("cod_empleado")));
            try {
                dao.eliminarEmpleado(emple);
                response.sendRedirect("srvEmpleado?accion=listar_empleados");
            } catch (Exception e) {
                request.setAttribute("msje", "No sse pudo acceder a la base de datos info:" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "No se encontro al empleado");
        }
    }
}
