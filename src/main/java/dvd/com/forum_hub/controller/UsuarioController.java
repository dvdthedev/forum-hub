package dvd.com.forum_hub.controller;

import dvd.com.forum_hub.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
@SecurityRequirement(name = "bearer-key")

public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuario(@PathVariable Long id) {
        DadosUsuario user = usuarioService.buscarUsuarioId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados){
        var usuario = usuarioService.cadastroUsuario(dados);
        return ResponseEntity.ok().build();
    }
}
