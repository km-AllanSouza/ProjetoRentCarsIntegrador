package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Cliente;
import com.integrador.ProjetoRentCarsInt.model.DTO.ClienteDTO;
import com.integrador.ProjetoRentCarsInt.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ClienteService {

    @Autowired
    IClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<ClienteDTO> listarClientes(){
        List<Cliente> clienteList = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();

        for (Cliente e : clienteList){
            clienteDTOList.add(new ClienteDTO(e));
        }
        return clienteDTOList;
    }

    public void alterarCliente (Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarClienteID(Long id){
        return clienteRepository.findById(id);
    }
}
