package com.integrador.ProjetoRentCarsInt.repository;


import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAluguelRepository extends JpaRepository<Aluguel, Long> {
}
