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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorias_id", referencedColumnName = "Categorias_IDs")
    private Categorias idCategoria;

    @ManyToOne
    @JoinColumn(name = "carroIMGurl_id",referencedColumnName = "carrosIMGurl_IDs")
    private CarroIMGurl idCarroIMGurl;

    public Carro(String modelo, String marca, String cor, Categorias idCategoria) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.idCategoria = idCategoria;
    }

    public Carro(String modelo, String marca, String cor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }
}