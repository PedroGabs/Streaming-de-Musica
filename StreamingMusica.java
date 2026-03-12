import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static ArrayList<String> titulos = new ArrayList<>();
    static ArrayList<String> artistas = new ArrayList<>();
    static ArrayList<Integer> duracoes = new ArrayList<>();
    static ArrayList<String> generos = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adicionar músicas de teste
        adicionarMusicasTeste();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n🎵 Até logo! 🎵");
        scanner.close();
    }

    public static void exibirMenu() {
        
        System.out.println("\n=== SISTEMA DE STREAMING ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar músicas");
        System.out.println("3. Buscar por título");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void processarOpcao(int opcao) {
        switch(opcao) {
            case 1:
                cadastrarMusica();
                break;
            
            case 2:
                listarMusicas();
                break;

            case 3:
                buscarPorTitulo();
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void cadastrarMusica() {
        System.out.println("\n--- CADASTRAR MÚSICA ---");
        System.out.println("Insira o título da música: ");

        String titulo;
        do {
            titulo = scanner.nextLine();

            if (titulo.trim().isEmpty()) {
            System.out.println("Título vazío!!!");
            } else if (titulo.length() > 50) {
                System.out.println("Máximo de 50 caracteres.");
            }

        } while (titulo.isEmpty() || titulo.length() > 50);

        System.out.println("Insira o nome do artista: ");

        String artista;
        do {
            artista = scanner.nextLine();

            if (artista.trim().isEmpty()) {
                System.out.println("Nome de artísta vazío!");
            } else if (artista.length() > 50) {
                System.out.println("Máximo de 50 caracteres.");
            }

        } while (artista.isEmpty() || artista.length() > 50);

        System.out.println("Insira o nome do gênero da música: ");

        String genero;
        do {
            genero = scanner.nextLine();

            if (genero.trim().isEmpty()) {
                System.out.println("Nome de gênero musical vazío!");
            } else if (genero.length() > 20) {
                System.out.println("Máximo de 20 caracteres.");
            }

        } while (genero.isEmpty() || genero.length() > 20);

        System.out.println("Insira a duração da música: ");

        int duracao;
        do { 
            duracao = Integer.parseInt(scanner.nextLine());

            if (duracao <= 0) {
                System.out.println("Tempo muito curto para uma música!");
            }
        } while (duracao <= 0);

        System.out.println("Música cadastrada com sucesso!");

        titulos.add(titulo);
        artistas.add(artista);
        duracoes.add(duracao);
        generos.add(genero);
    }

    public static void listarMusicas() {
        if (titulos.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
            }

        for (int i = 0; i < titulos.size(); i++) {
            System.out.println(
                (i + 1) + ". " +
                titulos.get(i) + " - " +
                artistas.get(i) + " (" +
                formatarDuracao(duracoes.get(i)) + ") [" +
                generos.get(i) + "]"
                );
            }
    }

    /**
     * ALUNO IMPLEMENTA: Busca por título
     * (Professor mostra a estrutura, alunos completam depois)
     */
    public static void buscarPorTitulo() {
        System.out.print("Digite o título: ");
        String busca = scanner.nextLine().toLowerCase();

        boolean encontrou = false;

        for (int i = 0; i < titulos.size(); i++) {

            if (titulos.get(i).toLowerCase().contains(busca)) {

                System.out.println(
                    titulos.get(i) + " - " +
                    artistas.get(i) + " (" +
                    formatarDuracao(duracoes.get(i)) + ") [" +
                    generos.get(i) + "]"
                );

                encontrou = true;
                }
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }

    /**
     * FORNECIDO: Formata duração
     */
    public static String formatarDuracao(int segundos) {
        int min = segundos / 60;
        int seg = segundos % 60;
        return String.format("%d:%02d", min, seg);
    }

    /**
     * FORNECIDO: Músicas de teste
     */
    public static void adicionarMusicasTeste() {
        titulos.add("Bohemian Rhapsody");
        artistas.add("Queen");
        duracoes.add(354);
        generos.add("Rock");

        titulos.add("Eu Sou 157");
        artistas.add("Racionais MC's");
        duracoes.add(529);
        generos.add("rap");
    }
}
