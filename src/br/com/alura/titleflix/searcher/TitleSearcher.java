package br.com.alura.titleflix.searcher;

import br.com.alura.titleflix.apisearch.ApiOmdb;
import br.com.alura.titleflix.methods.creater.CreateTitle;
import br.com.alura.titleflix.titlemodels.RatingAndSeasons;
import br.com.alura.titleflix.titlemodels.Title;
import br.com.alura.titleflix.titlemodels.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitleSearcher {
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    private final Gson gsonIdentity = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .create();

    public void searchTitleWithQuestions() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Title> titulos = new ArrayList<>();
        String busca = " ";
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("\nDigite uma série ou filme:");
            System.out.println("(Caso queira sair digite SAIR)");
            busca = scanner.nextLine();
            if (busca.equalsIgnoreCase("sair")){
                break;
            }
            ApiOmdb api = new ApiOmdb(busca);
            String json = api.getJson();

            TitleOmdb meuTituloOmdb = gson.fromJson(json, TitleOmdb.class);
            RatingAndSeasons ratingAndSeasons = gsonIdentity.fromJson(json, RatingAndSeasons.class);
            CreateTitle creater = new CreateTitle(meuTituloOmdb, ratingAndSeasons);
            Title myTitle = creater.returnTitle();
            myTitle.titleDescription();
            titulos.add(myTitle);
            System.out.println(myTitle);
            System.out.println(titulos);
            FileWriter writer = new FileWriter("src/br/com/alura/titleflix/jsonexit/titulos.json");
            writer.write(gson.toJson(titulos));
            writer.close();
            System.out.println("Programa finalizado!");
        }
        //Método para ser utilizado para fazer as perguntas quanto ao filme que quiser
    }
    public void searchTitle(String titleName) throws IOException, InterruptedException {
        String busca = titleName;
            ApiOmdb api = new ApiOmdb(busca);
            String json = api.getJson();
            TitleOmdb meuTituloOmdb = gson.fromJson(json, TitleOmdb.class);
            RatingAndSeasons ratingAndSeasons = gsonIdentity.fromJson(json, RatingAndSeasons.class);
            CreateTitle creater = new CreateTitle(meuTituloOmdb, ratingAndSeasons);
            Title myTitle = creater.returnTitle();
            myTitle.titleDescription();
            System.out.println(myTitle);
            FileWriter writer = new FileWriter("src/br/com/alura/titleflix/jsonexit/titulo.json");
            writer.write(gson.toJson(myTitle));
            writer.close();
        }
        //Método que precisa de parâmetros pré adicionados para funcionar
    }
