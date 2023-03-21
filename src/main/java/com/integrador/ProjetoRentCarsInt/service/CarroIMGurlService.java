package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.CarroIMGurl;
import com.integrador.ProjetoRentCarsInt.model.DTO.CarroIMGurlDTO;
import com.integrador.ProjetoRentCarsInt.repository.ICarroIMGurlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroIMGurlService {

    @Autowired
    ICarroIMGurlRepository carroIMGurlRepository;

    public CarroIMGurl salvarCarrosIMG( CarroIMGurl carroIMGurl){
        return carroIMGurlRepository.save(carroIMGurl);
    }

    public List<CarroIMGurlDTO> listarCarrosIMG(){
        List<CarroIMGurl> carroIMGlist = carroIMGurlRepository.findAll();
        List<CarroIMGurlDTO> carroIMGlistDTOlist = new ArrayList<>();

        for (CarroIMGurl e : carroIMGlist){
            carroIMGlistDTOlist.add(new CarroIMGurlDTO(e));
        }
        return carroIMGlistDTOlist;
    }

    public void alterarCarroIMG(CarroIMGurl carroIMGurl){
        carroIMGurlRepository.save(carroIMGurl);
    }

    public void excluirCarroIMG(Long id){
        carroIMGurlRepository.deleteById(id);
    }

    public Optional<CarroIMGurl> buscarCarroIMGid(Long id){
        return carroIMGurlRepository.findById(id);
    }

}
