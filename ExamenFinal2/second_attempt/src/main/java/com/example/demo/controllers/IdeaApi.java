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
import com.example.demo.models.Idea;
import com.example.demo.services.RegisterServices;
import com.example.demo.services.IdeaServices;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ideas")
@AllArgsConstructor
public class IdeaApi {

    private final IdeaServices ideaServices;
    private final RegisterServices registerServices;

    //NOMBRAR ID'S
    @GetMapping("")
    public List<Idea> listIdea(){
        return ideaServices.showAll();
    }

    //BUSCAR IDEA POR ID
    @GetMapping("/{id}")
    public Idea findIdea(@PathVariable("id") Long id){
        return ideaServices.findId(id);
    }

    //CREAR ID
    @PostMapping("")
    public Idea createIdea(@RequestParam("idea") String idea,@RequestParam("created_by") String created_by, @RequestParam("likes") String likes, @RequestParam("action") String action, @RequestParam("registerId") Long registerId){
        Register findRegister = registerServices.findId(registerId);
        if(findRegister == null){
            return null;
        }
        Idea ideas = new Idea(idea,created_by,likes,action,findRegister);
        return ideaServices.createIdea(ideas);
    }

    //ACTUALIZAR ID
    @PutMapping("/{id}")
    public Idea upDateIdea(@PathVariable("id") Long id,@RequestParam("idea") String idea,@RequestParam("created_by") String created_by, @RequestParam("likes") String likes, @RequestParam("action") String action, @RequestParam("registerId") Long registerId){
        Register findRegister = registerServices.findId(registerId);
        if(findRegister == null){
            return null;
        }
        Idea ideas = ideaServices.findId(id);
        ideas.setIdea(idea);
        ideas.setRegister(findRegister);
        return ideaServices.upDateIdea(ideas);
    }

    //ELIMINAR ID
    @DeleteMapping("/{id}")
    public void deleteIdea(@PathVariable("id")Long id){
        ideaServices.deleteIdea(id);
    }
    
    
}
