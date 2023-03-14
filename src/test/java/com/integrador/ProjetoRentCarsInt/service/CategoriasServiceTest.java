package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Categorias;
import com.integrador.ProjetoRentCarsInt.model.DTO.CategoriasDTO;
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
class CategoriasServiceTest {

    @Autowired

    CategoriasService categoriasServiceTest;
    static Categorias categoriasTeste;

    @BeforeEach
    void doBefore(){

        categoriasTeste = new Categorias(2,"descricao teste","url do teste");

    }

    @Test
    void salvarCategorias() {

        categoriasTeste = categoriasServiceTest.salvarCategorias(categoriasTeste);
        assertTrue(categoriasTeste.getId() > 0);

    }

    @Test
    void listarCategorias() {

        Categorias categoriasTeste2 = new Categorias(5,"descrição teste 2","url teste 2");
        categoriasServiceTest.salvarCategorias(categoriasTeste2);
        categoriasTeste = categoriasServiceTest.salvarCategorias(categoriasTeste);

        List<CategoriasDTO> result = categoriasServiceTest.listarCategorias();
        assertTrue(result.size() > 1);

    }

    @Test
    void alterarCategorias() {

        categoriasTeste = categoriasServiceTest.salvarCategorias(categoriasTeste);

        int novoQualific = 10;
        String novoUrl = "nova URL do teste";

        categoriasTeste.setRating(novoQualific);
        categoriasTeste.setUrl(novoUrl);
        categoriasServiceTest.alterarCategorias(categoriasTeste);

        Optional<Categorias> result = categoriasServiceTest.buscarCategoriasID(categoriasTeste.getId());
        Categorias categoriasAlterado = result.get();
        assertSame(categoriasAlterado.getRating(),novoQualific);
        assertSame(categoriasAlterado.getUrl(),novoUrl);

    }

    @Test
    void excluirCategoria() {

        categoriasTeste = categoriasServiceTest.salvarCategorias(categoriasTeste);
        categoriasServiceTest.excluirCategoria(categoriasTeste.getId());

        assertFalse(categoriasServiceTest.buscarCategoriasID(categoriasTeste.getId()).isPresent());

    }

    @Test
    void buscarCategoriasID() {

        categoriasTeste = categoriasServiceTest.salvarCategorias(categoriasTeste);

        assertTrue(categoriasServiceTest.buscarCategoriasID(categoriasTeste.getId()).isPresent());

    }


}