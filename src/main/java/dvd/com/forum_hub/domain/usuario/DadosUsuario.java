package dvd.com.forum_hub.domain.usuario;

import java.util.Optional;

public record DadosUsuario(
        String login,
        String email
) {
    public DadosUsuario(Optional<Usuario> usuario) {
        this(usuario.get().getLogin(), usuario.get().getEmail());
    }
}
