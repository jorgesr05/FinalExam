package com.examen.tercer_intento.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cursos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curso extends ModeloBase{

    @NotNull
    private String curso;

    @NotNull
    private String instructor;

    @NotNull
    @Positive
    private Integer capacidad;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")

}
