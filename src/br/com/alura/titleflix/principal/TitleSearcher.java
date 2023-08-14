package br.com.alura.titleflix.principal;

import br.com.alura.titleflix.apisearch.ApiOmdb;
import br.com.alura.titleflix.methods.creater.CreateTitle;
import br.com.alura.titleflix.methods.creater.JsonCreater;
import br.com.alura.titleflix.modelos.RatingAndSeasons;
import br.com.alura.titleflix.modelos.Title;
import br.com.alura.titleflix.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitleSearcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = " ";
        List<Title> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Gson gsonIdentity = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("\nDigite uma série ou filme:");
            System.out.println("(Caso queira sair digite SAIR)");
            busca = scanner.nextLine();
            if (busca.equalsIgnoreCase("sair")){
                break;
            }
            ApiOmdb api = new ApiOmdb(busca);
            String json = api.getJson();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                RatingAndSeasons ratingAndSeasons = gsonIdentity.fromJson(json, RatingAndSeasons.class);
                CreateTitle creater = new CreateTitle(meuTituloOmdb, ratingAndSeasons);
                Title myTitle = creater.returnTitle();
                myTitle.titleDescription();
                titulos.add(myTitle);
            System.out.println(myTitle);
        }
        System.out.println(titulos);

        JsonCreater jsonCreater = new JsonCreater(gson, titulos);
        jsonCreater.createAJason();
        System.out.println("Programa finalizado!");
    }
}
