package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long>{

    //BUSCAR TODOS LOS REGISTROS
    List<Register> findAll();
    
    //BUSCAR POR ID
    Optional<Register> findById(Long id);
    
}
