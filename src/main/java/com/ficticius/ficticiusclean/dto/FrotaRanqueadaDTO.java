package com.ficticius.ficticiusclean.dto;

import com.ficticius.ficticiusclean.entities.Frota;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FrotaRanqueadaDTO {
    private Frota frota;
    private Double valorGastoCombustivel;

    public FrotaRanqueadaDTO(
            Frota frota,
            Double consumoMedioCombustivelCidade,
            Double consumoMedioCombustivelRodovia,
            Double valorGasolina
    ) {
        this.frota = frota;
        this.valorGastoCombustivel = frota.calcular(
                consumoMedioCombustivelCidade,
                consumoMedioCombustivelRodovia,
                valorGasolina
        );
    }

}
