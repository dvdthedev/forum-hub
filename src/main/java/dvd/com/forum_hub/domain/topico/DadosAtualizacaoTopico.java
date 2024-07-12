package dvd.com.forum_hub.domain.topico;

import java.time.LocalDateTime;

public record DadosAtualizacaoTopico (
        String titulo,
        String mensagem,
        Boolean duvidaResolvida
) {
}
