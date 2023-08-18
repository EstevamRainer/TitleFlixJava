package br.com.alura.titleflix.searcher;

import br.com.alura.titleflix.apisearch.ApiOmdb;
import br.com.alura.titleflix.methods.creater.CreateTitle;
import br.com.alura.titleflix.modelos.RatingAndSeasons;
import br.com.alura.titleflix.modelos.Title;
import br.com.alura.titleflix.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitleSearcher {
    public TitleSearcher () {}
    public TitleSearcher (String titleName){
        this.titleName = titleName;
    }
    private String titleName;
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

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            RatingAndSeasons ratingAndSeasons = gsonIdentity.fromJson(json, RatingAndSeasons.class);
            CreateTitle creater = new CreateTitle(meuTituloOmdb, ratingAndSeasons);
            Title myTitle = creater.returnTitle();
            myTitle.titleDescription();
            titulos.add(myTitle);
            System.out.println(myTitle);
            System.out.println(titulos);
            FileWriter writer = new FileWriter("C:/Users/estev/Documents/Projetos da Alura/Java/TitleFlix/TtileFlix/src/br/com/alura/titleflix/jsonexit/titulos.json");
            writer.write(gson.toJson(titulos));
            writer.close();
            System.out.println("Programa finalizado!");
        }
    }
    public void searchTitle() throws IOException, InterruptedException {
        String busca = titleName;
            ApiOmdb api = new ApiOmdb(busca);
            String json = api.getJson();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            RatingAndSeasons ratingAndSeasons = gsonIdentity.fromJson(json, RatingAndSeasons.class);
            CreateTitle creater = new CreateTitle(meuTituloOmdb, ratingAndSeasons);
            Title myTitle = creater.returnTitle();
            myTitle.titleDescription();
            System.out.println(myTitle);
            FileWriter writer = new FileWriter("C:/Users/estev/Documents/Projetos da Alura/Java/TitleFlix/TtileFlix/src/br/com/alura/titleflix/jsonexit/titulo.json");
            writer.write(gson.toJson(myTitle));
            writer.close();
        }
    }


