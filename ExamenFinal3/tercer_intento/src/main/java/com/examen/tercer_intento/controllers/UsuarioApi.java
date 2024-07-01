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

import com.examen.tercer_intento.models.Usuario;
import com.examen.tercer_intento.services.UsuarioServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioApi {

    private final UsuarioServices usuarioServices;

    //Nombrar registros
    @GetMapping("")
    public List<Usuario> mostrarRegistro(){
        return usuarioServices.mostrarTodo();
    }

    //Buscar registro por id
    @GetMapping("/{id}")
    public Usuario encontrarUsuario(@PathVariable("id") Long id){
        return usuarioServices.encontrarId(id);
    }
    
    //Crear registro
    @PostMapping()
    public Usuario crearUsuario(@RequestParam("nombre")String nombre, @RequestParam("correo") String correo, @RequestParam("clave") String clave, @RequestParam("confirClave") String confirClave){
        Usuario usuario = new Usuario(nombre, correo, clave, confirClave);
        return usuarioServices.crearUsuario(usuario);

    }

    //Actualizar registro
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") Long id,@RequestParam("nombre")String nombre, @RequestParam("correo") String correo, @RequestParam("clave") String clave, @RequestParam("confirClave") String confirClave){
        Usuario usuario = usuarioServices.encontrarId(id);
        usuario.setNombre(nombre);
        return usuarioServices.actualizarUsuario(usuario);
    }

    //Eliminar registro
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id){
        usuarioServices.eliminarUsuario(id);
    }

}