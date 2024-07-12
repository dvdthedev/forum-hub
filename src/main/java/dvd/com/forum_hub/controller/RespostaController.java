package dvd.com.forum_hub.controller;

import dvd.com.forum_hub.domain.topico.resposta.DadosResposta;
import dvd.com.forum_hub.domain.topico.resposta.RespostaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")

public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosResposta dados){


        return ResponseEntity.ok().build();
    }
}
