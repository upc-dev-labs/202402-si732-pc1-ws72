package com.upc.platform.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// SOBRE AAA:
// Arrange (preparación): se configuran los objetos y valores necesarios para la prueba.
// Act (acción): se ejecuta el metodo o funcionalidad que se está probando.
// Assert (afirmación): se verifican los resultados obtenidos contra los resultados esperados
@DisplayName("Casos de prueba unitaria para la clase Dueno")
class DuenoTest {

    @Test
    @DisplayName("Debe crear un dueño con valores correctos usando el constructor")
    void testConstructorAndGetters() {
        // Arrange (preparación)
        String nombre = "Juan";
        String apellido = "Perez";
        String telefono = "123456789";
        String direccion = "Calle Falsa 123";

        // Act
        Dueno dueno = new Dueno(nombre, apellido, telefono, direccion);

        // Assert
        assertEquals(nombre, dueno.getNombre());
        assertEquals(apellido, dueno.getApellido());
        assertEquals(telefono, dueno.getTelefono());
        assertEquals(direccion, dueno.getDireccion());
    }
}