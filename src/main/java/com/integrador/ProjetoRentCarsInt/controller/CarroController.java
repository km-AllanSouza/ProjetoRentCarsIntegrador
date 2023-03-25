package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Carro;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroDTO;
import com.integrador.ProjetoRentCarsInt.service.CarroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carros")
@Api(value = "API REST de cadastro de Carros")
public class CarroController {

    @Autowired
    CarroService carroService;

    @ApiOperation(value = "Cadastra um novo Carro")
    @PostMapping
    public ResponseEntity salvarCarro(@RequestBody Carro carro) {
        return new ResponseEntity(carroService.salvarCarros(carro), HttpStatus.OK);
    }

    @ApiOperation(value = "Lista todos os Carros cadastrados")
    @GetMapping
    public ResponseEntity buscarCarros() {
        return new ResponseEntity(carroService.listarCarros(), HttpStatus.OK);
    }

    @ApiOperation(value = "Altera um Carro existente")
    @PatchMapping
    public ResponseEntity alterarCarro(@RequestBody Carro carro) {
        carroService.alterarCarro(carro);
        return new ResponseEntity(carro.getId(), HttpStatus.OK);
    }

    @ApiOperation(value = "Exclui um Carro existente")
    @DeleteMapping
    public ResponseEntity deleteCarro(@RequestParam Long id) {
        carroService.excluirCarro(id);
        return new ResponseEntity("ID: " + id + " Excluido.", HttpStatus.OK);
    }

    @ApiOperation(value = "Busca um Carro por ID")
    @RequestMapping(value = "buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarCarroID(@RequestParam("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Carro> carroOptional = carroService.buscarCarroID(id);
        if (carroOptional.isEmpty()) {
            return new ResponseEntity("Carro nao encontrado", HttpStatus.NOT_FOUND);
        }
        Carro carro = carroOptional.get();
        CarroDTO carroDTO = mapper.convertValue(carro, CarroDTO.class);

        return new ResponseEntity(carroDTO, HttpStatus.OK);
    }

}

