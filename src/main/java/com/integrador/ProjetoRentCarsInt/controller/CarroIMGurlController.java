package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.CarroIMGurl;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroIMGurlDTO;
import com.integrador.ProjetoRentCarsInt.service.CarroIMGurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carroimg")
public class CarroIMGurlController {

    @Autowired
    CarroIMGurlService carroIMGurlService;

    @PostMapping
    public ResponseEntity salvarCarroIMG(@RequestBody CarroIMGurl carroIMGurl){
        return new ResponseEntity(carroIMGurlService.salvarCarrosIMG(carroIMGurl), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity buscarCarroIMG(){
        return new ResponseEntity(carroIMGurlService.listarCarrosIMG(),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterarCarroIMG(@RequestBody CarroIMGurl carroIMGurl){
        carroIMGurlService.alterarCarroIMG(carroIMGurl);
        return new ResponseEntity(carroIMGurl.getId(),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteCarroIMG(@RequestParam("id") Long id){
        carroIMGurlService.excluirCarroIMG(id);
        return new ResponseEntity("ID: " + id + " Excluido.",HttpStatus.OK);
    }

    @RequestMapping(value ="buscaIMGid", method = RequestMethod.GET)
    public ResponseEntity buscarCarroIMGid(@RequestParam("id") Long id){
        ObjectMapper mapper = new ObjectMapper();

        Optional<CarroIMGurl> carroIMGurlOptional = carroIMGurlService.buscarCarroIMGid(id);
        if(carroIMGurlOptional.isEmpty()){
            return new ResponseEntity("CarroIMGurl nao encontrado",HttpStatus.NOT_FOUND);
        }
        CarroIMGurl carroIMGurl = carroIMGurlOptional.get();
        CarroIMGurlDTO carroIMGurlDTO = mapper.convertValue(carroIMGurl,CarroIMGurlDTO.class);

        return new ResponseEntity(carroIMGurlDTO,HttpStatus.OK);
    }

}
