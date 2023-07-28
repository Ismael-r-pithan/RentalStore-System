package br.com.cwi.oldflix.controller.dtos.response;

import br.com.cwi.oldflix.domain.enums.Categoria;
import br.com.cwi.oldflix.domain.enums.Situacao;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class DetalhesFilmeResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private Boolean disponivel;
    private Categoria categoria;
    private String responsavel;
    private LocalDate dataRetirada;
    private LocalDate dataEntrega;
    private Situacao situacao;
}
