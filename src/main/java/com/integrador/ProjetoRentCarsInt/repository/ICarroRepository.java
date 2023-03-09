package com.integrador.ProjetoRentCarsInt.repository;

import com.integrador.ProjetoRentCarsInt.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro,Long> {
}
