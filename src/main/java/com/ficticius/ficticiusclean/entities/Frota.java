package com.ficticius.ficticiusclean.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Frota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String marca;
    private String modelo;
    private Integer dataFabricacao;
    private Double consumoMedioCombustivelCidade;
    private Double consumoMedioCombustivelRodovia;
    private Date atualizacao;

    public Double calcular(
            Double consumoMedioCombustivelCidade,
            Double consumoMedioCombustivelRodovia,
            Double valorGasolina
    ) {
        return (
                (consumoMedioCombustivelCidade / this.consumoMedioCombustivelCidade) +
                        (consumoMedioCombustivelRodovia / this.consumoMedioCombustivelRodovia)
        ) * valorGasolina;
    }
    }


