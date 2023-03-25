package com.integrador.ProjetoRentCarsInt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.ProjetoRentCarsInt.model.Cliente;
import com.integrador.ProjetoRentCarsInt.model.DTO.ClienteDTO;
import com.integrador.ProjetoRentCarsInt.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Clientes", tags = {"Clientes"})
@RestController
@RequestMapping("clientes")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Salva um novo cliente", response = ResponseEntity.class)
    @PostMapping
    public ResponseEntity salvarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity(clienteService.salvarCliente(cliente), HttpStatus.OK);
    }

    @ApiOperation(value = "Lista todos os clientes", response = ResponseEntity.class)
    @GetMapping
    public ResponseEntity listarClientes() {
        return new ResponseEntity(clienteService.listarClientes(), HttpStatus.OK);
    }

    @ApiOperation(value = "Altera um cliente existente", response = ResponseEntity.class)
    @PatchMapping
    public ResponseEntity alterarCliente(@RequestBody Cliente cliente) {
        clienteService.alterarCliente(cliente);
        return new ResponseEntity(cliente.getId(), HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta um cliente", response = ResponseEntity.class)
    @DeleteMapping
    public ResponseEntity deleteCliente(@RequestParam Long id) {
        clienteService.excluirCliente(id);
        return new ResponseEntity("ID: " + id + " Excluido.", HttpStatus.OK);
    }

    @ApiOperation(value = "Busca um cliente pelo ID", response = ResponseEntity.class)
    @RequestMapping(value = "buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarClienteID(@RequestParam("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Cliente> clienteOptional = clienteService.buscarClienteID(id);
        if (clienteOptional.isEmpty()) {
            return new ResponseEntity("Cliente nao encontrada", HttpStatus.NOT_FOUND);
        }
        Cliente cliente = clienteOptional.get();
        ClienteDTO clienteDTO = mapper.convertValue(cliente, ClienteDTO.class);

        return new ResponseEntity(clienteDTO, HttpStatus.OK);
    }

}
