public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private int numpagina;

    //Construtor
    public Livro(String titulo, String autor, String editora, int ano, int numpagina) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.numpagina = numpagina;
    }
    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public int getNumpagina() {
        return numpagina;
    }

    public String toStringCompleto() {
        return String.format("Livro: %s | Autor: %s | Editora: %s | Ano: %d | Páginas: %d",
                titulo, autor, editora, ano, numpagina);
    }
    @Override
    public String toString(){
        return titulo;
    }
}
