package br.com.cwi.oldflix.service;

import br.com.cwi.oldflix.controller.dtos.response.ListarFilmesResponse;
import br.com.cwi.oldflix.domain.Filme;
import br.com.cwi.oldflix.mapper.ListarFilmesMapper;
import br.com.cwi.oldflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarFilmesService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<ListarFilmesResponse> executar() {
      List<Filme> filmes = filmeRepository.findAll();
      return filmes.stream().map(ListarFilmesMapper::toResponse).collect(Collectors.toList());
    }
}
