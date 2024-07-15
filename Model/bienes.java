package Model;

public class bienes {

    // razon , 
    private String razon;
    private String registro;
    private String Groupby;
    private String libro;
    private String apPaterno;
    private String apMaterno;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String numeroPartida;
    private String numeroPlaca;
    private String estado;
    private String zona;
    private String oficina;
    private String direccion;

    
    
    public bienes() {
    }

    public bienes(String key, String tipo) {
        //String apPaterno, String apMaterno, String nombre, String tipoDocumento, String numeroDocumento
        if (tipo.equals("N")) {
            this.tipoDocumento = key.split("Ä")[0];
            this.numeroDocumento = key.split("Ä")[1];
            this.nombre = key.split("Ä")[2];
            this.apPaterno = key.split("Ä")[3];
            this.apMaterno = key.split("Ä")[4];
        } else {
            this.tipoDocumento = key.split("Ä")[0];
            this.numeroDocumento = key.split("Ä")[1];
            this.razon = key.split("Ä")[2];

        }

    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(String numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getDireccion() {
        if (direccion == null) {
            return "-";
        } else {
            if (direccion.trim().length() == 0) {
                return "-";
            } else {
                return direccion;
            }
        }
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setGroupby_Natural() {
        this.Groupby = tipoDocumento + "Ä" + numeroDocumento + "Ä" + nombre + "Ä" + apMaterno + "Ä" + apMaterno;
    }

    public void setGroupby_Juridica() {
        this.Groupby = tipoDocumento + "Ä" + numeroDocumento + "Ä" + razon;
    }

    public String getGroupby() {
        return Groupby;
    }

    public String getNumeroPlaca() {
        if (numeroPlaca == null) {
            return "-";
        } else {
            if (numeroPlaca.trim().length() == 0) {
                return "-";
            } else {
                return numeroPlaca;
            }
        }
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

}
