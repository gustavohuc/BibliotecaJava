public class Usuario {
    private String usuario;
    private StackHistorico historico;

    public String getUsuario() {
        return this.usuario;
    }

    public Usuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome de usuário não pode ser vazio");
        }
        this.usuario = usuario;
        this.historico = new StackHistorico();

    }

    public boolean autenticar(String usuario){
        return this.usuario.equals(usuario); //verifica se os dados coincidem
    }

    public StackHistorico getHistorico(){
        return historico;
    }

    public void visualizarLivro(Livro titulo){
        historico.vizualizarLivro(titulo);
    }
    public String toString(){
        return getUsuario();
    }
}