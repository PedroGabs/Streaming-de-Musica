package model;

import java.util.ArrayList;

public class UsuarioPremium extends Usuario {

    private String plano;

    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String plano) {

        super(nome, email);

        this.plano = plano;

        musicasBaixadas = new ArrayList<>();
    }

    public String getPlano() {
        return plano;
    }

    public ArrayList<Musica> getMusicasBaixadas() {
        return musicasBaixadas;
    }

    @Override
    public void reproduzirMusica(Musica musica) {

        System.out.println(
            "🎵 Reproduzindo em ALTA QUALIDADE: "
            + musica.getTitulo()
        );

        historicoReproducao.add(musica);

        totalReproducoes++;
    }

    public void baixarMusica(Musica musica) {

        if (!musicasBaixadas.contains(musica)) {

            musicasBaixadas.add(musica);

            System.out.println(
                "⬇️ Música baixada: "
                + musica.getTitulo()
            );

        } else {

            System.out.println("Música já baixada.");
        }
    }

    public void listarMusicasBaixadas() {

        System.out.println("\n=== MÚSICAS BAIXADAS ===");

        if (musicasBaixadas.isEmpty()) {

            System.out.println("Nenhuma música baixada.");
            return;
        }

        for (Musica m : musicasBaixadas) {
            m.exibir();
        }
    }
}