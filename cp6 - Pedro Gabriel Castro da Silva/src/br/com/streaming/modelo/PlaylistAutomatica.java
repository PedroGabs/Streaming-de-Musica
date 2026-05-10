package br.com.streaming.modelo;

import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {

    private String criterio;

    public PlaylistAutomatica(
        String nome,
        String descricao,
        String criterio
    ) {

        super(nome, descricao);

        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {

        System.out.println(
            "🤖 Playlist automática"
        );

        System.out.println(
            "Critério: " + criterio
        );

        super.reproduzir();
    }

    public void atualizar(
        ArrayList<Musica> todasMusicas
    ) {

        musicas.clear();

        if (criterio.equalsIgnoreCase("top")) {

            for (
                int i = 0;
                i < todasMusicas.size() && i < 10;
                i++
            ) {

                musicas.add(
                    todasMusicas.get(i)
                );
            }

        } else if (
            criterio.equalsIgnoreCase("recentes")
        ) {

            musicas.addAll(todasMusicas);
        }
    }
}