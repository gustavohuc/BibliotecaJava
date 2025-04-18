import java.util.Stack;

public class StackHistorico extends Stack<Livro> {

    public void vizualizarLivro(Livro livro) {
        this.push(livro);
        System.out.println("📚 Livro visualizado: " + livro);
    }

    public void mostrarHistoricoDoUsuario(Usuario usuario) {
        if (usuario == null) {
            System.out.println("Nenhum usuario logado");
            return;
        }
        System.out.println("---- Historico do usuario: " + usuario.toString() + "-----");
        StackHistorico historico = usuario.getHistorico();
        if (historico == null) {
            System.out.println("Nenhum historico");
            return;
        } else {
            for (int i = historico.size() - 1; i > -1; i--) {
                System.out.println(historico.get(i));
            }
        }
    }

    public void mostrarUltimoLivroVisto(RecomendacoesGrafos recomendacoesGrafos) {
        Livro  ultimo = this.peek();
        System.out.println("Ultimo livro Visto: \n  📚 " + ultimo);
        recomendacoesGrafos.mostrarRecomendacoesPorLivro(ultimo);
    }

    public void removerLivro() {
        System.out.println("* Livro removido *: " + this.peek());
        this.pop();
    }
}

