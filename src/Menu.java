import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private BibliotecaEncadeada biblioteca;
    private Usuario usuarioLogado;
    private List<Usuario> listaDeUsuarios;
    private RecomendacoesGrafos recomendacoesGrafos;
    private FilaUsuarios filaUsuarios;
    private LoginUsuario login;

    public Menu(BibliotecaEncadeada biblioteca, Usuario usuarioLogado, List<Usuario> listaDeUsuarios, RecomendacoesGrafos recomendacoesGrafos, FilaUsuarios filaUsuarios, LoginUsuario login) {
        this.biblioteca = biblioteca;
        this.usuarioLogado = usuarioLogado;
        this.listaDeUsuarios = listaDeUsuarios;
        this.recomendacoesGrafos = recomendacoesGrafos;
        this.filaUsuarios = filaUsuarios;
        this.login = login;
    }

    public boolean exibirMenuPrincipal() {

        int opcao = 0;
        while (true) {
            System.out.println("\n----Menu Principal----");
            System.out.println("1. Livros");
            System.out.println("2. Usuarios");
            System.out.println("3. Fila");
            System.out.println("4. Livros Recomendados");
            System.out.println("8 - Deslogar Usuario");
            System.out.println("9. Sair");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        menuLivro();
                        break;
                    case 2:
                        boolean desejaDeslogar = menuUsuario();
                        if (desejaDeslogar) {
                            return true;
                        }
                    case 3:
                        menuFila();
                        break;
                    case 4:
                        menuRecomencacoes();
                        break;
                    case 8:
                        System.out.println("Usuario deslogado!");
                        return true;
                    case 9:
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número");
                scanner.nextLine();
            }
        }

    }

    public boolean menuLivro() {
        int opcaoLivro = 0;
        while (true) {
            try {
                System.out.println("----Menu Livros----");
                System.out.println("1 - Adicionar Livro");
                System.out.println("2 - Remover Livro");
                System.out.println("3 - Listar Livros");
                System.out.println("4 - Vizualizar Livro");
                System.out.println("5 - Mostrar Historico");
                System.out.println("6 - Mostrar ultimo livro");
                System.out.println("7 - Remover ultimo livro do historico");
                System.out.println("9 - Encerrar o programa");
                System.out.println("10 - Voltar ao menu principal");
                opcaoLivro = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoLivro) {
                    case 1:
                        biblioteca.criarLivro(biblioteca);
                        break;
                    case 2:
                        System.out.println("Digite o nome do livro a ser removido: ");
                        String titulo = scanner.nextLine();
                        biblioteca.removerLivro(titulo);
                        break;
                    case 3:
                        biblioteca.mostrarLivros();
                        break;
                    case 4:
                        System.out.println("Digite o livro a ser vizualizado: ");
                        String tituloLivro = scanner.nextLine();

                        Livro livroEncontrado = biblioteca.buscarLivro(tituloLivro);
                        if (livroEncontrado != null) {
                            System.out.println("Livro encontrado!");
                            usuarioLogado.visualizarLivro(livroEncontrado);
                        } else {
                            System.out.println("Livro nao encontrado!");
                        }
                        break;
                    case 5:
                        if (usuarioLogado.getHistorico() != null) {
                            usuarioLogado.getHistorico().mostrarHistoricoDoUsuario(usuarioLogado);
                        } else {
                            System.out.println("⚠️ Histórico não encontrado para este usuário.");
                        }
                        break;
                    case 6:
                        usuarioLogado.getHistorico().mostrarUltimoLivroVisto(recomendacoesGrafos);
                        break;
                    case 7:
                        usuarioLogado.getHistorico().removerLivro();
                        break;
                    case 9:
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                        break;
                    case 10:
                        System.out.println("Voltando ao menu...");
                        return false;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número");
                scanner.nextLine();
            }
        }
    }

    public boolean menuUsuario() {
        int opcaoUsuario = 0;
        while (true) {
            try {
                System.out.println("----Menu Usuarios----");
                System.out.println("1 - Deslogar Usuario");
                System.out.println("2 - Listar Usuarios");
                System.out.println("10 - Voltar ao Menu Principal");

                opcaoUsuario = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoUsuario) {
                    case 1:
                        return true;
                    case 2:
                        LoginUsuario.mostrarUsuario(listaDeUsuarios);

                        for (Usuario u : listaDeUsuarios) {
                            System.out.println("Usuário: " + u.getUsuario());
                        }
                        break;
                    case 10:
                        System.out.println("Voltando ao menu principal...");
                        return false;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número");
                scanner.nextLine();
            }
        }
    }

    public boolean menuFila() {
        int opcaoFila = 0;
        while (true) {
            try {
                System.out.println("----Menu Fila----");
                System.out.println("1 - Adicionar usuario à fila");
                System.out.println("2 - Remover usuario da fila");
                System.out.println("3 - Mostrar todos usuarios da fila");
                System.out.println("4 - Mostrar próximo usuario da fila");
                opcaoFila = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoFila) {
                    case 1:
                        System.out.println("Digite o nome do usuario: ");
                        String usuarioParaAdicionar = scanner.nextLine();
                        Usuario usuarioEncontrado = login.autenticar(usuarioParaAdicionar);
                        if (usuarioEncontrado != null) {
                            filaUsuarios.adicionarUsuarioNaFila(usuarioEncontrado);
                            System.out.println("✅ Usuário adicionado na fila com sucesso!");
                            break;
                        } else {
                            System.out.println("❌ Usuário não encontrado");
                        }
                    case 2:
                        filaUsuarios.removerUsuario();
                        break;

                    case 3:
                        filaUsuarios.mostrarTodosUsuarios();
                        break;
                    case 4:
                        filaUsuarios.mostrarPrimeiroUsuarioDaLista();
                        break;

                }


            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número");
                scanner.nextLine();
            }
        }
    }


    public boolean menuRecomencacoes() {
        int opcaoRecomendacao = 0;
        while (true) {
            try {
                System.out.println("----Menu Recomendacoes----");
                System.out.println("1 - Mostrar RecomendacoesPorLivro");
                System.out.println("2 - Mostrar Todas Recomendacoes");
                System.out.println("3 - Criar Recomendacoes");
                System.out.println("10 - Voltar ao Menu Principal");
                System.out.println("Digite sua opção");
                opcaoRecomendacao = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoRecomendacao) {
                    case 1:
                        System.out.print("Digite o nome do livro para ver as recomendações: ");
                        String titulo = scanner.nextLine().toLowerCase().trim();
                        Livro livro = biblioteca.buscarLivro(titulo);
                        if (livro != null) {
                            recomendacoesGrafos.mostrarRecomendacoesPorLivro(livro);
                        } else {
                            System.out.println("❌ Livro não encontrado.");
                        }
                        break;
                    case 2:
                        recomendacoesGrafos.mostrarRecomendacoes();
                        break;
                    case 3:
                        recomendacoesGrafos.criarRecomendacoes(biblioteca);
                        break;
                    case 10:
                        System.out.println("Voltando ao menu principal...");
                        return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número");
                scanner.nextLine();
            }

        }
    }
}
