package com.ficticius.ficticiusclean.service.impl;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;
import com.ficticius.ficticiusclean.exception.FrotaNaoEncontradaException;
import com.ficticius.ficticiusclean.repositories.FrotaRepository;
import com.ficticius.ficticiusclean.service.FrotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FrotaServiceImpl implements FrotaService {


    private final FrotaRepository frotaRepository;

    public List<Frota> getAllFrota(){
        return frotaRepository.findAll();
    }

    @Override
    @Transactional
    public FrotaDTO create(FrotaDTO dto){
        Frota frota = convertToDto(dto);
        frotaRepository.save(frota);
        return dto;
    }

    @Override
    public List<FrotaRanqueadaDTO> getFrotasRanqueadas(
            Double consumoMedioCombustivelCidade,
            Double consumoMedioCombustivelRodovia,
            Double valorGasolina
    ) {
        List<Frota> frotas = frotaRepository.findAll();

       return frotas.stream()
                .map(f -> new FrotaRanqueadaDTO(
                        f,
                        consumoMedioCombustivelCidade,
                        consumoMedioCombustivelRodovia,
                        valorGasolina
                ))
                .collect(Collectors.toList());

    }



    @Override
    @Transactional
    public FrotaDTO update(FrotaDTO dto,Long id){
        Frota frota = findById(id);
        frota.setNome(dto.getNome());
        frota.setMarca(dto.getMarca());
        frota.setModelo(dto.getModelo());
        frota.setConsumoMedioCombustivelCidade(dto.getConsumoMedioCombustivelCidade());
        frota.setConsumoMedioCombustivelRodovia(dto.getConsumoMedioCombustivelRodovia());
        frota.setDataFabricacao(dto.getDataFabricacao());
        frotaRepository.save(frota);
        return dto;
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        frotaRepository.deleteById(id);
    }

    @Override
    public Frota findById(Long id){
        Optional<Frota> frota = frotaRepository.findById(id);

        if(frota.isPresent()){
            return frota.get();
        }

        throw new FrotaNaoEncontradaException("Frota não encontrada");
    }

    @Override
    public Frota convertToDto(FrotaDTO dto){
        return Frota
                .builder()
                .dataFabricacao(dto.getDataFabricacao())
                .consumoMedioCombustivelCidade(dto.getConsumoMedioCombustivelCidade())
                .consumoMedioCombustivelRodovia(dto.getConsumoMedioCombustivelRodovia())
                .nome(dto.getNome())
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .build();
    }
}
