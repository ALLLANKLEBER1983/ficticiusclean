package com.ficticius.ficticiusclean.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class FrotaDTO {
    private String nome;
    private String marca;
    private String modelo;
    private Integer dataFabricacao;
    private Double consumoMedioCombustivelCidade;
    private Double consumoMedioCombustivelRodovia;
    private Date atualizacao;

    }



