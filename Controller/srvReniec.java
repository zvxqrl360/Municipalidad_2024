package Controller;

import Model.ConexionAPI;
import DATA.bienesData;
import Model.reniec_dni;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "srvReniec", urlPatterns = {"/srvReniec"})//linea para indicar la ruta
public class srvReniec extends HttpServlet {

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
                    case "cargar_vista":
                        cargar_vista(request, response);
                        break;
                    case "generar_consulta":
                        generar_consulta(request, response);
                        break;
                    default:
                        response.sendRedirect("identificar.jsp");
                }
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

    private void cargar_vista(HttpServletRequest request, HttpServletResponse response) {
        try {
           menu_controller_active.activa_menu(request, "menu_reniec");
           
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/c.DNI.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar");
        }
    }

    private void cargar_datos(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/datosDNI.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar");
        }
    }

    private void generar_consulta(HttpServletRequest request, HttpServletResponse response) {
        reniec_dni dni_obj = null;
        ConexionAPI api = new ConexionAPI();
        String dni = request.getParameter("txtDNI");
        try {
            dni_obj = api.consultarDNI(dni);

            request.setAttribute("datos_dni", dni_obj);
        } catch (Exception e) {
            request.setAttribute("msje", (Object) ("No se pudo establecer la conexion info:" + e.getMessage()));

        }
        this.cargar_datos(request, response);
    }

}
