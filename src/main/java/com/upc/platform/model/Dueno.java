package com.upc.platform.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
public class Dueno {
    // Getters y setters

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Dueno(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}