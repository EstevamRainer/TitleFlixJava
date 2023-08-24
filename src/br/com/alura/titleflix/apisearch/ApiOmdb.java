package br.com.alura.titleflix.apisearch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiOmdb {
    private final String search;
    public ApiOmdb(String search) {
        this.search = search;
    }
    //busca recebe o titulo adicionado na classe da qual foi chamado

    public String getJson() throws IOException, InterruptedException{
        //aqui é criado a conexão com a api do omdb
        String url = "https://www.omdbapi.com/?apikey=fd5aeeca&t=" + search.replace(" ", "+");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
        //o response.body retorna o JSON com as informações da API
    }
}
