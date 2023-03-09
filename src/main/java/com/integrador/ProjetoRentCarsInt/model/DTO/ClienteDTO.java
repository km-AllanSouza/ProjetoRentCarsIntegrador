package com.integrador.ProjetoRentCarsInt.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.ProjetoRentCarsInt.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class ClienteDTO {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private String admin;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.admin = cliente.getAdmin();
    }

}
