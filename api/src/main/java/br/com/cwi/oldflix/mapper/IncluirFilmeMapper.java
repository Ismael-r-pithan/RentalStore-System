package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.dtos.request.IncluirFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.response.IncluirFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;

public class IncluirFilmeMapper {

    public static Filme toEntity(IncluirFilmeRequest request) {
        Filme entity = new Filme();
        entity.setCategoria(request.getCategoria());
        entity.setDescricao(request.getDescricao());
        entity.setTitulo(request.getTitulo());
        return entity;
    }

    public static IncluirFilmeResponse toResponse(Filme entity) {
        IncluirFilmeResponse response = new IncluirFilmeResponse();
        response.setId(entity.getId());
        response.setCategoria(entity.getCategoria());
        response.setDisponivel(entity.getDisponivel());
        response.setTitulo(entity.getTitulo());
        response.setDescricao(entity.getDescricao());

        return response;
    }
}
