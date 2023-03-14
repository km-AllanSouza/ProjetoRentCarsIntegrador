package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Carro;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CarroServiceTest {

    @Autowired
    CarroService carroServiceTest;
    static Carro carroTeste;

    @BeforeEach
    void doBefore(){

        carroTeste = new Carro("Corsa","Chevrolet","Preto");

    }

    @Test
    void salvarCarros() {

        carroTeste = carroServiceTest.salvarCarros(carroTeste);
        assertTrue( carroTeste.getId() > 0);

    }

    @Test
    void listarCarros() {

        Carro carroTeste2 = new Carro("Palio","FIAT","Rosa");
        carroServiceTest.salvarCarros(carroTeste2);
        carroTeste = carroServiceTest.salvarCarros(carroTeste);

        List<CarroDTO> result = carroServiceTest.listarCarros();
        assertTrue(result.size() > 1);

    }

    @Test
    void alterarCarro() {

        carroTeste = carroServiceTest.salvarCarros(carroTeste);

        String novoModelo = "Corsa";
        String novoMarca = "Chevrolet";

        carroTeste.setModelo(novoModelo);
        carroTeste.setMarca(novoMarca);
        carroServiceTest.alterarCarro(carroTeste);

        Optional<Carro> result = carroServiceTest.buscarCarroID(carroTeste.getId());
        Carro carroAlterado = result.get();
        assertSame(carroAlterado.getModelo(),novoModelo);
        assertSame(carroAlterado.getMarca(),novoMarca);

    }

    @Test
    void excluirCarro() {

        carroTeste = carroServiceTest.salvarCarros(carroTeste);
        carroServiceTest.excluirCarro(carroTeste.getId());

        assertFalse(carroServiceTest.buscarCarroID(carroTeste.getId()).isPresent());

    }

    @Test
    void buscarCarroID() {

        carroTeste = carroServiceTest.salvarCarros(carroTeste);
        //Optional<Carro> result = carroServiceTest.buscarCarroID(carroTeste.getId());

        //assertEquals(carroTeste,result.orElse(null));
        assertTrue(carroServiceTest.buscarCarroID(carroTeste.getId()).isPresent());

    }
}