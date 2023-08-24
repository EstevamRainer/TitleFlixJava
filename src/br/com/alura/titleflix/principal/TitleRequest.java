package br.com.alura.titleflix.principal;

import br.com.alura.titleflix.searcher.TitleSearcher;

import java.io.IOException;

public class TitleRequest {
    public static void main(String[] args) throws IOException, InterruptedException {
        TitleSearcher titleSearcher = new TitleSearcher();
        titleSearcher.searchTitleWithQuestions();
        //Procura títulos durante a execução do programa
        TitleSearcher titleSearcher1 = new TitleSearcher();
        titleSearcher1.searchTitle("Avengers");
        //Procura o títuli predeterminado
    }
}
