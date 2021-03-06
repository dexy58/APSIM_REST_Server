package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.http.HttpRequest;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTClient {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/getPrediction");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\n" +
                    "    \"name\": \"corn\",\n" +
                    "    \"startDate\" : \"25-mar\",\n" +
                    "    \"endDate\" : \"8-apr\"\n" +
                    "}";

            JSONObject requestParams = new JSONObject();
            requestParams.put("name", "corn");
            requestParams.put("startDate", "25-mar");
            requestParams.put("endDate", "8-apr");

            OutputStream os = conn.getOutputStream();
            os.write(requestParams.toString().getBytes());
            os.flush();
            /*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }*/
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
