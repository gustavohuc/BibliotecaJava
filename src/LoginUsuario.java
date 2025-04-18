import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginUsuario {
    List<Usuario> listaDeUsuarios = new ArrayList<>();
    private String usuario;
    private Usuario usuarioLogado;

    public LoginUsuario() {
    }

    public void criarUsuario(String usuario) {
        StackHistorico historico = new StackHistorico();
        Usuario novoUsuario = new Usuario(usuario);
        listaDeUsuarios.add(novoUsuario);
        System.out.println("Usuario criado com sucesso");
    }

    public boolean menuLogin() {
        Scanner sc = new Scanner(System.in);
        int opcaologin = 0;

        while (true) {
            System.out.println("1- Login");
            System.out.println("2- Cadastrar Novo Usuario");
            System.out.println("5- Sair");
            System.out.println("Digite a opção desejada: ");
            try {
                opcaologin = sc.nextInt();
                sc.nextLine();
                switch (opcaologin) {
                    case 1:
                        System.out.println("Digite o nome do usuario: ");
                        String usuarioInput = sc.nextLine();
                        Usuario autenticado = autenticar(usuarioInput);
                        if (autenticado != null) {
                            System.out.println("✅ Login efetuado com sucesso!");
                            usuarioLogado = autenticado;
                            return true;
                        } else {
                            System.out.println("❌ Usuario inválido!");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o nome do novo usuario: ");
                        String novoUsuario = sc.nextLine();
                        criarUsuario(novoUsuario);
                        break;
                    case 5:
                        System.out.println("Saindo do Sistema");
                        return false;
                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public void logout() {
        if (usuarioLogado != null) {
            System.out.println("👋 Deslogando usuário: " + usuarioLogado.getUsuario());
            usuarioLogado = null;
        } else {
            System.out.println("⚠️ Nenhum usuário está logado.");
        }
    }

    public Usuario autenticar(String usuarioInput) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.autenticar(usuarioInput)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public static void mostrarUsuario(List <Usuario>listaDeUsuarios){
        for (Usuario u : listaDeUsuarios) {
            System.out.println("Usuário: " + u.getUsuario());
        }
        System.out.println("Total de usuários: " + listaDeUsuarios.size());
    }
}
