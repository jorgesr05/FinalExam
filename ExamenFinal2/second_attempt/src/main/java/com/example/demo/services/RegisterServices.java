package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Register;
import com.example.demo.repositories.RegisterRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterServices {
    private final RegisterRepository registerRepository;

    //BUSCAR TODOS LOS REGISTROS
    public List<Register> showAll(){
        return registerRepository.findAll();
    }

    //BUSCAR POR ID
    public Register findId(Long id){
        return registerRepository.findById(id).orElse(null);
    }

    //CREAR UN REGISTRO
    public Register createRegister(Register register){
        return registerRepository.save(register);
    }

    //ACTUALIZAR REGISTRO
    public Register upDateRegister(Register register){
        return registerRepository.save(register);
    }

    //ELIMINAR REGISTRO
    public void deleteRegister(Long id){
        registerRepository.deleteById(id);
    }
    
}
