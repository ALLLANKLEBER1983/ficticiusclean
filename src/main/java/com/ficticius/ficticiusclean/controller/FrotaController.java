package com.ficticius.ficticiusclean.controller;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;
import com.ficticius.ficticiusclean.service.FrotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frotas")
@RequiredArgsConstructor
@Api(value = "API REST Frota")
@CrossOrigin(origins = "*")
public class FrotaController {

    private final FrotaService frotaService;

    @GetMapping
    public ResponseEntity<List<Frota>> getAllFrota(){
        return ResponseEntity.ok(frotaService.getAllFrota());
    }

    @GetMapping("/ranqueada/{valorGasolina}/{valorCidade}/{valorRodovia}")
    @ApiOperation(value = "Retorna uma busca ranqueada por valor total de gasto com combustível")
    public ResponseEntity<List<FrotaRanqueadaDTO>> BuscaRanqueada (@PathVariable Double valorCidade,
                                                                   @PathVariable Double valorRodovia,
                                                                   @PathVariable Double valorGasolina){

    return ResponseEntity.ok(frotaService.getFrotasRanqueadas(valorCidade,valorRodovia,valorGasolina));

    }

    @PostMapping
    public ResponseEntity<FrotaDTO> create(@RequestBody FrotaDTO frota){
        return ResponseEntity.ok(frotaService.create(frota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrotaDTO> update(@RequestBody FrotaDTO dto,@PathVariable Long id){
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
