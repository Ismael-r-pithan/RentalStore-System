package br.com.cwi.oldflix.mapper;

import br.com.cwi.oldflix.controller.dtos.response.AlugarFilmeResponse;
import br.com.cwi.oldflix.domain.Filme;

public class AlugarFilmeMapper {
        public static AlugarFilmeResponse toResponse(Filme filme) {
            AlugarFilmeResponse response = new AlugarFilmeResponse();
            response.setId(filme.getId());
            response.setResponsavel(filme.getResponsavel());
            response.setDataRetirada(filme.getDataRetirada());

            return response;
        }
}
