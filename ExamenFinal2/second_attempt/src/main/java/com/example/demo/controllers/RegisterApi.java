package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Register;
import com.example.demo.services.RegisterServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
public class RegisterApi {

    private final RegisterServices registerServices;

    //NOMBRAR REGISTROS
    @GetMapping("")
    public List<Register> showRegister(){
        return registerServices.showAll();
    }

    //BUSCAR REGISTRO POR ID
    @GetMapping("/{id}")
    public Register findRegister(@PathVariable("id") Long id){
        return registerServices.findId(id);
    }

    //CREAR REGISTRO
    @PostMapping("")
    public Register createRegister(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("conf_password") String conf_password){
        Register register = new Register(name,email, password,conf_password,null);
        return registerServices.createRegister(register);
             
    }

    //ACTUALIZAR REGISTRO
    @PutMapping("/{id}")
    public Register upDateRegister(@PathVariable("id") Long id,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("conf_password") String conf_password){
        Register register = registerServices.findId(id);
        register.setName(name);
        return registerServices.upDateRegister(register);
    }

    @DeleteMapping("/{id}")
    public void deleteRegister(@PathVariable("id") Long id){
        registerServices.deleteRegister(id);
    }
    
}
