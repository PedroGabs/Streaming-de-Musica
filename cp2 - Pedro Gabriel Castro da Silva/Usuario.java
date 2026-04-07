import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Playlist> playlists;

    public Usuario() {
        this.playlists = new ArrayList<>();
    }

    public Usuario(String nome) {
        this();
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nome = nome.trim();
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist não pode ser null!");
        }
        playlists.add(playlist);
    }

    public void criarPlaylist(String nome) {
        adicionarPlaylist(new Playlist(nome));
    }

    public Playlist getPlaylist(int indice) {
        if (indice < 0 || indice >= playlists.size()) {
            return null;
        }
        return playlists.get(indice);
    }

    public void listarPlaylists() {
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i + 1) + ". " + playlists.get(i).getNome());
        }
    }
}