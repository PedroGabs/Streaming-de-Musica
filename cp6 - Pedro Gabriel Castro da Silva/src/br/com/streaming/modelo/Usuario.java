package br.com.streaming.modelo;

import java.util.ArrayList;

import br.com.streaming.util.Validador;

public class Usuario {

    protected String nome;
    protected String email;

    protected ArrayList<Playlist> playlists;

    protected ArrayList<Musica> historicoReproducao;

    protected int totalReproducoes;

    public Usuario(
        String nome,
        String email
    ) {

        setNome(nome);

        validarEmail(email);

        this.email = email;

        playlists = new ArrayList<>();

        historicoReproducao =
            new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setNome(String nome) {

        if (
            nome == null ||
            nome.trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                "Nome inválido!"
            );
        }

        this.nome = nome.trim();
    }

    public final void validarEmail(
        String email
    ) {

        if (
            !Validador.emailValido(email)
        ) {

            throw new IllegalArgumentException(
                "Email inválido!"
            );
        }
    }

    public void reproduzirMusica(
        Musica musica
    ) {

        musica.reproduzir();

        historicoReproducao.add(musica);

        totalReproducoes++;
    }

    public void exibirHistorico() {

        System.out.println(
            "\n=== HISTÓRICO ==="
        );

        for (
            Musica m :
            historicoReproducao
        ) {

            m.exibir();
        }
    }

    public void criarPlaylist(
        String nome
    ) {

        playlists.add(

            new PlaylistPersonalizada(
                nome,
                "Criada pelo usuário"
            )
        );

        System.out.println(
            "✅ Playlist criada!"
        );
    }

    public void listarPlaylists() {

        if (playlists.isEmpty()) {

            System.out.println(
                "Nenhuma playlist."
            );

            return;
        }

        for (
            int i = 0;
            i < playlists.size();
            i++
        ) {

            Playlist p =
                playlists.get(i);

            System.out.println(
                (i + 1) +
                ". " +
                p.getNome()
            );

            if (
                p instanceof
                PlaylistAutomatica
            ) {

                System.out.println(
                    "   🤖 Automática"
                );
            }
        }
    }

    public Playlist getPlaylist(
        int indice
    ) {

        if (
            indice < 0 ||
            indice >= playlists.size()
        ) {

            return null;
        }

        return playlists.get(indice);
    }
}