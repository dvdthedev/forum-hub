package dvd.com.forum_hub.controller;

import dvd.com.forum_hub.domain.resposta.DadosNovaResposta;
import dvd.com.forum_hub.domain.resposta.DadosResposta;
import dvd.com.forum_hub.domain.resposta.RespostaRepository;
import dvd.com.forum_hub.domain.resposta.RespostaService;
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
    @Autowired
    private RespostaService service;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosNovaResposta dados){

        System.out.println(dados);
        var dto = service.postarResposta(dados);
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }
}
