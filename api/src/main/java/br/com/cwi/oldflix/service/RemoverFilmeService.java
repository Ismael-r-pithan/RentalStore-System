package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RemoverFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public void executar(Long id) {
        Optional<Filme> filme = filmeRepository.findById(id);

        if (filme.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado");
        }

        if (!filme.get().getDisponivel()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Filme não está disponível");
        }

        filmeRepository.deleteById(id);
    }
}
