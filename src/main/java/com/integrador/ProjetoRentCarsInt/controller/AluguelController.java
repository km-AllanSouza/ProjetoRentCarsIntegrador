package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import com.integrador.ProjetoRentCarsInt.model.DTO.AluguelDTO;
import com.integrador.ProjetoRentCarsInt.service.AluguelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
@Api(tags = "Aluguel")
public class AluguelController {

    @Autowired
    AluguelService aluguelService;

    @PostMapping
    @ApiOperation(value = "Cria um novo aluguel")
    public ResponseEntity salvarAluguel(@RequestBody Aluguel aluguel) {
        return new ResponseEntity(aluguelService.salvarAluguel(aluguel), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todos os aluguéis")
    public ResponseEntity buscarAluguel() {
        return new ResponseEntity(aluguelService.listarAluguel(), HttpStatus.OK);
    }

    @PatchMapping
    @ApiOperation(value = "Atualiza um aluguel existente")
    public ResponseEntity alterarAluguel(@RequestBody Aluguel aluguel) {
        aluguelService.alterarAluguel(aluguel);
        return new ResponseEntity(aluguel.getId(), HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Exclui um aluguel pelo ID")
    public ResponseEntity deleteAluguel(@RequestParam Long id) {
        aluguelService.excluirAluguel(id);
        return new ResponseEntity("ID: " + id + " Excluido.", HttpStatus.OK);
    }

    @GetMapping(value = "buscaid")
    @ApiOperation(value = "Busca um aluguel pelo ID")
    public ResponseEntity buscarAluguelID(@RequestParam("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Aluguel> aluguelOptional = aluguelService.buscarAluguelID(id);
        if (aluguelOptional.isEmpty()) {
            return new ResponseEntity("Aluguel nao encontrado", HttpStatus.NOT_FOUND);
        }
        Aluguel aluguel = aluguelOptional.get();
        AluguelDTO aluguelDTO = mapper.convertValue(aluguel, AluguelDTO.class);

        return new ResponseEntity(aluguelDTO, HttpStatus.OK);
    }

}
