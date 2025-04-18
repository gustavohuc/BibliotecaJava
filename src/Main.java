import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Iniciando
        BibliotecaEncadeada biblioteca = new BibliotecaEncadeada();
        LoginUsuario login = new LoginUsuario();
        RecomendacoesGrafos recomendacoesGrafos = new RecomendacoesGrafos();
        FilaUsuarios filaUsuarios = new FilaUsuarios();

        //Lista de usuarios
        login.criarUsuario("user");

        //Criando os livros
        Livro livro1 = new Livro("It: A Coisa", "Stephen King", "Suma", 1986, 1104);
        Livro livro2 = new Livro("Drácula", "Bram Stoker", "Zahar", 1897, 416);
        Livro livro3 = new Livro("Frankenstein", "Mary Shelley", "Penguin Companhia", 1818, 288);
        Livro livro4 = new Livro("Orgulho e Preconceito", "Jane Austen", "Publicações Europa-América", 1813, 432);
        Livro livro5 = new Livro("Como Eu Era Antes de Você", "Jojo Moyes", "Intrínseca", 2012, 320);
        Livro livro6 = new Livro("O Morro dos Ventos Uivantes", "Emily Brontë", "L&PM", 1847, 376);
        Livro livro7 = new Livro("Duna", "Frank Herbert", "Aleph", 1965, 680);
        Livro livro8 = new Livro("Neuromancer", "William Gibson", "Aleph", 1984, 320);
        Livro livro9 = new Livro("Fundação", "Isaac Asimov", "Aleph", 1951, 368);
        Livro livro10 = new Livro("O Silêncio dos Inocentes", "Thomas Harris", "Record", 1988, 364);
        Livro livro11 = new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", "HarperCollins", 1934, 296);
        Livro livro12 = new Livro("O Colecionador de Ossos", "Jeffery Deaver", "BestBolso", 1997, 448);
        Livro[] livros = {livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9, livro10, livro11, livro12
        };   //Adicionando os livros numa lista

        for (Livro livro : livros) { //Adicionando os livros na biblioteca através de um loop
            biblioteca.adicionarLivro(livro);
        }
        //Adicionando as recomendações de forma mais legível com o "Set.of"
        recomendacoesGrafos.adiconarRecomendacoes(livro1, Set.of(livro2,livro3));
        recomendacoesGrafos.adiconarRecomendacoes(livro2, Set.of(livro1,livro3));
        recomendacoesGrafos.adiconarRecomendacoes(livro3, Set.of(livro1,livro2));
        recomendacoesGrafos.adiconarRecomendacoes(livro4, Set.of(livro5,livro6));
        recomendacoesGrafos.adiconarRecomendacoes(livro5, Set.of(livro4,livro6));
        recomendacoesGrafos.adiconarRecomendacoes(livro6, Set.of(livro4,livro5));
        recomendacoesGrafos.adiconarRecomendacoes(livro7, Set.of(livro8,livro9));
        recomendacoesGrafos.adiconarRecomendacoes(livro8, Set.of(livro7,livro9));
        recomendacoesGrafos.adiconarRecomendacoes(livro9, Set.of(livro7,livro8));
        recomendacoesGrafos.adiconarRecomendacoes(livro10, Set.of(livro11,livro12));
        recomendacoesGrafos.adiconarRecomendacoes(livro11, Set.of(livro10,livro12));
        recomendacoesGrafos.adiconarRecomendacoes(livro12, Set.of(livro10,livro11));

        while (true){ //se o login for correto inicia o menu
            boolean loginFeito = login.menuLogin();
            if (loginFeito){
                Usuario usuarioLogado = login.getUsuarioLogado();
                Menu menu = new Menu(biblioteca,usuarioLogado,login.getListaDeUsuarios(),recomendacoesGrafos,filaUsuarios,login);
                boolean desejaDeslogar = menu.exibirMenuPrincipal();
                if (desejaDeslogar){
                    login.logout();
                    continue;
                }
            }else{
                System.out.println("⚠\uFE0F Login não realizado. Encerrando o programa.");
            }
        }
    }
}
