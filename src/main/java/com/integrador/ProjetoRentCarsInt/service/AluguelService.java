package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Aluguel;
import com.integrador.ProjetoRentCarsInt.model.DTO.AluguelDTO;
import com.integrador.ProjetoRentCarsInt.repository.IAluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    IAluguelRepository aluguelRepository;

    public Aluguel salvarAluguel(Aluguel aluguel){
        return aluguelRepository.save(aluguel);
    }

    public List<AluguelDTO> listarAluguel(){
        List<Aluguel> aluguelList = aluguelRepository.findAll();
        List<AluguelDTO> aluguelDTOList = new ArrayList<>();

        for (Aluguel e : aluguelList){
            aluguelDTOList.add(new AluguelDTO(e));
        }
        return aluguelDTOList;
    }

    public void alterarAluguel (Aluguel aluguel){
        aluguelRepository.save(aluguel);
    }

    public void excluirAluguel(Long id){
        aluguelRepository.deleteById(id);
    }

    public Optional<Aluguel> buscarAluguelID(Long id){
        return aluguelRepository.findById(id);
    }


}
