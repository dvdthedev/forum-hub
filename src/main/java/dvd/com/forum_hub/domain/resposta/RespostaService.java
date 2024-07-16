package dvd.com.forum_hub.domain.resposta;

import dvd.com.forum_hub.domain.autor.AutorRepository;
import dvd.com.forum_hub.domain.exception.ValidacaoException;
import dvd.com.forum_hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {
    @Autowired
    RespostaRepository repository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    AutorRepository autorRepository;
    public DadosResposta postarResposta(DadosNovaResposta dados) {
        var autor = dados.autorId();
        if(!autorRepository.findById(autor).isPresent()){
            throw new ValidacaoException("Autor não existe!");
        }
        var topico = dados.topicoId();
        if(!topicoRepository.findById(dados.topicoId()).isPresent()){
            throw new ValidacaoException("Tópico não existe");
        }
        var mensagem = new Resposta(dados.mensagem(), LocalDateTime.now(), autorRepository.getReferenceById(dados.autorId()), topicoRepository.getReferenceById(dados.topicoId()));
        repository.save(mensagem);
        return new DadosResposta(dados.mensagem(), LocalDateTime.now(), dados.autorId(), dados.topicoId());
    }
}
