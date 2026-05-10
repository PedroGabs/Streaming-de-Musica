package br.com.streaming.servico;

import java.util.ArrayList;

import br.com.streaming.modelo.Musica;

public class GeradorRecomendacoes {

    public static ArrayList<Musica>
    recomendar(
        ArrayList<Musica> musicas
    ) {

        ArrayList<Musica>
            recomendadas =
            new ArrayList<>();

        for (
            int i = 0;
            i < musicas.size() && i < 3;
            i++
        ) {

            recomendadas.add(
                musicas.get(i)
            );
        }

        return recomendadas;
    }
}