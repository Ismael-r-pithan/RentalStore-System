package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.response.DevolverFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.mapper.DevolverFilmeMapper;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DevolverFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public DevolverFilmeResponse executar(Long id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        if (filme.getDisponivel()) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Filme não está locado");
        }

        filme.setDisponivel(true);
        filme.setDataRetirada(null);
        filme.setResponsavel(null);

        filmeRepository.save(filme);

        return DevolverFilmeMapper.toResponse(filme);
    }
}
