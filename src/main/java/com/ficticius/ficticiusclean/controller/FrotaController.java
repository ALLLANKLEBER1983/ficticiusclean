package com.ficticius.ficticiusclean.controller;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;
import com.ficticius.ficticiusclean.service.FrotaService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frotas")
@RequiredArgsConstructor
public class FrotaController {

    private final FrotaService frotaService;

    @GetMapping("/{valorGasolina}/{valorCidade}/{valorRodovia}")
    public ResponseEntity<List<FrotaRanqueadaDTO>> BuscaRanqueada (@PathVariable Double valorCidade,
                                                                   @PathVariable Double valorRodovia,
                                                                   @PathVariable Double valorGasolina){

    return ResponseEntity.ok(frotaService.getFrotasRanqueadas(valorCidade,valorRodovia,valorGasolina));

    }

    @PostMapping
    public ResponseEntity<Frota> create(@RequestBody Frota frota){
        return ResponseEntity.ok(frotaService.create(frota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrotaDTO> update(FrotaDTO dto,@PathVariable Long id){
        return ResponseEntity.ok(frotaService.update(dto,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frota> findById(@PathVariable Long id){
        return ResponseEntity.ok(frotaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarro(@PathVariable Long id){
        frotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
