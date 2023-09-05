package br.com.alura.titleflix.titlemodels;

public abstract class Title implements Comparable<Title> {
    protected String title;
    protected String released;
    protected String plot;
    protected int runtime;
    protected double imdbRating;
    protected String genre;
    protected String director;
    protected String urlPoster;
    protected String requestTimeAndData;


    public abstract void titleDescription();
    @Override
    public int compareTo(Title outroTitle) {
        return this.title.compareTo(outroTitle.title);
    }

    @Override
    public String toString() {
        return "(Nome: " + title + " (" + released + ")" + ", Duração = )";
    }
}
