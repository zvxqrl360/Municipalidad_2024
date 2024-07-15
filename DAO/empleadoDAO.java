package DAO;

import Model.Conexion;
import Model.empleado;
import Model.usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class empleadoDAO extends Conexion {

    // Método para obtener todos los empleados de la base de datos
    public List<empleado> listarEmpleados() throws Exception {
        List<empleado> empleados = new ArrayList<>();
        empleado empl;
        ResultSet rs = null;
        String sql = "SELECT E.IDEMPLEADO,E.NOMBRE,E.APELLIDOS,E.SEXO,E.TELEFONO,E.FECHANACIMIENTO,E.TIPODOCUMENTO,E.NUMERODOCUMENTO,U.NOMBREUSUARIO "
                + "FROM EMPLEADO E INNER JOIN USUARIO U ON U.IDUSUARIO=E.IDUSUARIO ORDER BY E.IDEMPLEADO";
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            while (rs.next() == true) {
                empl = new empleado();
                empl.setIdempleado(rs.getInt("IDEMPLEADO"));
                empl.setNombre(rs.getString("NOMBRE"));
                empl.setApellidos(rs.getString("APELLIDOS"));
                empl.setSexo(rs.getString("SEXO"));
                empl.setTelefono(rs.getInt("TELEFONO"));
                empl.setFechaNacimiento(rs.getDate("FECHANACIMIENTO").toLocalDate());
                empl.setTipoDocumento(rs.getString("TIPODOCUMENTO"));
                empl.setNumeroDocumento(rs.getInt("NUMERODOCUMENTO"));
                empl.setIdUsuario(new usuario());
                empl.getIdUsuario().setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                empleados.add(empl);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return empleados;
    }

    public void registrarEmpleado(empleado empl) throws Exception {
        String sql;
        sql = "INSERT INTO EMPLEADO (NOMBRE,APELLIDOS,SEXO,TELEFONO,FECHANACIMIENTO,TIPODOCUMENTO,NUMERODOCUMENTO,IDUSUARIO) "
                + "VALUES ('"+empl.getNombre()+"','"+ empl.getApellidos()+"','"+ empl.getSexo()+"','"+ empl.getTelefono()+"','"+ Date.valueOf(empl.getFechaNacimiento()) + "','" + empl.getTipoDocumento() + "', '" + empl.getNumeroDocumento() + "', '" + empl.getIdUsuario().getId_usuario() + "')";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public empleado leerEmpleado(empleado empl) throws Exception {
        empleado emple = null;
        ResultSet rs = null;
        String sql = "SELECT E.IDEMPLEADO,E.NOMBRE,E.APELLIDOS,E.SEXO,E.TELEFONO,E.FECHANACIMIENTO,E.TIPODOCUMENTO,E.NUMERODOCUMENTO,E.IDUSUARIO "
                + "FROM empleado E WHERE E.IDEMPLEADO = "+empl.getIdempleado();
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                emple = new empleado();
                emple.setIdempleado(rs.getInt("IDEMPLEADO"));
                emple.setNombre(rs.getString("NOMBRE"));
                emple.setApellidos(rs.getString("APELLIDOS"));
                emple.setSexo(rs.getString("SEXO"));
                emple.setTelefono(rs.getInt("TELEFONO"));
                emple.setFechaNacimiento(rs.getDate("FECHANACIMIENTO").toLocalDate());
                emple.setTipoDocumento(rs.getString("TIPODOCUMENTO"));
                emple.setNumeroDocumento(rs.getInt("NUMERODOCUMENTO"));
                emple.setIdUsuario(new usuario());
                emple.getIdUsuario().setId_usuario(rs.getInt("IDUSUARIO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return emple;
    }

    public void actualizarEmpleado(empleado empl) throws Exception {
        String sql = "UPDATE EMPLEADO SET NOMBRE='"+empl.getNombre()+"',APELLIDOS='"+empl.getApellidos()+"'"
                + ",SEXO='"+empl.getSexo()+"',TELEFONO='"+empl.getTelefono()+"',FECHANACIMIENTO='"+empl.getFechaNacimiento()+"'"
                + ",TIPODOCUMENTO='"+empl.getTipoDocumento()+"',NUMERODOCUMENTO='"+empl.getNumeroDocumento()+"'"
                + ",IDUSUARIO="+empl.getIdUsuario().getId_usuario()+" WHERE IDEMPLEADO = "+empl.getIdempleado();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(true);
            throw e;
        }
    }

    public void eliminarEmpleado(empleado empl) throws Exception{
        String sql="DELETE FROM EMPLEADO WHERE IDEMPLEADO="+empl.getIdempleado();
        try{
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        }catch(Exception e){
            this.cerrar(false);
            throw e;
        }
    }
}
