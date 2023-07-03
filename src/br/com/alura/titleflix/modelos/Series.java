package br.com.alura.titleflix.modelos;

import br.com.alura.titleflix.methods.errorverifyer.ErrorVerifyer;
import br.com.alura.titleflix.methods.stringconverter.NumberConverter;

public class Series extends Title {

    public Series(TituloOmdb titulo, RatingAndSeasons seasons, String requestTimeAndData){
        ErrorVerifyer verifyer = new ErrorVerifyer();
        NumberConverter numberConverter = new NumberConverter();
        this.title = verifyer.verifyError(titulo.title());
        this.yearInString = verifyer.verifyError(titulo.year());
        this.released = verifyer.verifyError(titulo.released());
        this.plot = verifyer.verifyError(titulo.plot());
        this.runtime = numberConverter.convertInInt(verifyer.verifyError(titulo.runtime().substring(0, 3).replace(" ", "")));
        this.genre = verifyer.verifyError(titulo.genre());
        this.imdbRating = numberConverter.convertInDouble(verifyer.verifyError(seasons.imdbRating()));
        this.totalSeasons = numberConverter.convertInInt(verifyer.verifyError(seasons.totalSeasons()));
        this.writer = verifyer.verifyError(titulo.writer());
        this.urlPoster = verifyer.verifyError(titulo.poster());
        this.requestTimeAndData = requestTimeAndData;
        //Pega as informações da api e adiciona em serie
    }
    private final String yearInString;
    private final String writer;
    private final int totalSeasons;

    @Override
    public void titleDescription () {
        System.out.println("\nA Serie escolhida é: " + title + "! Que têm um número de temporadas de: " + totalSeasons + "!");
        System.out.println("Ela foi lançada em: " + released);
        System.out.println("Sinopse da Série: " + plot);
        System.out.println("O escritor é: " + writer);
        System.out.println("O ano de lançamento é: " + yearInString);
        System.out.println("O tempo de duração de cada episódio é " + runtime);
        System.out.println("Sua nota segundo o IMDB é " + imdbRating);
        System.out.println("Data e hora da pesquisa: " + requestTimeAndData);
    }

    @Override
    public String toString() {
        return "Série: " + title + " (" + released + ")";
    }
    //Modifica o nome de referência da serie
}


