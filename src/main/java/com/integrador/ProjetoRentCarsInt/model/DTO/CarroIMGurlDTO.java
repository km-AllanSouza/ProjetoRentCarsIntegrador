package com.integrador.ProjetoRentCarsInt.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.ProjetoRentCarsInt.model.CarroIMGurl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class CarroIMGurlDTO {

    private Long id;

    private String bigIMGurl;

    private String smallIMGurl1;

    private String smallIMGurl2;

    private String smallIMGurl3;

    private String smallIMGurl4;

    public CarroIMGurlDTO(CarroIMGurl carroIMGurl){
        this.id = carroIMGurl.getId();
        this.bigIMGurl = carroIMGurl.getBigIMGurl();
        this.smallIMGurl1 = carroIMGurl.getSmallIMGurl1();
        this.smallIMGurl2 = carroIMGurl.getSmallIMGurl2();
        this.smallIMGurl3 = carroIMGurl.getSmallIMGurl3();
        this.smallIMGurl4 = carroIMGurl.getSmallIMGurl4();
    }

}
