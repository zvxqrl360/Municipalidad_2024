
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.tramiteDAO;
import Model.tramite;
import java.time.LocalDate;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;





@WebServlet("/svrtramite")


public class svrtramite extends HttpServlet {

 public svrtramite() {
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




