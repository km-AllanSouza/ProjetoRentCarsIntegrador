package com.integrador.ProjetoRentCarsInt.repository;

import com.integrador.ProjetoRentCarsInt.model.CarroIMGurl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroIMGurlRepository extends JpaRepository<CarroIMGurl,Long> {
}
