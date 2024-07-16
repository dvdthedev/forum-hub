package dvd.com.forum_hub.domain.resposta;

import dvd.com.forum_hub.domain.autor.DadosAutor;
import dvd.com.forum_hub.domain.topico.DadosTopico;

import java.time.LocalDateTime;

public record DadosResposta (

        String mensagem,
        LocalDateTime data,
        Long autor,
        Long topico
) {

}

//
//public class Resposta {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String mensagem;
//    private LocalDateTime data = LocalDateTime.now();
//    @ManyToOne
//    @JoinColumn(name = "autor_id", nullable = false)
//    private Autor autor;
//    @ManyToOne
//    @JoinColumn(name = "topico_id", nullable = false)
//    private Topico topico;
//}