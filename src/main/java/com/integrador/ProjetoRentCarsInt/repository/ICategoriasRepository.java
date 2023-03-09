package com.integrador.ProjetoRentCarsInt.repository;

import com.integrador.ProjetoRentCarsInt.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categorias,Long> {
}
