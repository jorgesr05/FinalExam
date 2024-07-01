package com.examen.tercer_intento.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.tercer_intento.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    //Buscar los registros
    List<Usuario> findAll();

    //Buscar por id
    Optional<Usuario> findById(Long id);

}
