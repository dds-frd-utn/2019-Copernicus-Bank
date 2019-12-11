/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Evelyn
 */
public class restBC {
    
    public static String makeGetRequest(String restURL){
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL( restURL );
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(
            new InputStreamReader(inputStream, "utf-8"),
        8);
            StringBuilder sBuilder = new StringBuilder();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
            inputStream.close();
            result = sBuilder.toString();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
           if (urlConnection != null) {
           urlConnection.disconnect();
        }
        }
        return result;
    }

   public String enviarHttpRequest(String urlParam, String method, JSONObject jsonParam){
        try {
            URL url = new URL(urlParam);

            HttpURLConnection urlConnection = null;
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("method");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            if(jsonParam.length() > 0){
                urlConnection.setFixedLengthStreamingMode(jsonParam.toString().getBytes().length);
            }
            urlConnection.setRequestProperty(
                                   "Content-Type", "application/json;charset=utf-8");
            urlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            urlConnection.connect();
            if(jsonParam.length() >0){
                OutputStream os;
                os = new BufferedOutputStream(urlConnection.getOutputStream());
                os.write(jsonParam.toString().getBytes());
                os.flush();
            }
            StringBuilder sBuilder;
            InputStream inputStream;
            inputStream= urlConnection.getInputStream();
            
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 5);
            sBuilder = new StringBuilder();
            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
            String texto = sBuilder.toString();
            return texto;
        } catch (IOException e) {
           return e.getMessage();
        }
    }
}
