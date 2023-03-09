package com.integrador.ProjetoRentCarsInt.repository;

import com.integrador.ProjetoRentCarsInt.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
