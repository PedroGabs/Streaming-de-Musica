package br.com.streaming.modelo;

public class PlaylistPersonalizada extends Playlist {

    public PlaylistPersonalizada(
        String nome,
        String descricao
    ) {

        super(nome, descricao);
    }

    @Override
    public void reproduzir() {

        System.out.println(
            "🎧 Playlist personalizada"
        );

        super.reproduzir();
    }
}