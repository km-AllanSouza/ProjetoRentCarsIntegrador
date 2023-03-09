package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Carro;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroDTO;
import com.integrador.ProjetoRentCarsInt.repository.ICarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarroService {

    @Autowired
    ICarroRepository carroRepository;

    public Carro salvarCarros(Carro carro){
        return carroRepository.save(carro);
    }

    public List<CarroDTO> listarCarros(){
        List<Carro> carroList = carroRepository.findAll();
        List<CarroDTO> carroDTOList = new ArrayList<>();

        for (Carro e : carroList){
            carroDTOList.add(new CarroDTO(e));
        }
        return carroDTOList;
    }

    public void alterarCarro (Carro carro){
        carroRepository.save(carro);
    }

    public void excluirCarro(Long id){
        carroRepository.deleteById(id);
    }

    public Optional<Carro> buscarCarroID(Long id){
        return carroRepository.findById(id);
    }

}
