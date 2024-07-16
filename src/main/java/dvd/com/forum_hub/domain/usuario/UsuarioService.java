package dvd.com.forum_hub.domain.usuario;

import dvd.com.forum_hub.domain.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordService passwordService;

    public DadosUsuario buscarUsuarioId(Long id) {
       var usuario = repository.findById(id);
       if(!usuario.isPresent()){
           throw new ValidacaoException("Usuário não encontrado");
       } else
        return new DadosUsuario(usuario);
    }

    public DadosUsuario cadastroUsuario(DadosCadastroUsuario dados) {
        if(repository.existsByLogin(dados.login())){
            throw new ValidacaoException("Login já cadastrado!");
        }

        if(repository.existsByEmail(dados.email())){
            throw new ValidacaoException("Email já cadastrado!");
        }

        String encryptedPassword = passwordService.encryptPassword(dados.senha());
        var novoUsuario = new Usuario(dados.login(), dados.email(), encryptedPassword);
        repository.save(novoUsuario);
        return new DadosUsuario(dados.login(), dados.email());
    }
}
