package com.integrador.ProjetoRentCarsInt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluguel")

public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Aluguel_IDs")
    private Long id;
    @JoinColumn(name="Clientes_IDs")
    private Long idCliente;

    @JoinColumn(name="Carros_IDs")
    private Long idCarro;

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

    public Aluguel(Long idCliente, Long idCarro, Time hr_Saida, Date dt_Saida, Time hr_Entrega, Date dt_Entrega) {
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.hr_Saida = hr_Saida;
        this.dt_Saida = dt_Saida;
        this.hr_Entrega = hr_Entrega;
        this.dt_Entrega = dt_Entrega;
    }
}
