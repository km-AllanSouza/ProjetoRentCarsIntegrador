package com.integrador.ProjetoRentCarsInt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_carrosIMGurl")
public class CarroIMGurl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrosIMGurl_IDs")
    private Long id;

    private String bigIMGurl;

    private String smallIMGurl1;

    private String smallIMGurl2;

    private String smallIMGurl3;

    private String smallIMGurl4;

    public CarroIMGurl(String bigIMGurl, String smallIMGurl1, String smallIMGurl2, String smallIMGurl3, String smallIMGurl4) {
        this.bigIMGurl = bigIMGurl;
        this.smallIMGurl1 = smallIMGurl1;
        this.smallIMGurl2 = smallIMGurl2;
        this.smallIMGurl3 = smallIMGurl3;
        this.smallIMGurl4 = smallIMGurl4;
    }
}
