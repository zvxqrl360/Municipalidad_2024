/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.tramiteDAO;
import Model.tramite;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ModuleLayer.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class svrconstancia extends HttpServlet {

   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


/**
 *
 * @author USER
 */
@WebServlet(name = "svrconstancia", urlPatterns = {"/svrconstancia"})
 
public class svrconstancia extends HttpServlet {

     public svrconstancia() {
        super();
    }

	
        @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            String tipo = request.getParameter("accion");

            if(tipo.equals("guardartramite"))
                try {
                    generartramite(request, response);
            } catch (Exception ex) {
                Logger.getLogger(svrtramite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
	protected void generartramite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

            /*String Nombre=request.getParameter("nombrePAG");
            String Apellidos=request.getParameter("apellidoPAG");
            int Dni=Integer.parseInt(request.getParameter("dniPAG"));
            String TipoTramite=request.getParameter("tipo-tramitePAG");*/
            
            String Nombre="Juan";
            String Apellidos= "Alvarez";
            int Dni= 73214588;
            String TipoTramite= "Constancia";
            
            tramite tra=new tramite();
            tra.setNombres(Nombre);
            tra.setApellidos(Apellidos);
            tra.setDni(Dni);
            tra.setTipo_tramite(TipoTramite);
            
            int dato = new tramiteDAO().agregarTramite(tra);
            
            if(dato>0)
            {
                
                System.out.println("Se ha guardado exitosamente");
                
                
                
            }
            
            
        }

}
}
   