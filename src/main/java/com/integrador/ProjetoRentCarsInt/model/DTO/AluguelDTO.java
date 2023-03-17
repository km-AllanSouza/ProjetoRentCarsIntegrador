package com.integrador.ProjetoRentCarsInt.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import com.integrador.ProjetoRentCarsInt.model.Carro;
import com.integrador.ProjetoRentCarsInt.model.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class AluguelDTO {

    private Long id;

    private Cliente idCliente;

    private Carro idCarro;

    @DateTimeFormat(pattern="hh:mm:ss")
    private Time hr_Saida;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dt_Saida;

    @DateTimeFormat(pattern="hh:mm:ss")
    private Time hr_Entrega;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date dt_Entrega;

    public AluguelDTO(Aluguel aluguel){
        this.id = aluguel.getId();
        this.idCliente = aluguel.getIdCliente();
        this.idCarro = aluguel.getIdCarro();
        this.hr_Saida = aluguel.getHr_Saida();
        this.dt_Saida = aluguel.getDt_Saida();
        this.hr_Entrega = aluguel.getHr_Entrega();
        this.dt_Entrega = aluguel.getDt_Entrega();

    }

}
