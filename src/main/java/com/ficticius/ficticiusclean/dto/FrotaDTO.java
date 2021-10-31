package com.ficticius.ficticiusclean.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class FrotaDTO {
    private Long id;
    private String nome;
    private String marca;
    private String modelo;
    private Integer dataFabricacao;
    private Double consumoMedioCombustivelCidade;
    private Double consumoMedioCombustivelRodovia;
    private Date atualizacao;

    }



