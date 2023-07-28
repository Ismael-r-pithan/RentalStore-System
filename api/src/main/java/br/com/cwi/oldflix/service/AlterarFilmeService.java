package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.request.AlterarFilmeRequest;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlterarFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public void executar(AlterarFilmeRequest request, Long id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        if (!filme.getDisponivel()) {
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Filme está locado");
        }

        filme.setTitulo(request.getTitulo());
        filme.setDescricao(request.getDescricao());
        filme.setCategoria(request.getCategoria());

        filmeRepository.save(filme);
    }
}
