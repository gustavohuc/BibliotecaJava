import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecomendacoesGrafos {
    HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();
    //Cada Set<<Livro>> criado para conjunto de recomendacoes de cada livro

    public HashMap<Livro, Set<Livro>> getRecomendacoes() {
        return recomendacoes;
    }
    public void adiconarRecomendacoes(Livro livroBase, Set<Livro> recomendados) {
        if (recomendados == null) {
            recomendados = new HashSet<>();
        }
        recomendacoes.put(livroBase, recomendados);
    }

    public void criarRecomendacoes(BibliotecaEncadeada bibliotecaEncadeada) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do livro base: ");
        String nomeBase = scanner.nextLine().toLowerCase().trim();
        Livro livroBase = bibliotecaEncadeada.buscarLivro(nomeBase);

        if (livroBase == null) {
            System.out.println("❌ Livro base não encontrado!");
            return;
        }
        Set<Livro> recomendados = new HashSet<>();
        String continuar;

        do {
            System.out.print("Digite o nome do livro: ");
            String nomeRecomendado = scanner.nextLine().toLowerCase().trim();
            Livro livroRecomendado = bibliotecaEncadeada.buscarLivro(nomeRecomendado);
            if (livroRecomendado != null) {
                recomendados.add(livroRecomendado);
                System.out.println("✅ Livro recomendado adicionado.");
            } else {
                System.out.println("⚠️ Livro recomendado não encontrado.");
            }
            System.out.print("Deseja adicionar outro? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        recomendacoes.put(livroBase, recomendados);
        System.out.println("🎉 Recomendações adicionadas com sucesso!");
    }

    public void mostrarRecomendacoes() {
        System.out.println("-------- Lista de Recomendações --------");
        for (Livro lbase : recomendacoes.keySet()) {
            Set<Livro> recomendados = recomendacoes.get(lbase);
            if (recomendados == null || recomendados.isEmpty()) {
                System.out.println("📚 Nenhuma recomendação para este livro.");
            } else {
                System.out.println("📚 Recomendações para '" + lbase.getTitulo() + "':");
                for (Livro l : recomendados) {
                    System.out.println("- " + l.getTitulo());
                }
            }
        }
        System.out.println("------------");
    }

    public void mostrarRecomendacoesPorLivro(Livro lBase) {
        System.out.println("-------- Lista de Recomendações --------");
        Set<Livro> recomendados = recomendacoes.get(lBase);

        if (recomendados == null || recomendados.isEmpty()) {
            System.out.println("📚 Nenhuma recomendação para este livro.");
        } else {
            System.out.println("📚 Recomendações para '" + lBase.getTitulo() + "':");
            for (Livro l : recomendados) {
                System.out.println("- " + l.getTitulo());
            }
        }

        System.out.println("------------");
    }
}



