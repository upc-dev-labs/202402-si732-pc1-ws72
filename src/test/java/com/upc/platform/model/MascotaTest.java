package com.upc.platform.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Casos de prueba para la clase Mascota")
class MascotaTest {

    @Test
    @DisplayName("Debe crear una mascota con valores correctos usando el constructor")
    void testAgregarMascotaSinClinica() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");
        String nombre = "Firulais";
        String especie = "Perro";
        String raza = "Labrador";
        int edad = 3;
        Clinica clinica = null;

        // Act
        Mascota mascota = new Mascota(nombre, especie, raza, edad, dueno, clinica);

        // Assert
        assertEquals(nombre, mascota.getNombre());
        assertEquals(especie, mascota.getEspecie());
        assertEquals(raza, mascota.getRaza());
        assertEquals(edad, mascota.getEdad());
        assertEquals(dueno, mascota.getDueno());
        assertNull(mascota.getClinica());
    }
}