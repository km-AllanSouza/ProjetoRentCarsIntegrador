package com.integrador.ProjetoRentCarsInt.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

public class CategoriasDTO {

    private Long id;

    private int qualificacao;

    private String descricao;

    private String url;

    public CategoriasDTO(Categorias categorias){

        this.id = categorias.getId();
        this.qualificacao = categorias.getQualificacao();
        this.descricao = categorias.getDescricao();
        this.url = categorias.getUrl();
    }

}
