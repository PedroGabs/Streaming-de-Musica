package br.com.streaming.modelo;

import java.util.ArrayList;

import br.com.streaming.servico.Baixavel;

public class UsuarioPremium
extends Usuario
implements Baixavel {

    private String plano;

    private ArrayList<Musica>
        musicasBaixadas;

    public UsuarioPremium(
        String nome,
        String email,
        String plano
    ) {

        super(nome, email);

        this.plano = plano;

        musicasBaixadas =
            new ArrayList<>();
    }

    public String getPlano() {

        return plano;
    }

    public ArrayList<Musica>
    getMusicasBaixadas() {

        return musicasBaixadas;
    }

    @Override
    public void reproduzirMusica(
        Musica musica
    ) {

        System.out.println(

            "🎵 Reproduzindo em ALTA QUALIDADE: "
            + musica.getTitulo()
        );

        historicoReproducao
            .add(musica);

        totalReproducoes++;
    }

    @Override
    public void baixar(
        Musica musica
    ) {

        if (
            !musicasBaixadas
            .contains(musica)
        ) {

            musicasBaixadas
                .add(musica);

            System.out.println(

                "⬇️ Música baixada: "
                + musica.getTitulo()
            );

        } else {

            System.out.println(
                "Música já baixada."
            );
        }
    }

    @Override
    public void removerDownload(
        Musica musica
    ) {

        musicasBaixadas.remove(musica);
    }

    @Override
    public boolean estaBaixada(
        Musica musica
    ) {

        return musicasBaixadas
            .contains(musica);
    }

    @Override
    public int getTamanhoBaixados() {

        return musicasBaixadas.size();
    }

    public void listarMusicasBaixadas() {

        System.out.println(

            "\n=== MÚSICAS BAIXADAS ==="
        );

        if (
            musicasBaixadas.isEmpty()
        ) {

            System.out.println(
                "Nenhuma música baixada."
            );

            return;
        }

        for (
            Musica m :
            musicasBaixadas
        ) {

            m.exibir();
        }
    }
}