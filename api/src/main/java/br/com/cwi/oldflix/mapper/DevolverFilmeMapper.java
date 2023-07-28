package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.dtos.response.AlugarFilmeResponse;
import br.com.cwi.oldflix.controller.dtos.response.DevolverFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;

public class DevolverFilmeMapper {

    public static DevolverFilmeResponse toResponse(Filme filme) {
        DevolverFilmeResponse response = new DevolverFilmeResponse();
        response.setId(filme.getId());

        return response;
    }
}
