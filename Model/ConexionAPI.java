package Model;

import DATA.bienesData;
import DATA.asientoData;
import DATA.JsonData;
import static Model.URL_API_PIDE.URL_RENIEC_DNI;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConexionAPI {

    public reniec_dni consultarDNI(String dni) throws Exception {
        reniec_dni responseDNI = null;
        OkHttpClient client = new OkHttpClient();
        String url = URL_API_PIDE.URL_RENIEC_DNI(dni);  // Reemplaza con la URL de la API que deseas consultar

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

                if (JsonData.getDataFrom(responseDataJson, "consultarResponse/return/coResultado").equals("0000")) {//consulta correcta
                    responseDNI = new reniec_dni();
                    responseDNI.setDni(dni);
                    responseDNI.setNombres(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/prenombres"));
                    responseDNI.setApellidoPaterno(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/apPrimer"));
                    responseDNI.setApellidoMaterno(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/apSegundo"));
                    responseDNI.setDireccion(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/direccion"));
                    responseDNI.setUbigeo(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/ubigeo"));
                    responseDNI.setEstadoCivil(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/estadoCivil"));
                    responseDNI.setImgb64(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/foto"));
                    responseDNI.setRestriccion(JsonData.getDataFrom(responseDataJson, "consultarResponse/return/datosPersona/restriccion"));
                } else {
                    //error
                }
                // Haz algo con los datos de respuesta (responseData)
            } else {

                // La solicitud no fue exitosa
                // Puedes manejar los diferentes códigos de estado HTTP aquí
            }
        } catch (IOException e) {
            // Ocurrió un error al hacer la solicitud
            e.printStackTrace();
        }
        return responseDNI;
    }

    public bienesData consultarSUNARP_Natural(String tipoPart/* persona natural N*/, String app, String apm, String nombres) throws Exception {
        bienesData responseSUNARP = new bienesData();
        OkHttpClient client = new OkHttpClient();
        String url = URL_API_PIDE.URL_SUNARP_PN(tipoPart, app, apm, nombres);  // Reemplaza con la URL de la API que deseas consultar

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

                JSONArray arr = JsonData.getArrayFrom(responseDataJson, "buscarTitularidadSIRSARPResponse/respuestaTitularidad/respuestaTitularidad"); //consulta correcta
                for (int i = 0; i < arr.length(); i++) {
                    bienes b = new bienes();
                    b.setRegistro(JsonData.getDataFrom((JSONObject) arr.get(i), "registro"));
                    b.setLibro(JsonData.getDataFrom((JSONObject) arr.get(i), "libro"));
                    b.setApMaterno(JsonData.getDataFrom((JSONObject) arr.get(i), "apPaterno"));
                    b.setApMaterno(JsonData.getDataFrom((JSONObject) arr.get(i), "apMaterno"));
                    b.setNombre(JsonData.getDataFrom((JSONObject) arr.get(i), "nombre"));
                    b.setTipoDocumento(JsonData.getDataFrom((JSONObject) arr.get(i), "tipoDocumento"));
                    b.setNumeroDocumento(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroDocumento"));
                    b.setNumeroPartida(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroPartida"));
                    b.setNumeroPlaca(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroPlaca"));

                    b.setEstado(JsonData.getDataFrom((JSONObject) arr.get(i), "estado"));
                    b.setZona(JsonData.getDataFrom((JSONObject) arr.get(i), "zona"));
                    b.setOficina(JsonData.getDataFrom((JSONObject) arr.get(i), "oficina"));
                    b.setDireccion(JsonData.getDataFrom((JSONObject) arr.get(i), "direccion"));

                    b.setGroupby_Natural();
                    responseSUNARP.getListaBienes().add(b);
                }

                // Haz algo con los datos de respuesta (responseData)
            } else {

                // La solicitud no fue exitosa
                // Puedes manejar los diferentes códigos de estado HTTP aquí
            }
        } catch (IOException e) {
            // Ocurrió un error al hacer la solicitud
            e.printStackTrace();
        }
        return responseSUNARP;
    }

    public bienesData consultarSUNARP_Juridico(String tipoPart/* persona juridica j*/, String razon) throws Exception {
        bienesData responseSUNARP = new bienesData();
        OkHttpClient client = new OkHttpClient();
        String url = URL_API_PIDE.URL_SUNARP_PJ(tipoPart, razon);  // Reemplaza con la URL de la API que deseas consultar

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

                JSONArray arr = JsonData.getArrayFrom(responseDataJson, "buscarTitularidadSIRSARPResponse/respuestaTitularidad/respuestaTitularidad"); //consulta correcta
                for (int i = 0; i < arr.length(); i++) {
                    bienes b = new bienes();
                    b.setRegistro(JsonData.getDataFrom((JSONObject) arr.get(i), "registro"));
                    b.setLibro(JsonData.getDataFrom((JSONObject) arr.get(i), "libro"));
                    b.setTipoDocumento(JsonData.getDataFrom((JSONObject) arr.get(i), "tipoDocumento"));
                    b.setNumeroDocumento(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroDocumento"));
                    b.setNumeroPartida(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroPartida"));
                    b.setNumeroPlaca(JsonData.getDataFrom((JSONObject) arr.get(i), "numeroPlaca"));
                    b.setRazon(JsonData.getDataFrom((JSONObject) arr.get(i), "razonSocial"));
                    b.setEstado(JsonData.getDataFrom((JSONObject) arr.get(i), "estado"));
                    b.setZona(JsonData.getDataFrom((JSONObject) arr.get(i), "zona"));
                    b.setOficina(JsonData.getDataFrom((JSONObject) arr.get(i), "oficina"));
                    b.setDireccion(JsonData.getDataFrom((JSONObject) arr.get(i), "direccion"));

                    b.setGroupby_Juridica();
                    responseSUNARP.getListaBienes().add(b);
                }

                // Haz algo con los datos de respuesta (responseData)
            } else {

                // La solicitud no fue exitosa
                // Puedes manejar los diferentes códigos de estado HTTP aquí
            }
        } catch (IOException e) {
            // Ocurrió un error al hacer la solicitud
            e.printStackTrace();
        }
        return responseSUNARP;
    }
    //obtener el base64, parametro string asiento


    public asientoData consultarAsiento(String zona, String oficina, String registro, String nroPartida, HttpServletRequest requestMain,progresBar pb) throws Exception {

        asientoData responseSUNARP = new asientoData();
        OkHttpClient client = new OkHttpClient();
        String url = URL_API_PIDE.URL_SUNARP_ASIENTOS(zona, oficina, registro, nroPartida);  // Reemplaza con la URL de la API que deseas consultar

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
                JSONArray arr = JsonData.getArrayFrom(responseDataJson, "listarAsientosSIRSARPResponse/asientos/listAsientos"); //consulta correcta
                String transaccion = JsonData.getDataFrom(responseDataJson, "listarAsientosSIRSARPResponse/asientos/transaccion");
                String nroTotalPag = JsonData.getDataFrom(responseDataJson, "listarAsientosSIRSARPResponse/asientos/nroTotalPag");

                for (int i = 0; i < arr.length(); i++) {
                    try {

                        JSONArray arr2 = JsonData.getArrayFrom((JSONObject) arr.get(i), "listPag"); //consulta correcta
                        for (int j = 0; j < arr2.length(); j++) {
                            asiento a = new asiento();
                            a.setTransaccion(transaccion);
                            a.setNroTotalPag(nroTotalPag);
                            a.setIdlmgAsineto(JsonData.getDataFrom((JSONObject) arr.get(i), "idImgAsiento"));
                            a.setNumPag(JsonData.getDataFrom((JSONObject) arr.get(i), "numPag"));
                            a.setTipo(JsonData.getDataFrom((JSONObject) arr.get(i), "tipo"));
                            //////
                            a.setNroPagRef(JsonData.getDataFrom((JSONObject) arr2.get(j), "nroPagRef"));
                            a.setPagina(JsonData.getDataFrom((JSONObject) arr2.get(j), "nroPagRef"));
                            responseSUNARP.getAsientos().add(a);
                        }
                    } catch (Exception e) {

                        asiento a = new asiento();
                        String error = JsonData.getDataFrom((JSONObject) arr.get(i), "listPag");
                        if (error.equals("error")) {
                            int x = 1 / 0;
                        }
                        a.setTransaccion(transaccion);
                        a.setNroTotalPag(nroTotalPag);
                        a.setIdlmgAsineto(JsonData.getDataFrom((JSONObject) arr.get(i), "idImgAsiento"));
                        a.setNumPag(JsonData.getDataFrom((JSONObject) arr.get(i), "numPag"));
                        a.setTipo(JsonData.getDataFrom((JSONObject) arr.get(i), "tipo"));

                        a.setNroPagRef(JsonData.getDataFrom((JSONObject) arr.get(i), "listPag/nroPagRef"));
                        a.setPagina(JsonData.getDataFrom((JSONObject) arr.get(i), "listPag/pagina"));
                        
                        responseSUNARP.getAsientos().add(a);
                    }

                    HttpSession session = requestMain.getSession();
                     pb.setValue((1f/arr.length())*100f , 15);
                     System.out.println(pb.getValue_porcent());
                    session.setAttribute("parametro_value_bar", String.valueOf(pb.getValue_porcent()));
                }
                responseSUNARP.consultaImagenes(requestMain,pb);

                // Haz algo con los datos de respuesta (responseData)
            } else {
                // La solicitud no fue exitosa
                // Puedes manejar los diferentes códigos de estado HTTP aquí
            }
        } catch (IOException e) {
            // Ocurrió un error al hacer la solicitud
            e.printStackTrace();
        }
        return responseSUNARP;
    }

}
