package dvd.com.forum_hub.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor (
        @NotBlank
        String nome
){

}
