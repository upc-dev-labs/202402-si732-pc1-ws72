package com.upc.platform.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Casos de prueba para la clase Clinica")
class ClinicaTest {
    @Test
    @DisplayName("Debe registrar una mascota en la clínica correctamente")
    void testRegistrarMascotaEnClinica() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");
        Mascota mascota = new Mascota("Firulais", "Perro", "Labrador", 3, dueno, null);
        Clinica clinica = new Clinica("Clinica Veterinaria", "Av. Siempre Viva 456", "987654321");

        // Act
        clinica.registrarMascota(mascota);

        // Assert
        assertTrue(clinica.getMascotas().contains(mascota));
        assertEquals(clinica, mascota.getClinica());
    }
}