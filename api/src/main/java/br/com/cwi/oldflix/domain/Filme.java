package br.com.cwi.oldflix.domain;

import br.com.cwi.oldflix.domain.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Getter
@Setter
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private Boolean disponivel;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Categoria categoria;
    private String responsavel;
    private LocalDate dataRetirada;

}
