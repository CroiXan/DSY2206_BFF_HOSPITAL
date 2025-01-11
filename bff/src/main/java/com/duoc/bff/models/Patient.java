package com.duoc.bff.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Patient {
    private int id;

    private String rut;

    private String password;

    private String nombre;

    private String apellidos;

    private String email;

    private LocalDate bornDate; 
}
