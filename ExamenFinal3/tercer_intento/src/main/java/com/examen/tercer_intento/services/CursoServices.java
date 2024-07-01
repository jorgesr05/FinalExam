package com.examen.tercer_intento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.tercer_intento.models.Curso;
import com.examen.tercer_intento.repositories.CursoRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CursoServices {
    private final CursoRepository cursoRepository;

    //Busqueda lista de cursos
    public List<Curso> mostrarTodo(){
        return cursoRepository.findAll();
    }

    //Busqueda por curso
    public Curso encontrarId(Long id){
        return cursoRepository.findById(id).orElse(null);
    }

    //Crear un curso
    public Curso crearCurso(Curso usuario){
    return cursoRepository.save(usuario);
    }
    
    //Actualizar curso
    public Curso actualizarCurso(Curso usuario){
        return cursoRepository.save(usuario);
    }
    
    //Eliminar curso
    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }
}
