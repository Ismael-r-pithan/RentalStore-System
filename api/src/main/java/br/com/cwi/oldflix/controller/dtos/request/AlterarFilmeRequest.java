package br.com.cwi.oldflix.controller.dtos.request;

import br.com.cwi.oldflix.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarFilmeRequest {
    private String titulo;
    private String descricao;
    private Categoria categoria;
}
