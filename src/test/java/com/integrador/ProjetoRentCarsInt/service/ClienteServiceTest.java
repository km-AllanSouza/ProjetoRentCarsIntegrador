package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Cliente;
import com.integrador.ProjetoRentCarsInt.model.DTO.ClienteDTO;
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
class ClienteServiceTest {

    @Autowired
    ClienteService clienteServiceTeste;

    static Cliente clienteTeste;

    @BeforeEach
    void doBefore(){

        clienteTeste = new Cliente(
                "usuario",
                "teste",
                "usuarioTeste@gmail.com",
                "senhaTeste",
                "nao"
        );
    }

    @Test
    void salvarCliente() {

        clienteTeste = clienteServiceTeste.salvarCliente(clienteTeste);
        assertTrue(clienteTeste.getId() > 0);

    }

    @Test
    void listarClientes() {

        Cliente clienteTeste2 = new Cliente(
                "usuario 2",
                "teste",
                "usuarioTeste2@gmail.com",
                "senhaTeste",
                "sim"
        );

        clienteServiceTeste.salvarCliente(clienteTeste2);
        clienteTeste = clienteServiceTeste.salvarCliente(clienteTeste);

        List<ClienteDTO> result = clienteServiceTeste.listarClientes();
        assertTrue( result.size() > 1);
    }

    @Test
    void alterarCliente() {

        clienteTeste = clienteServiceTeste.salvarCliente(clienteTeste);

        String novoNome = "novousuario";
        String novoSobreN = "novosobrenome";

        clienteTeste.setNome(novoNome);
        clienteTeste.setSobrenome(novoSobreN);
        clienteServiceTeste.alterarCliente(clienteTeste);

        Optional<Cliente> result = clienteServiceTeste.buscarClienteID(clienteTeste.getId());
        Cliente clienteAlterado = result.get();
        assertSame(clienteAlterado.getNome(),novoNome);
        assertSame(clienteAlterado.getSobrenome(),novoSobreN);

    }

    @Test
    void excluirCliente() {

        clienteTeste = clienteServiceTeste.salvarCliente(clienteTeste);
        clienteServiceTeste.excluirCliente(clienteTeste.getId());

        assertFalse(clienteServiceTeste.buscarClienteID(clienteTeste.getId()).isPresent());

    }

    @Test
    void buscarClienteID() {

        clienteTeste = clienteServiceTeste.salvarCliente(clienteTeste);

        assertTrue(clienteServiceTeste.buscarClienteID(clienteTeste.getId()).isPresent());

    }
}