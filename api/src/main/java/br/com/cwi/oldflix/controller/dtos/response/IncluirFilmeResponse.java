package br.com.cwi.oldflix.controller.dtos.response;

import br.com.cwi.oldflix.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
public class IncluirFilmeResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean disponivel;
    private Categoria categoria;
}
