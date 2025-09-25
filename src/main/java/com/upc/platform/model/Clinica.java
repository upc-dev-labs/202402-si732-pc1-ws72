package com.upc.platform.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Clinica {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Mascota> mascotas;

    public Clinica(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    // Getters y setters
}