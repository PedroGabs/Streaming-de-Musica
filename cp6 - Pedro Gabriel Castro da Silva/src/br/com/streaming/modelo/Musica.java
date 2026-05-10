package br.com.streaming.modelo;

import br.com.streaming.util.FormatadorTempo;

public class Musica extends ItemReproducao {

    private String artista;
    private String genero;

    public Musica() {
        super("", 0);
    }

    public Musica(
        String titulo,
        String artista,
        int duracaoSegundos,
        String genero
    ) {

        super(titulo, duracaoSegundos);

        setArtista(artista);
        setGenero(genero);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {

        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("Artista inválido!");
        }

        this.artista = artista.trim();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {

        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Gênero inválido!");
        }

        this.genero = genero.trim();
    }

    @Override
    public void reproduzir() {

        System.out.println(
            "🎵 Tocando: " + titulo
        );
    }

    public void exibir() {

        System.out.println(
            titulo + " - " +
            artista + " (" +
            FormatadorTempo.formatar(duracaoSegundos) +
            ") [" + genero + "]"
        );
    }

    public boolean contemTitulo(String busca) {

        return titulo
            .toLowerCase()
            .contains(busca.toLowerCase());
    }
}