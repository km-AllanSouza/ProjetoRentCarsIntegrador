package com.integrador.ProjetoRentCarsInt.service;

import com.integrador.ProjetoRentCarsInt.model.Categorias;
import com.integrador.ProjetoRentCarsInt.model.DTO.CategoriasDTO;
import com.integrador.ProjetoRentCarsInt.repository.ICategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    ICategoriasRepository categoriasRepository;

    public Categorias salvarCategorias(Categorias categorias){
        return categoriasRepository.save(categorias);
    }

    public List<CategoriasDTO> listarCategorias(){
        List<Categorias> categoriasList = categoriasRepository.findAll();
        List<CategoriasDTO> categoriasDTOList = new ArrayList<>();

        for (Categorias e : categoriasList){
            categoriasDTOList.add(new CategoriasDTO(e));
        }
        return categoriasDTOList;
    }

    public void alterarCategorias (Categorias categorias){
        categoriasRepository.save(categorias);
    }

    public void excluirCategoria(Long id){
        categoriasRepository.deleteById(id);
    }

    public Optional<Categorias> buscarCategoriasID(Long id){
        return categoriasRepository.findById(id);
    }

}
