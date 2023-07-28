package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.request.AlugarFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.response.AlugarFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.mapper.AlugarFilmeMapper;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class AlugarFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    public AlugarFilmeResponse executar(Long id, AlugarFilmeRequest request) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        if (!filme.getDisponivel()) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Filme está locado no momento");
        }

        filme.setDisponivel(false);
        filme.setDataRetirada(LocalDate.now(ZoneId.of("UTC")));
        filme.setResponsavel(request.getResponsavel());

        filmeRepository.save(filme);

        return AlugarFilmeMapper.toResponse(filme);
    }

}
