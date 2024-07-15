package Model;

public class reniec_dni {

    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;

    private String estadoCivil;
    private String Restriccion;
    private String imgb64;

    public void setUbigeo(String ubigeo) {
        this.departamento = ubigeo.split("/")[0];
        this.provincia = ubigeo.split("/")[1];
        this.distrito = ubigeo.split("/")[2];
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRestriccion() {
        return Restriccion;
    }

    public void setRestriccion(String Restriccion) {
        this.Restriccion = Restriccion;
    }

    public String getImgb64() {
        return imgb64;
    }

    public void setImgb64(String imgb64) {
        this.imgb64 = imgb64;
    }

}
