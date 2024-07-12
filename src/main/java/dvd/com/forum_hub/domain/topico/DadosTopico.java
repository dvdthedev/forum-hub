package dvd.com.forum_hub.domain.topico;

import dvd.com.forum_hub.domain.autor.DadosAutor;
import dvd.com.forum_hub.domain.topico.resposta.DadosResposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosTopico(Long id,
                          String titulo,
                          String mensagem,
                          LocalDateTime data,
                          Boolean duvidaResolvida,
                          DadosAutor autor,
                          Curso curso,
                          List<DadosResposta> respostas
                          ) {
}


//private Long id;
//private String titulo;
//private String mensagem;
//private LocalDateTime data = LocalDateTime.now();
//private Boolean duvidaResolvida = false;
//@ManyToOne
//@JoinColumn(name = "autor_id", nullable = false)
//private Autor autor;
//@Enumerated(EnumType.STRING)
//private Curso curso;
//@OneToMany
//private List<Resposta> respostas;