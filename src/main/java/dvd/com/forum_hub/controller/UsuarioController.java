package dvd.com.forum_hub.controller;

import dvd.com.forum_hub.domain.usuario.DadosCadastroUsuario;
import dvd.com.forum_hub.domain.usuario.Usuario;
import dvd.com.forum_hub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    private ResponseEntity<?> buscarUsuario(@PathVariable Long id) {
        var user = repository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    private ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados){
        var usuario = new Usuario(dados);
        repository.save(usuario);
        //var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.ok().build();
    }
}
