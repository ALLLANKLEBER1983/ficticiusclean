package com.ficticius.ficticiusclean.repositories;

import com.ficticius.ficticiusclean.dto.FrotaDTO;
import com.ficticius.ficticiusclean.entities.Frota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FrotaRepository extends JpaRepository<Frota,Long> {

   // @Query("select f.id, f.nome, f.marca, f.modelo, f.dataFabricacao, f.consumoMedioCombustivelDentroDaCidade, f.consumoMedioCombustivelEmRodovias, f.atualizacao," +
          //  "(((:consumoMedioCombustivelDentroDaCidade / f.consumoMedioCombustivelDentroDaCidade) + (:consumoMedioCombustivelEmRodovias / f.consumoMedioCombustivelEmRodovias)) * :valorGasolina) as valor" +
          //  " FROM Frota f " +
          //  " ORDER BY valor ")
   // List<Frota> findByPrecoEDistancia(
         //   @Param("valorGasolina") Integer preco,
         //   @Param("consumoMedioCombustivelDentroDaCidade") Integer consumoMedioCombustivelDentroDaCidade,
          //  @Param("consumoMedioCombustivelEmRodovias") Integer consumoMedioCombustivelEmRodovias);

}
