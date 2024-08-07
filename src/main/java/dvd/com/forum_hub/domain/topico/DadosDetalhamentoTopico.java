package dvd.com.forum_hub.domain.topico;

import dvd.com.forum_hub.domain.autor.Autor;
import dvd.com.forum_hub.domain.autor.DadosAutor;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico (
        Long id,

        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean duvidaResolvida,
        DadosAutor autor,
        Curso curso
) {
 public DadosDetalhamentoTopico(Topico topico){
     this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getDuvidaResolvida(), new DadosAutor(topico.getAutor()), topico.getCurso());
 }
}
