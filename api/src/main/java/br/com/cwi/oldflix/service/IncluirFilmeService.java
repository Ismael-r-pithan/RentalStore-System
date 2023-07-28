package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.request.IncluirFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.response.IncluirFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.mapper.IncluirFilmeMapper;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncluirFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public IncluirFilmeResponse executar(IncluirFilmeRequest request) {
        Filme filme = IncluirFilmeMapper.toEntity(request);

        filme.setDisponivel(true);

        filmeRepository.save(filme);

        return IncluirFilmeMapper.toResponse(filme);
    }
}
