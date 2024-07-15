/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Conexion;
import Model.cargo;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class cargoDAO extends Conexion {

    public List<cargo> listarCargos() throws Exception {
        List<cargo> cargos;
        cargo car;
        ResultSet rs = null;
        String sql = "SELECT C.IDCARGO,C.NOMBRECARGO,C.ESTADO FROM cargo C ORDER BY C.IDCARGO";
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            cargos = new ArrayList<>();
            while (rs.next() == true) {
                car = new cargo();
                car.setCodigo(rs.getInt("IDCARGO"));
                car.setNombreCargo(rs.getString("NOMBRECARGO"));
                car.setEstado(rs.getBoolean("ESTADO"));
                cargos.add(car);
            }
            this.cerrar(true);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return cargos;
    }

    public void registrarCargo(cargo car) throws Exception {
        String sql;
        sql =  "INSERT INTO cargo (NOMBRECARGO, ESTADO) VALUES ('" + car.getNombreCargo() + "', " + (car.isEstado() == true ? "1" : "0") + " ) ";
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public cargo leerCargo(cargo car) throws Exception {
        cargo carg = null;
        ResultSet rs = null;
        String sql = "SELECT C.IDCARGO,C.NOMBRECARGO,C.ESTADO FROM cargo C WHERE C.IDCARGO = " + car.getCodigo();
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos(sql);
            if (rs.next() == true) {
                carg = new cargo();
                carg.setCodigo(rs.getInt("IDCARGO"));
                carg.setNombreCargo(rs.getString("NOMBRECARGO"));
                carg.setEstado(rs.getBoolean("ESTADO"));
            }
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        } finally {
        }
        return carg;
    }

    public void actualizarCargo(cargo car) throws Exception {
        String sql = "UPDATE cargo SET nombreCargo = '" + car.getNombreCargo() + "', ESTADO = " + (car.isEstado() == true ? "1" : "0") + " WHERE IDCARGO = " + car.getCodigo();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }

    public void eliminarCargo(cargo car) throws Exception {
        String sql = "DELETE FROM cargo WHERE IDCARGO = " + car.getCodigo();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    //FIN DEL CRUD( CREATE,READ,UPDATE,DELETE)
    //opciona para apartado de Estado
    public void cambiarEstado(cargo carg) throws Exception {
        String sql = "UPDATE cargo SET estado = " + (carg.isEstado() == true ? "1" : "0") + " WHERE IDCARGO = " + carg.getCodigo();
        try {
            this.conectar(false);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
}
