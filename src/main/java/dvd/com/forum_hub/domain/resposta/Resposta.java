package dvd.com.forum_hub.domain.resposta;

import dvd.com.forum_hub.domain.autor.Autor;
import dvd.com.forum_hub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime data = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    public Resposta(String mensagem, LocalDateTime now, Autor autor, Topico topico) {
        this.mensagem = mensagem;
        this.data = now;
        this.autor = autor;
        this.topico = topico;

    }
}
