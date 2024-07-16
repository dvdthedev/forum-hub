package dvd.com.forum_hub.domain.resposta;

import dvd.com.forum_hub.domain.autor.DadosAutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosNovaResposta (
        @NotBlank
        String mensagem,
        @NotNull
        Long autorId,
        @NotNull
        Long topicoId
) {

}
