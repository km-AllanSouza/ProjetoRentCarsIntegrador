package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Categorias;
import com.integrador.ProjetoRentCarsInt.model.DTO.CategoriasDTO;
import com.integrador.ProjetoRentCarsInt.service.CategoriasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    CategoriasService categoriasService;

    @PostMapping
    public ResponseEntity salvarCategoria(@RequestBody Categorias categorias){
        return new ResponseEntity(categoriasService.salvarCategorias(categorias), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity listarCategorias(){
        return new ResponseEntity(categoriasService.listarCategorias(),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterarCategoria(@RequestBody Categorias categorias){
        categoriasService.alterarCategorias(categorias);
        return new ResponseEntity(categorias.getId(),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteCategorias(@RequestParam Long id){
        categoriasService.excluirCategoria(id);
        return new ResponseEntity("ID: "+ id +" Excluido.",HttpStatus.OK);
    }

    @RequestMapping(value ="buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarAluguelID(@RequestParam("id") Long id){
        ObjectMapper mapper = new ObjectMapper();

        Optional<Categorias> categoriasOptional = categoriasService.buscarCategoriasID(id);
        if(categoriasOptional.isEmpty()){
            return new ResponseEntity("Categoria nao encontrada",HttpStatus.NOT_FOUND);
        }
        Categorias categorias = categoriasOptional.get();
        CategoriasDTO categoriaslDTO = mapper.convertValue(categorias,CategoriasDTO.class);

        return new ResponseEntity(categoriaslDTO,HttpStatus.OK);
    }

}
