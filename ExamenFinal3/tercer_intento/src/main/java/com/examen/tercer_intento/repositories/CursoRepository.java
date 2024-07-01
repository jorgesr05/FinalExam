package com.examen.tercer_intento.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.tercer_intento.models.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long>{

    //Búsqueda de cursos
    List<Curso> findAll();

    //Búsqueda por id
    Optional<Curso> findById(Long id);
    
}
