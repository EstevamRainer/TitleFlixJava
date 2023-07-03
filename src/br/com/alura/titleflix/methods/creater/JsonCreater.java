package br.com.alura.titleflix.methods.creater;

import br.com.alura.titleflix.modelos.Title;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonCreater {
    public JsonCreater(Gson gson, List<Title> titulos){
        this.gson = gson;
        this.titulos = titulos;
    }
    private final Gson gson;
    private final List<Title> titulos;
    public void createAJason() throws IOException {
        FileWriter writer = new FileWriter("titulos.json");
        writer.write(gson.toJson(titulos));
        writer.close();
    }
}
