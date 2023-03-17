package com.integrador.ProjetoRentCarsInt.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.integrador.ProjetoRentCarsInt.model.Carro;
import com.integrador.ProjetoRentCarsInt.model.Categorias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CarroDTO {

    private Long id;

    private String modelo;

    private String marca;

    private String cor;

    private Categorias idCategoria;

    public CarroDTO(Carro carro){
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.cor = carro.getCor();
        this.idCategoria = carro.getIdCategoria();

    }

}
