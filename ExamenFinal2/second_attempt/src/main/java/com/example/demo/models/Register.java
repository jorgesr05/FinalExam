package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
@Table(name = "registros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Register extends BaseModel{
    

    @NotNull
    @Size(min = 2)
    private String name;
    
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max= 8)
    @NotEmpty
    private String password;

    @NotNull
    @Size(min = 8, max= 8)
    @NotEmpty
    private String conf_password;

    @JsonManagedReference
    @OneToMany(mappedBy = "register", fetch = FetchType.LAZY)
    private List<Idea> ideas;
    

}
