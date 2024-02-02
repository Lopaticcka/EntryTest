package com.api.entrytest.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

public class ApiCalls {

    private static final String BASE_URL = "https://gitlab.com/api/v4/";

    public String getProjects() throws Exception {
        String result;
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(BASE_URL + "projects")).GET().build();
            HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

            int statusCode = response.statusCode();
            System.out.println("HTTP status: " + statusCode);

            result = new BufferedReader(new InputStreamReader(response.body())).lines().collect(Collectors.joining("\n"));
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
}
