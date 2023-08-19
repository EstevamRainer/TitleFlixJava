package br.com.alura.titleflix.modelos;

import br.com.alura.titleflix.methods.errorverifyer.ErrorVerifyer;
import br.com.alura.titleflix.methods.stringconverter.NumberConverter;

public class Movie extends Title {
    public Movie(TituloOmdb titulo, RatingAndSeasons rating, String requestTimeAndData) {
        ErrorVerifyer verifyer = new ErrorVerifyer();
        NumberConverter numberConverter = new NumberConverter();
            this.title = verifyer.verifyError(titulo.title());
            this.year = numberConverter.convertInInt(verifyer.verifyError(titulo.year()));
            this.released = verifyer.verifyError(titulo.released());
            this.plot = verifyer.verifyError(titulo.plot());
            this.runtime = numberConverter.convertInInt(verifyer.verifyError(titulo.runtime().substring(0, 3).replace(" ", "")));
            this.genre = verifyer.verifyError(titulo.genre());
            this.imdbRating = numberConverter.convertInDouble(verifyer.verifyError(rating.imdbRating()));
            this.director = verifyer.verifyError(titulo.director());
            this.urlPoster = verifyer.verifyError(titulo.poster());
            this.requestTimeAndData = requestTimeAndData;
            //O construtor pega todos os dados da API e os adiciona aqui
    }
    int year;
    @Override
    public void titleDescription () {
        System.out.println("\nO filme escolhido é: " + title + "! Que foi feito sob supervisão do Diretor: " + director + ". A duração desse filme é de " + runtime + " minutos!");
        System.out.println("Ele foi lançado em: " + released);
        System.out.println("Sinopse do Filme: " + plot);
        System.out.println("O tempo de duração do filme é " + runtime);
        System.out.println("Sua nota segundo o IMDB é " + imdbRating);
        System.out.println("Data e hora da pesquisa: " + requestTimeAndData);
    }
    @Override
    public String toString() {
        return "Filme: " + this.title + " (" + this.released + ")";
        //Modifica o nome de referência do filme
    }
}
