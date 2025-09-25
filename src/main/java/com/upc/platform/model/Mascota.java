package com.upc.platform.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private Dueno dueno;
    private Clinica clinica;

    public Mascota(String nombre, String especie, String raza, int edad, Dueno dueno,
                   Clinica clinica) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.dueno = dueno;
        this.clinica = clinica;
    }
    // Getters y setters
}