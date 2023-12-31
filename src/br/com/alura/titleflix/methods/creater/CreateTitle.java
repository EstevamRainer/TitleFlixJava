package br.com.alura.titleflix.methods.creater;

import br.com.alura.titleflix.methods.VerifyTitle;
import br.com.alura.titleflix.methods.creater.clock.ComputerClock;
import br.com.alura.titleflix.titlemodels.*;

public class CreateTitle {
    TitleOmdb title;
    RatingAndSeasons extraInfos;
    public CreateTitle(TitleOmdb title, RatingAndSeasons extraInfos){
        this.title = title;
        this.extraInfos = extraInfos;
    }

   public Title returnTitle() {
        //Esse método retorna uma Series se no JSON o parametro Type for = "series" e caso contrário ele será um filme
        VerifyTitle verifyer = new VerifyTitle(title);
       ComputerClock requestTime = new ComputerClock();
        if (verifyer.getTitleIs().equals("serie")) {
            return new Series(title, extraInfos, requestTime.returnDateAndTime());
        }
        if (verifyer.getTitleIs().equals("movie")){
            return new Movie(title, extraInfos, requestTime.returnDateAndTime());
        }
        return new TitleNotFound(requestTime.returnDateAndTime());
        //O title é o JSON do ombd transformado em objeto, já o extra infos são o totalSeasons e o imdbRating
    }
}
