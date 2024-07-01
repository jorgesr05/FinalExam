package com.examen.tercer_intento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.tercer_intento.models.Usuario;
import com.examen.tercer_intento.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;

    //Buscar todos los usuarios
    public List<Usuario> mostrarTodo(){
        return usuarioRepository.findAll();
    }

    //Buscar por ID
    public Usuario encontrarId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    //Crear un registro
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Actualizar registro
    public Usuario actualizarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    //Eliminar registro
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
    
}
