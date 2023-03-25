package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.CarroIMGurl;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroIMGurlDTO;
import com.integrador.ProjetoRentCarsInt.service.CarroIMGurlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carroimgs")
@Api(value = "API REST de cadastro de imagens de Carros")
public class CarroIMGurlController {

    @Autowired
    CarroIMGurlService carroIMGurlService;

    @ApiOperation(value = "Cadastra uma nova imagem de Carro")
    @PostMapping
    public ResponseEntity salvarCarroIMG(@RequestBody CarroIMGurl carroIMGurl) {
        return new ResponseEntity(carroIMGurlService.salvarCarrosIMG(carroIMGurl), HttpStatus.OK);
    }

    @ApiOperation(value = "Lista todas as imagens de Carros cadastradas")
    @GetMapping
    public ResponseEntity buscarCarroIMG() {
        return new ResponseEntity(carroIMGurlService.listarCarrosIMG(), HttpStatus.OK);
    }

    @ApiOperation(value = "Altera uma imagem de Carro existente")
    @PatchMapping
    public ResponseEntity alterarCarroIMG(@RequestBody CarroIMGurl carroIMGurl) {
        carroIMGurlService.alterarCarroIMG(carroIMGurl);
        return new ResponseEntity(carroIMGurl.getId(), HttpStatus.OK);
    }

    @ApiOperation(value = "Exclui uma imagem de Carro existente")
    @DeleteMapping
    public ResponseEntity deleteCarroIMG(@RequestParam("id") Long id) {
        carroIMGurlService.excluirCarroIMG(id);
        return new ResponseEntity("ID: " + id + " Excluido.", HttpStatus.OK);
    }

    @ApiOperation(value = "Busca uma imagem de Carro por ID")
    @RequestMapping(value = "buscaIMGid", method = RequestMethod.GET)
    public ResponseEntity buscarCarroIMGid(@RequestParam("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<CarroIMGurl> carroIMGurlOptional = carroIMGurlService.buscarCarroIMGid(id);
        if (carroIMGurlOptional.isEmpty()) {
            return new ResponseEntity("CarroIMGurl nao encontrado", HttpStatus.NOT_FOUND);
        }
        CarroIMGurl carroIMGurl = carroIMGurlOptional.get();
        CarroIMGurlDTO carroIMGurlDTO = mapper.convertValue(carroIMGurl, CarroIMGurlDTO.class);

        return new ResponseEntity(carroIMGurlDTO, HttpStatus.OK);
    }

}
