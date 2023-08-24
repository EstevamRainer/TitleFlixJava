package br.com.alura.titleflix.titlemodels;

public class TitleNotFound extends Title {
    public TitleNotFound(String requestDateAndTime){
        this.title = "Not Found";
        this.requestTimeAndData = requestDateAndTime;
    }
    @Override
    public void titleDescription() {
        System.out.println("Titulo não Encontrado");
    }

    @Override
    public String toString() {
        return "Not Found";
    }
}
