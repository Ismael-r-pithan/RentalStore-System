package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.dtos.response.ListarFilmesResponse;
import br.com.cwi.oldflix.domain.Filme;

public class ListarFilmesMapper {

    public static ListarFilmesResponse toResponse(Filme entity) {
        ListarFilmesResponse response = new ListarFilmesResponse();
        response.setId(entity.getId());
        response.setDescricao(entity.getDescricao());
        response.setCategoria(entity.getCategoria());
        response.setTitulo(entity.getTitulo());
        response.setDisponivel(entity.getDisponivel());

        return response;
    }
}
