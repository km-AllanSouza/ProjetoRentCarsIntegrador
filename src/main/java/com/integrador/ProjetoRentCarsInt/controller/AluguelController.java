package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import com.integrador.ProjetoRentCarsInt.model.DTO.AluguelDTO;
import com.integrador.ProjetoRentCarsInt.service.AluguelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    AluguelService aluguelService;

    @PostMapping
    public ResponseEntity salvarAluguel(@RequestBody Aluguel aluguel){
        return new ResponseEntity(aluguelService.salvarAluguel(aluguel), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity buscarAluguel(){
        return new ResponseEntity(aluguelService.listarAluguel(),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterarAluguel(@RequestBody Aluguel aluguel){
        aluguelService.alterarAluguel(aluguel);
        return new ResponseEntity(aluguel.getId(),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAluguel(@RequestParam Long id){
        aluguelService.excluirAluguel(id);
        return new ResponseEntity("ID: "+ id +" Excluido.",HttpStatus.OK);
    }

    @RequestMapping(value ="buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarAluguelID(@RequestParam("id") Long id){
        ObjectMapper mapper = new ObjectMapper();

        Optional<Aluguel> aluguelOptional = aluguelService.buscarAluguelID(id);
        if(aluguelOptional.isEmpty()){
            return new ResponseEntity("Aluguel nao encontrado",HttpStatus.NOT_FOUND);
        }
        Aluguel aluguel = aluguelOptional.get();
        AluguelDTO aluguelDTO = mapper.convertValue(aluguel,AluguelDTO.class);

        return new ResponseEntity(aluguelDTO,HttpStatus.OK);
    }

}
