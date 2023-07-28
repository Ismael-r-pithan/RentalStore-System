package br.com.cwi.oldflix.controller.dtos.response;

import br.com.cwi.oldflix.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarFilmesResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean disponivel;
    private Categoria categoria;
}
