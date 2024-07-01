package com.examen.tercer_intento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends ModeloBase{

    @NotNull
    @Size(min = 3)
    private String nombre;

    @NotNull
    @Email
    private String correo;

    @Size(min = 8, max = 8)
    @NotEmpty
    private String clave;
    
    @Size(min = 8, max = 8)
    @NotEmpty
    private String confirClave;
    
}
