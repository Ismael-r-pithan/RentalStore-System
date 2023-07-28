package br.com.cwi.oldflix.controller.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlugarFilmeResponse {
    private Long id;
    private String responsavel;
    private LocalDate dataRetirada;

}
