package br.com.alura.titleflix.methods;

import br.com.alura.titleflix.modelos.TituloOmdb;

public class VerifyTitle {
    private final String titleIs;
    public VerifyTitle(TituloOmdb titulo) {
        if(titulo.type() == null) {
            this.titleIs = "notFound";
        } else if (titulo.type().equalsIgnoreCase("series")){
            this.titleIs = "serie";
        } else {
        this.titleIs = "movie";
        //O verify title como o próprio nome já diz, verifica se o titulo é Movie ou Series
        }
    }

    public String getTitleIs() {
        return titleIs;
    }
}
