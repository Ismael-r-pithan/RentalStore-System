package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.response.DetalhesFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.domain.enums.Situacao;
import br.com.cwi.oldflix.mapper.DetalhesFilmeMapper;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class DetalhesFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public DetalhesFilmeResponse executar(Long id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        DetalhesFilmeResponse response = DetalhesFilmeMapper.toResponse(filme);

        if (filme.getDataRetirada() != null) {
            LocalDate dataEntrega = filme.getDataRetirada().plusDays(filme.getCategoria().getDiasParaEntregarFilme());
            response.setDataEntrega(dataEntrega);
            response.setSituacao(dataEntrega.isBefore(LocalDate.now()) ? Situacao.EM_ATRASO : Situacao.EM_DIA);
        }

        return response;
    }
}
