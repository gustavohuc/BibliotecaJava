import java.util.LinkedList;
import java.util.Scanner;

public class BibliotecaEncadeada {
    private LinkedList<Livro> livros = new LinkedList<Livro>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("📚 Livro adicionado com sucesso!");
    }

    public void criarLivro(BibliotecaEncadeada biblioteca) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o título do livro:");
        String titulo = sc.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = sc.nextLine();
        System.out.println("Digite a editora do livro:");
        String editora = sc.nextLine();
        System.out.println("Digite o ano de publicação:");
        int ano = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o número de páginas:");
        int numpagina = Integer.parseInt(sc.nextLine());
        Livro novoLivro = new Livro(titulo, autor, editora, ano, numpagina);
        biblioteca.adicionarLivro(novoLivro);
        System.out.println("📚 Livro adicionado com sucesso!");
    }

    public void removerLivro(String titulo) {
        if (!livros.isEmpty()) {
            boolean removido = livros.removeIf(livro -> titulo.equalsIgnoreCase(livro.getTitulo()));
            if (removido) {
                System.out.println("Livro removido com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com o título informado.");
            }
        } else {
            System.out.println("A lista esta vazia!");
        }
    }

    public void mostrarLivros() {
        System.out.println("--------");
        System.out.println("Lista de Livros\n");
        System.out.println();
        for (Livro livro : livros) {
            System.out.println(livro.toStringCompleto());
        }
        System.out.println("--------");
    }

    public Livro buscarLivro(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Escolha um livro Válido!");
        }
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
