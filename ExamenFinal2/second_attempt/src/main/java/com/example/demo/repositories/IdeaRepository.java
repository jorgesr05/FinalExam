package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{

    //BUSQUEDA DE LAS IDEAS
    List<Idea> findAll();

    //BUSQUEDA POR ID
    Optional<Idea> findById(Long id);
    
    
}
