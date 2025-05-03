package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class Request {

    HttpClient client = HttpClient.newHttpClient();

    public String getConsulta (String consulta, String conversion) throws IOException, InterruptedException{
        String direccion = "https://v6.exchangerate-api.com/v6/e4b9ed623c791e966394c008/latest/" + consulta;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        JsonElement rate = conversionRates.get(conversion);
        return rate.getAsString();
    }


}
