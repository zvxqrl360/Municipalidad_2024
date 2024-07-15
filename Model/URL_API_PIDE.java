
package Model;



public class URL_API_PIDE {
    
    // Método para obtener la URL de RENIEC para consultar DNI
    public static String URL_RENIEC_DNI(String dni) {
        // Aquí debes reemplazar con la URL real de la API que utilizas.
        return "https://api.reniec.gob.pe/consulta_dni?dni=" + dni;
    }
    
    // Método para obtener la URL de SUNARP para obtener base64
    public static String URL_SUNARP_BASE64(String transaccion, String tipo, String nroTotalPag, String nroPagRef, String pagina) {
        // Aquí debes reemplazar con la URL real de la API que utilizas.
        return "https://api.sunarp.gob.pe/consulta_base64?transaccion=" + transaccion 
                + "&tipo=" + tipo 
                + "&nroTotalPag=" + nroTotalPag 
                + "&nroPagRef=" + nroPagRef 
                + "&pagina=" + pagina;
    }
    public static String URL_SUNARP_PN(String tipoPart, String app, String apm, String nombres) {
        // Aquí debes reemplazar con la URL real de la API que utilizas.
        return "https://api.sunarp.gob.pe/consulta_pn?tipoPart=" + tipoPart 
                + "&app=" + app 
                + "&apm=" + apm 
                + "&nombres=" + nombres;
    }

    static String URL_SUNARP_PJ(String tipoPart, String razon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static String URL_SUNARP_ASIENTOS(String zona, String oficina, String registro, String nroPartida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

