import java.util.LinkedList;
import java.util.Queue;

public class FilaUsuarios {
    Queue<String> filaUsuarios = new LinkedList<>();

    public void adicionarUsuarioNaFila(Usuario usuario) {
        boolean add = filaUsuarios.add(usuario.getUsuario());
        if (add) {
            System.out.println("Usuário " + usuario.getUsuario() + " adicionado com sucesso");
        } else {
            System.out.println(usuario + " nao adicionado");
        }
    }

    public void mostrarTodosUsuarios() {
        if (filaUsuarios.isEmpty()) {
            System.out.println("A fila está vazia");
        }else {
            System.out.println("-------- Usuários: --------");
            for (String usuario : filaUsuarios) {
                System.out.println(usuario);
            }
            System.out.println("----------------");
        }
    }

    public void mostrarPrimeiroUsuarioDaLista() {
        String primeiroUsuario = filaUsuarios.peek();
        if (primeiroUsuario != null) {
            System.out.println("Primeiro usuario da fila: " + primeiroUsuario);

        } else {
            System.out.println("A fila está vazia");
        }
    }

    public void removerUsuario() {
        String usuarioRemovido = filaUsuarios.poll();
        if (usuarioRemovido == null) {
            System.out.println("Fila Vazia");
        } else {
            System.out.println(usuarioRemovido + " removido com sucesso");
        }
    }
}
