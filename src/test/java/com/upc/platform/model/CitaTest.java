package com.upc.platform.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Casos de prueba para la clase Cita")
class CitaTest {
    @Test
    @DisplayName("Debe crear una cita con valores correctos usando el constructor")
    void testCrearCitaConValoresCorrectos() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");
        Mascota mascota = new Mascota("Firulais", "Perro", "Labrador", 3, dueno, null);
        Clinica clinica = new Clinica("Clinica Veterinaria", "Av. Siempre Viva 456", "987654321");
        LocalDateTime fecha = LocalDateTime.of(2024, 6, 15, 10, 30);
        String motivo = "Consulta general";

        // Act
        Cita cita = new Cita(mascota, fecha, motivo);
        String estadoEsperado = "Reservada";

        // Assert
        assertEquals(mascota, cita.getMascota());
        assertEquals(fecha, cita.getFecha());
        assertEquals(motivo, cita.getMotivo());
        assertEquals(estadoEsperado, cita.getEstado());
        assertNotNull(cita.getFechaReserva());
    }
}