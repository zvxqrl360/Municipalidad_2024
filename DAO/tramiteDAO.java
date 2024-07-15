package DAO;

import Model.Conexion;
import Model.empleado;
import Model.tramite;
import Model.usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class tramiteDAO extends Conexion {
    
    
  //Metodo para agregar//
    
     public int agregarTramite(tramite tram) throws Exception {
        String sql = "INSERT INTO tramite (Nombres, Apellidos, DNI, tipo_tramite) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        int resultado = 0;

        try {
            this.conectar(false); // Conectar sin autocommit
            Connection conn = this.getConexion(); // Obtener conexión

            ps = conn.prepareStatement(sql);
            ps.setString(1, tram.getNombres());
            ps.setString(2, tram.getApellidos());
            ps.setInt(3, tram.getDni());
            ps.setString(4, tram.getTipo_tramite());
             resultado = ps.executeUpdate();
            conn.commit(); // Hacer commit de la transacción
        } catch (SQLException e) {
            this.cerrar(false); // Cerrar la conexión y hacer rollback en caso de error
            resultado = -1;
            throw e;
        } finally {
            if (ps != null) {
                ps.close(); // Cerrar el PreparedStatement
            }
            this.cerrar(true); // Cerrar la conexión
        }
        return resultado;
    }
        }
    






    
    
    
    
    
    
    
    
      // Método para obtener todos los tramites de la base de datos
    
     /*  public List<tramite> listarTramite() throws Exception {
        List<tramite> tramite = new ArrayList<>();
        tramite tram;
        ResultSet rs = null;
        
        String sql = "SELECT E.idtramite,E.Nombre,E.Apellidos,E.DNI,E.tipo_tramite,E.fecha_creacion";
              
       
        try {
                        
            
             this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            while (rs.next() == true) {
                tram = new tramite();
                tram.setIdtramite(rs.getInt("idtramite"));
                tram.setNombres(rs.getString("Nombres"));
                tram.setApellidos(rs.getString("Apellidos"));
                tram.setDni(rs.getInt("DNI"));
                tram.setTipo_tramite(rs.getString("tipo_tramite"));
                
                             
                tramite.add(tram);
             }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return tramite;
    }*/
    
    
    



    // Método para leer un trámite específico basado en su id
       
        /*  public tramite leerTramite(empleado empl) throws Exception {
        tramite tram = null;
        ResultSet rs = null;
        
             
        String sql = "SELECT E.idtramite,E.Nombre,E.Apellidos,E.DNI,E.tipo_tramite,E.fecha_creacion";
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                tram = new tramite();
               
                tram.setIdtramite(rs.getInt("idTramite"));
                tram.setNombres(rs.getString("nombres"));
                tram.setApellidos(rs.getString("apellidos"));
                tram.setDni(rs.getInt("dni"));
                tram.setTipo_tramite(rs.getDate("tipo_tramite").toLocalDate());
                tram.setFecha_creacion(rs.getDate("fecha_creacion").toLocalDate());
      
                   }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return tram;
    }*/
        
        
  

  /*  private void prepararOrden(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private ResultSet ejecutarOrdenDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void GenerarTramite(tramite tram) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}*/

 