package com.examen.tercer_intento.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.tercer_intento.models.Curso;
import com.examen.tercer_intento.models.Usuario;
import com.examen.tercer_intento.services.CursoServices;
import com.examen.tercer_intento.services.UsuarioServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
public class CursoApi {

    private final CursoServices cursoServices;
    private final UsuarioServices usuarioServices;
    

    //Nombrar curso
    @GetMapping("")
    public List<Curso> mostrarCurso() {
        return cursoServices.mostrarTodo();
    }

    //Buscar curso por id
    @GetMapping("/{id}")
    public Curso encontrarCurso(@PathVariable("id") Long id){
        return cursoServices.encontrarId(id);
    }

    //Crear curso
    @PostMapping("")
    public Curso crearCurso(@RequestParam("curso") String curso, @RequestParam("instructor") String instructor, @RequestParam("capacidad")Integer capacidad, @RequestParam("usuarioId") Long usuarioId){
        Usuario encontrarUsuario = usuarioServices.encontrarId(usuarioId);
        if(encontrarUsuario == null){
            return null;
        }
        Curso cursos = new Curso(curso, instructor, capacidad, encontrarUsuario);
        return cursoServices.crearCurso(cursos);
    }

    //Actualizar curso
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable("id") Long id,@RequestParam("curso") String curso, @RequestParam("instructor") String instructor, @RequestParam("capacidad")Integer capacidad, @RequestParam("usuarioId") Long usuarioId){
        Usuario encontrarUsuario = usuarioServices.encontrarId(usuarioId);
        if(encontrarUsuario == null){
            return null;
        }
        Curso cursos = cursoServices.encontrarId(id);
        cursos.setCurso(curso);
        cursos.setUsuario(encontrarUsuario);
        return cursoServices.actualizarCurso(cursos);
    }


    //Eliminar curso
    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable("id") Long id){
        cursoServices.eliminarCurso(id);
    }




}
