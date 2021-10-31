package com.ficticius.ficticiusclean.service;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;

import java.util.List;

public interface FrotaService {

    Frota create(Frota dto);
    FrotaDTO update(FrotaDTO dto,Long id);
    void deleteById(Long id);
    Frota findById(Long id);
    Frota convertToDto(FrotaDTO dto);
    List<FrotaRanqueadaDTO> getFrotasRanqueadas(
            Double consumoMedioCombustivelCidade,
            Double consumoMedioCombustivelRodovia,
            Double valorGasolina
    );

}
