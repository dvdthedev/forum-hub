package dvd.com.forum_hub.domain.topico;

import dvd.com.forum_hub.domain.autor.Autor;
import jakarta.validation.constraints.NotNull;

public record DadosCriacaoTopico(
    @NotNull
        String titulo,
    @NotNull
        String mensagem,
    @NotNull
        Long idAutor,
    @NotNull
        Curso curso
) {
}
