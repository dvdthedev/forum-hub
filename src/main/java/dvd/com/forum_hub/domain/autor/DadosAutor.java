package dvd.com.forum_hub.domain.autor;

public record DadosAutor(
        Long id,
        String nome) {

    public DadosAutor(Autor autor) {
        this(autor.getId(), autor.getNome());
    }

}
