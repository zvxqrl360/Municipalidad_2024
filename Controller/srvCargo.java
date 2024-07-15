
package Controller;

import DAO.cargoDAO;
import Model.cargo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "srvCargo", urlPatterns = {"/srvCargo"})//linea para indicar la ruta
public class srvCargo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "cerrar":
                        cerrarsession(request, response);
                        break;
                    case "listar_cargos":
                        listar_cargos(request, response);
                        break;
                    case "leer_cargo":
                        leer_cargo(request, response);
                        break;
                    case "nuevo":
                        cargo_nuevo(request, response);
                        break;
                    case "registrar_cargo":
                        registrar_cargo(request, response);
                        break;
                    case "actualizar_cargo":
                        actualizar_cargo(request, response);
                        break;
                    case "eliminar_cargo":
                        eliminar_cargo(request, response);
                        break;
                    default:
                        response.sendRedirect("identificar.jsp");
                }
            }else if(request.getParameter("cambiar") != null){
                cambiar_estado(request, response);  
            } else {
                response.sendRedirect("identificar.jsp");
            }
        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
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

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("identificar.jsp");

    }

    private void listar_cargos(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO dao = new cargoDAO();
        List<cargo> carg = null;
        try {
            carg = dao.listarCargos();
            request.setAttribute("cargos", carg);
        } catch (Exception e) {
            request.setAttribute("msje", "No se puede listar los cargos info:" + e.getMessage());
        } finally {
            dao = null;
        }
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/cargo.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msj", "No se puede realizar la consulta info:" + ex.getMessage());
        }
    }

    private void cargo_nuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/nuevo_cargo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se pudo cargar el formulario");
        }
    }

    private void registrar_cargo(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO daoCar;
        cargo car;
        if (request.getParameter("txtNombreCargo").trim().length() != 0){
            car = new cargo();
            //car.setNombreCargo("x");
            car.setNombreCargo(request.getParameter("txtNombreCargo"));
            car.setEstado(true); 
            daoCar=new cargoDAO();
            try {
                daoCar.registrarCargo(car);
                response.sendRedirect("srvCargo?accion=listar_cargos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo registrar el cargo" + e.getMessage());
                this.cargo_nuevo(request, response);
            }
        }else{
            this.cargo_nuevo(request, response);
        }
    }

    private void leer_cargo(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO dao;
        cargo carg;
        if (request.getParameter("cod_cargo") != null) {
            carg = new cargo();
            carg.setCodigo(Integer.parseInt(request.getParameter("cod_cargo")));
            dao = new cargoDAO();
            try {
                carg = dao.leerCargo(carg);
                if (carg != null) {
                    request.setAttribute("cargo", carg);
                } else {
                    request.setAttribute("msje", "No existe el Cargo");
                }
            } catch (Exception e) {
                request.setAttribute("msje", "No se pudo establecer la conexion info:" + e.getMessage());
            }
        } else {
            request.setAttribute("msje", "Un dato es incorrecto");
        }
        try {
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/actualizar_cargo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msje", "No se puedo realizar la consulta info:" + e.getMessage());
        }
    }

    private void actualizar_cargo(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO daocar;
        cargo carg = null;

        if (request.getParameter("hCodigo_cargo") != null
                && request.getParameter("txtNombreCargo") != null) {

            carg = new cargo();
            carg.setCodigo(Integer.parseInt(request.getParameter("hCodigo_cargo")));
            carg.setNombreCargo(request.getParameter("txtNombreCargo"));
            if (request.getParameter("chkEstado") != null) {
                carg.setEstado(true);
            } else {
                carg.setEstado(false);
            }
            daocar = new cargoDAO();
            try {
                daocar.actualizarCargo(carg);
                response.sendRedirect("srvCargo?accion=listar_cargos");
            } catch (Exception e) {
                request.setAttribute("msje",
                        "No se pudo actualizar el cargo info:" + e.getMessage());
                request.setAttribute("cargo", carg);

            }
        }
    }

    private void eliminar_cargo(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO dao = new cargoDAO();
        cargo carg = new cargo();
        if (request.getParameter("cod_cargo")!=null){
            carg.setCodigo(Integer.parseInt(request.getParameter("cod_cargo")));
            try{
                dao.eliminarCargo(carg);
                response.sendRedirect("srvCargo?accion=listar_cargos");
            }catch(Exception e){
                request.setAttribute("msje", "No se pudo acceder a la base de datos info:" + e.getMessage());
            }
        }else{
            request.setAttribute("msje", "No se encontro el cargo");
        }      
    }
    
        private void cambiar_estado(HttpServletRequest request, HttpServletResponse response) {
        cargoDAO dao;
        cargo car;
        try {
            dao = new cargoDAO();
            car = new cargo();
            if (request.getParameter("cambiar").equals("activar")){
                car.setEstado(true);
            }else {
                car.setEstado(false);
            }
            
            if (request.getParameter("cod") != null) {
                car.setCodigo(Integer.parseInt(request.getParameter("cod")));
                dao.cambiarEstado(car);
            } else {
                request.setAttribute("msje", "No es encontro el usuario");
            }

        } catch (Exception e) {
            request.setAttribute("msje", e.getMessage());
        }
        this.listar_cargos(request, response);
    }
}
