package br.com.alura.titleflix.modelos;


public record TituloOmdb(String title, String year, String runtime, String type,
                         String released, String genre, String director, String plot,
                         String poster, String writer, String response) {
}