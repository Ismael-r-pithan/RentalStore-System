package br.com.cwi.oldflix.domain.enums;

import java.time.LocalDate;

public enum Categoria {
    BRONZE(5),
    PRATA(3),
    OURO(2),
    ;

    private final int diasParaEntregarFilme;


    Categoria(int diasParaEntregarFilme) {
        this.diasParaEntregarFilme = diasParaEntregarFilme;
    }

    public int getDiasParaEntregarFilme() {
        return this.diasParaEntregarFilme;
    }
}
