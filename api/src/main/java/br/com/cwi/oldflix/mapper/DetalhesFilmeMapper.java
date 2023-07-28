package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.dtos.response.DetalhesFilmeResponse;
import br.com.cwi.oldflix.controller.dtos.response.ListarFilmesResponse;
import br.com.cwi.oldflix.domain.Filme;

public class DetalhesFilmeMapper {

    public static DetalhesFilmeResponse toResponse(Filme entity) {
        DetalhesFilmeResponse response = new DetalhesFilmeResponse();
        response.setId(entity.getId());
        response.setDescricao(entity.getDescricao());
        response.setCategoria(entity.getCategoria());
        response.setTitulo(entity.getTitulo());
        response.setDisponivel(entity.getDisponivel());
        response.setResponsavel(entity.getResponsavel());
        response.setDataRetirada(entity.getDataRetirada());

        return response;
    }
}
