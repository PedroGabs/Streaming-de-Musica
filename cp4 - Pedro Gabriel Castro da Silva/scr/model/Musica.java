package model;

public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    // Construtor padrão
    public Musica() {}

    // Construtor completo
    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    // GETTERS E SETTERS COM VALIDAÇÃO

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título inválido!");
        }
        this.titulo = titulo.trim();
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

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0 || duracaoSegundos >= 3600) {
            throw new IllegalArgumentException("Duração inválida!");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null) {
            throw new IllegalArgumentException("Gênero inválido!");
        }

        String g = genero.trim().toLowerCase();

        switch (g) {
            case "pop":
            case "rock":
            case "jazz":
            case "eletrônica":
            case "trap":
            case "rap":
            case "hip-hop":
            case "clássica":
                this.genero = g.substring(0,1).toUpperCase() + g.substring(1);
                break;
            default:
                throw new IllegalArgumentException("Gênero inválido!");
        }
    }

    public void exibir() {
        System.out.println(titulo + " - " + artista + " (" + getDuracaoFormatada() + ") [" + genero + "]");
    }

    public String getDuracaoFormatada() {
        int min = duracaoSegundos / 60;
        int seg = duracaoSegundos % 60;
        return String.format("%d:%02d", min, seg);
    }

    public boolean contemTitulo(String busca) {
        return titulo.toLowerCase().contains(busca.toLowerCase());
    }
}