package br.com.streaming.modelo;

import java.util.ArrayList;

import br.com.streaming.servico.Reproduzivel;

public class Playlist implements Reproduzivel {

    protected String nome;
    protected String descricao;

    protected ArrayList<Musica> musicas;

    public Playlist(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;

        this.musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarMusica(Musica musica) {

        musicas.add(musica);
    }

    public void removerMusica(int indice) {

        if (indice >= 0 && indice < musicas.size()) {

            musicas.remove(indice);
        }
    }

    public void listarMusicas() {

        if (musicas.isEmpty()) {

            System.out.println("Playlist vazia.");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {

            System.out.print((i + 1) + ". ");

            musicas.get(i).exibir();
        }
    }

    @Override
    public int getDuracaoTotal() {

        int total = 0;

        for (Musica m : musicas) {

            total += m.getDuracaoTotal();
        }

        return total;
    }

    @Override
    public void reproduzir() {

        System.out.println(
            "🎵 Reproduzindo playlist: " + nome
        );

        for (Musica m : musicas) {

            System.out.println(
                "▶ " + m.getTitulo()
            );
        }
    }

    @Override
    public void pausar() {

        System.out.println("⏸ Playlist pausada");
    }

    @Override
    public void parar() {

        System.out.println("⏹ Playlist parada");
    }
}