package com.integrador.ProjetoRentCarsInt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_carros")

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Carros_IDs")
    private Long id;

    private String modelo;

    private String marca;

    private String cor;


    @JoinColumn(name = "Categorias_IDs")
    private Long idCategoria;

    public Carro(String modelo, String marca, String cor, Long idCategoria) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }
}