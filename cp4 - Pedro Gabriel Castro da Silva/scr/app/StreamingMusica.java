package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class StreamingMusica {

    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuario;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        adicionarMusicasTeste();
        criarConta();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n🎵 Até logo! 🎵");
        scanner.close();
    }

    public static void criarConta() {
        System.out.println("=== BEM-VINDO AO STREAMING ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("\nTipo de conta:");
        System.out.println("1. Free");
        System.out.println("2. Premium");
        System.out.print("Escolha: ");

        int tipo = lerOpcao();

        if (tipo == 2) {
            System.out.println("\nPlano:");
            System.out.println("1. Mensal");
            System.out.println("2. Anual");
            System.out.println("3. Familiar");
            System.out.print("Escolha: ");

            int plano = lerOpcao();
            String tipoPlano = switch (plano) {
                case 1 -> "Mensal";
                case 2 -> "Anual";
                case 3 -> "Familiar";
                default -> "Mensal";
            };

            usuario = new UsuarioPremium(nome, email, tipoPlano);
            System.out.println("✅ Conta Premium criada!");

        } else {
            usuario = new UsuarioFree(nome, email);
            System.out.println("✅ Conta Free criada!");
        }
    }

    public static void exibirMenu() {
        System.out.println("\n=== MENU ===");

        if (usuario instanceof UsuarioPremium) {
            System.out.println("1. Reproduzir música");
            System.out.println("2. Ver histórico");
            System.out.println("3. Criar playlist");
            System.out.println("4. Baixar música");
            System.out.println("5. Ver músicas baixadas");
            System.out.println("6. Gerenciar playlists");
        } else {
            System.out.println("1. Reproduzir música");
            System.out.println("2. Ver histórico");
            System.out.println("3. Criar playlist (máx. 3)");
            System.out.println("4. 💎 Fazer upgrade");
            System.out.println("5. Gerenciar playlists");
        }

        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void processarOpcao(int opcao) {

        if (usuario instanceof UsuarioPremium premium) {

            switch (opcao) {
                case 1 -> reproduzirMusica();
                case 2 -> usuario.exibirHistorico();
                case 3 -> criarPlaylist();
                case 4 -> baixarMusica(premium);
                case 5 -> premium.listarMusicasBaixadas();
                case 6 -> gerenciarPlaylists();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } else if (usuario instanceof UsuarioFree) {

            switch (opcao) {
                case 1 -> reproduzirMusica();
                case 2 -> usuario.exibirHistorico();
                case 3 -> criarPlaylist();
                case 4 -> fazerUpgrade();
                case 5 -> gerenciarPlaylists();
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public static void reproduzirMusica() {
        listarMusicas();
        System.out.print("Escolha: ");
        int i = lerOpcao() - 1;

        if (i >= 0 && i < musicas.size()) {
            usuario.reproduzirMusica(musicas.get(i));
        }
    }

    public static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        usuario.criarPlaylist(nome);
    }

    public static void baixarMusica(UsuarioPremium premium) {
        listarMusicas();
        System.out.print("Escolha: ");
        int i = lerOpcao() - 1;

        if (i >= 0 && i < musicas.size()) {
            premium.baixarMusica(musicas.get(i));
        }
    }

    public static void fazerUpgrade() {
        System.out.println("\nEscolha o plano:");
        System.out.println("1. Mensal");
        System.out.println("2. Anual");
        System.out.println("3. Familiar");

        int plano = lerOpcao();

        String tipoPlano = switch (plano) {
            case 1 -> "Mensal";
            case 2 -> "Anual";
            case 3 -> "Familiar";
            default -> "Mensal";
        };

        usuario = new UsuarioPremium(usuario.getNome(), usuario.getEmail(), tipoPlano);
        System.out.println("💎 Upgrade realizado!");
    }

    public static void listarMusicas() {
        for (int i = 0; i < musicas.size(); i++) {
            System.out.print((i + 1) + ". ");
            musicas.get(i).exibir();
        }
    }

    public static void gerenciarPlaylists() {
    int opcao;

    do {
        System.out.println("\n=== PLAYLISTS ===");
        System.out.println("1. Listar playlists");
        System.out.println("2. Adicionar música");
        System.out.println("3. Remover música");
        System.out.println("4. Ver detalhes");
        System.out.println("0. Voltar");
        System.out.print("Escolha: ");

        opcao = lerOpcao();

            switch(opcao) {
                case 1 -> usuario.listarPlaylists();
                case 2 -> adicionarMusicaNaPlaylist();
                case 3 -> removerMusicaDaPlaylist();
                case 4 -> verDetalhesPlaylist();
            }

        } while (opcao != 0);
    }

    public static void adicionarMusicaNaPlaylist() {
        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = lerOpcao() - 1;

        Playlist p = usuario.getPlaylist(pIndex);
        if (p == null) return;

        listarMusicas();
        System.out.print("Escolha a música: ");
        int mIndex = lerOpcao() - 1;

        if (mIndex >= 0 && mIndex < musicas.size()) {
            p.adicionarMusica(musicas.get(mIndex));
            System.out.println("Música adicionada!");
        }
    }

    public static void removerMusicaDaPlaylist() {
        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int pIndex = lerOpcao() - 1;

        Playlist p = usuario.getPlaylist(pIndex);
        if (p == null) return;

        p.listarMusicas();
        System.out.print("Escolha a música: ");
        int mIndex = lerOpcao() - 1;

        p.removerMusica(mIndex);
    }

    public static void verDetalhesPlaylist() {
        usuario.listarPlaylists();
        System.out.print("Escolha a playlist: ");
        int index = lerOpcao() - 1;

        Playlist p = usuario.getPlaylist(index);
        if (p == null) return;

        System.out.println("\nPlaylist: " + p.getNome());
        p.listarMusicas();

        int total = p.getDuracaoTotal();
        System.out.println("Duração total: " + (total / 60) + " min");
    }

    

    public static void adicionarMusicasTeste() {
        musicas.add(new Musica("Did it first", "Ice Spice", 118, "Trap"));
        musicas.add(new Musica("Eu Sou 157", "Racionais MC's", 529, "Rap"));
    }
}