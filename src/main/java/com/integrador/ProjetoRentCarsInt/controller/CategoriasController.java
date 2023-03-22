package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Categorias;
import com.integrador.ProjetoRentCarsInt.model.DTO.CategoriasDTO;
import com.integrador.ProjetoRentCarsInt.service.CategoriasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Api(value = "CategoriasController", tags = {"Categorias"})
public class CategoriasController {

    @Autowired
    CategoriasService categoriasService;

    @PostMapping
    @ApiOperation(value = "Salva uma nova categoria")
    public ResponseEntity salvarCategoria(@RequestBody Categorias categorias) {
        return new ResponseEntity(categoriasService.salvarCategorias(categorias), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as categorias cadastradas")
    public ResponseEntity listarCategorias() {
        return new ResponseEntity(categoriasService.listarCategorias(), HttpStatus.OK);
    }

    @PatchMapping
    @ApiOperation(value = "Altera uma categoria existente")
    public ResponseEntity alterarCategoria(@RequestBody Categorias categorias) {
        categoriasService.alterarCategorias(categorias);
        return new ResponseEntity(categorias.getId(), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Exclui uma categoria existente")
    public ResponseEntity deleteCategorias(@RequestParam Long id) {
        categoriasService.excluirCategoria(id);
        return new ResponseEntity("ID: " + id + " Excluido.", HttpStatus.OK);
    }

    @RequestMapping(value = "buscaid", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma categoria com base no seu ID")
    public ResponseEntity buscarCategoriaID(@RequestParam("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Categorias> categoriasOptional = categoriasService.buscarCategoriasID(id);
        if (categoriasOptional.isEmpty()) {
            return new ResponseEntity("Categoria nao encontrada", HttpStatus.NOT_FOUND);
        }
        Categorias categorias = categoriasOptional.get();
        CategoriasDTO categoriaslDTO = mapper.convertValue(categorias, CategoriasDTO.class);

        return new ResponseEntity(categoriaslDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "buscarating", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de categorias com uma determinada qualificação")
    public ResponseEntity buscaCategoriasRating(@RequestParam("rating") int rating) {

        List<CategoriasDTO> categoriasDTOrating = categoriasService.buscarCategoriasRating(rating);

        if (categoriasDTOrating.isEmpty()) {
            return new ResponseEntity("Qualificacao nao encontrada", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(categoriasDTOrating, HttpStatus.OK);
    }

}
