package com.integrador.ProjetoRentCarsInt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="tb_categorias")

public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Categorias_IDs")
    private Long id;

    private int qualificacao;

    private String descricao;

    private String url;

    public Categorias(int qualificacao, String descricao, String url) {
        this.qualificacao = qualificacao;
        this.descricao = descricao;
        this.url = url;
    }
}