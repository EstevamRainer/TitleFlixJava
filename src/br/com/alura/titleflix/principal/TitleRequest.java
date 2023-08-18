package br.com.alura.titleflix.principal;

import br.com.alura.titleflix.searcher.TitleSearcher;

import java.io.IOException;

public class TitleRequest {
    public static void main(String[] args) throws IOException, InterruptedException {
        TitleSearcher titleSearcher = new TitleSearcher();
        titleSearcher.searchTitleWithQuestions();
        TitleSearcher titleSearcher1 = new TitleSearcher("Avengers");
        titleSearcher1.searchTitle();
    }
}
