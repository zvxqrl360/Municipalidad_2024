package Model;

import java.time.LocalDate;

public class tramite {
    private int idtramite;
    private String nombres;
    private String apellidos;
    private int dni;
    private String tipo_tramite;

    public int getIdtramite() {
        return idtramite;
    }

    public void setIdtramite(int idtramite) {
        this.idtramite = idtramite;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTipo_tramite() {
        return tipo_tramite;
    }

    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }
}
