
package Model;

import DATA.JsonData;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class asiento {
    private String transaccion;
    private String nroTotalPag;
    private String idlmgAsineto;
    private String numPag;
    private String tipo;
    private String nroPagRef;
    private String pagina;
    private String imgb64;

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getNroTotalPag() {
        return nroTotalPag;
    }

    public void setNroTotalPag(String nroTotalPag) {
        this.nroTotalPag = nroTotalPag;
    }

    public String getIdlmgAsineto() {
        return idlmgAsineto;
    }

    public void setIdlmgAsineto(String idlmgAsineto) {
        this.idlmgAsineto = idlmgAsineto;
    }

    public String getNumPag() {
        return numPag;
    }

    public void setNumPag(String numPag) {
        this.numPag = numPag;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNroPagRef() {
        return nroPagRef;
    }

    public void setNroPagRef(String nroPagRef) {
        this.nroPagRef = nroPagRef;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getImgb64() {
        return imgb64;
    }

    public void setImgb64(String imgb64) {
        this.imgb64 = imgb64;
    }
    
    public void obtener64(){
        OkHttpClient client = new OkHttpClient();
        String url = URL_API_PIDE.URL_SUNARP_BASE64(transaccion,tipo,nroTotalPag,nroPagRef,pagina);  // Reemplaza con la URL de la API que deseas consultar
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                JSONObject responseDataJson = new JSONObject(responseData);
                imgb64=JsonData.getDataFrom(responseDataJson, "verAsientoSIRSARPResponse/img"); 
            } else {

                // La solicitud no fue exitosa
                // Puedes manejar los diferentes códigos de estado HTTP aquí
            }
        } catch (IOException e) {
            // Ocurrió un error al hacer la solicitud
            e.printStackTrace();
        } catch (JSONException ex) {
            Logger.getLogger(asiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
