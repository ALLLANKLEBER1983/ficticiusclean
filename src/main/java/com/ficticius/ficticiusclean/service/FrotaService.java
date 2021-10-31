package com.ficticius.ficticiusclean.service;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;

import java.util.List;

public interface FrotaService {

    FrotaDTO create(FrotaDTO dto);
    List<Frota> getAllFrota();
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
