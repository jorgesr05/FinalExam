package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Idea;
import com.example.demo.repositories.IdeaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IdeaServices {
    private final IdeaRepository ideaRepository;

    //BUSQUEDA LISTA DE IDEAS
    public List<Idea> showAll(){
        return ideaRepository.findAll();
    }

    //BUSQUEDA POR ID
    public Idea findId(Long id){
        return ideaRepository.findById(id).orElse(null);
    }

    //CREAR UN ID
    public Idea createIdea(Idea register){
        return ideaRepository.save(register);
    }

    //ACTUALIZAR ID
    public Idea upDateIdea(Idea register){
        return ideaRepository.save(register);
    }

    //ELIMINAR ID
    public void deleteIdea(Long id){
        ideaRepository.deleteById(id);
    }



    
}
