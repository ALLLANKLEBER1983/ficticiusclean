package com.ficticius.ficticiusclean.service;

import com.ficticius.ficticiusclean.dto.FrotaRanqueadaDTO;
import com.ficticius.ficticiusclean.entities.Frota;
import com.ficticius.ficticiusclean.repositories.FrotaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FrotaServiceTest {

    @SpyBean
    FrotaServiceImpl service;

    @MockBean
    FrotaRepository repository;


    @Test()
    public void deveTrazerUmaBuscaRanqueada() {
        //Cenário
        Frota frota = criarFrota();
        repository.save(frota);

        //ação
        Double consumoMedioCombustivelCidade =  18D;
        Double consumoMedioCombustivelRodovia = 20D;
        Double valorGasolina = 20D;
        List<FrotaRanqueadaDTO> result =  service.getFrotasRanqueadas(consumoMedioCombustivelCidade, consumoMedioCombustivelRodovia, valorGasolina);

        //verificação
        Assertions.assertThat(result).map();

    }

    @Test
    public void devePersistirUmaFrotaNaBase(){
        //cenário
        Frota frota = criarFrota();

        //ação
        Frota frotaSalva = repository.save(frota);

        //verificação
        Assertions.assertThat(frotaSalva);
    }

    public static Frota criarFrota(){
        return   Frota
                .builder()
                .id(1L)
                .dataFabricacao(2018)
                .consumoMedioCombustivelCidade(8D)
                .consumoMedioCombustivelRodovia(18D)
                .nome("Audi")
                .marca("A3")
                .modelo("55555")
                .build();
    }


    }

