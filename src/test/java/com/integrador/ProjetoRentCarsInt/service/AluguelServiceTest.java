package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import com.integrador.ProjetoRentCarsInt.model.DTO.AluguelDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AluguelServiceTest {

    @Autowired
    AluguelService aluguelService;

    static Aluguel aluguelTeste;

    @BeforeAll
    static void doBefore() {
        aluguelTeste = new Aluguel();

        aluguelTeste.setDt_Saida(Date.valueOf("10-10-2023"));
        aluguelTeste.setHr_Saida(Time.valueOf("10:30:00"));
        aluguelTeste.setDt_Entrega(Date.valueOf("20-10-2023"));
        aluguelTeste.setHr_Entrega(Time.valueOf("18:30:00"));
    }

    @Test
    void salvarAluguel() {

        aluguelTeste = aluguelService.salvarAluguel(aluguelTeste);
        assertTrue( aluguelTeste.getId()>0);

    }

    @Test
    void listarAluguel() {

        Aluguel aluguelTeste2 = new
                Aluguel(
                Time.valueOf("09:20:00"),
                Date.valueOf("10-10-2023"),
                Time.valueOf("18:00:00"),
                Date.valueOf("20-10-2023")
        );

        aluguelService.salvarAluguel(aluguelTeste2);
        aluguelTeste = aluguelService.salvarAluguel(aluguelTeste);

        List<AluguelDTO> result = aluguelService.listarAluguel();
        assertTrue(result.size()>1);

    }

    @Test
    void alterarAluguel() {
    }

    @Test
    void excluirAluguel() {
    }

    @Test
    void buscarAluguelID() {
    }
}