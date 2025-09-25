package com.upc.platform.service;

import com.upc.platform.model.Dueno;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("mysql")
class DuenoServiceTest {
    @Autowired
    private DuenoService duenoService;

    @Test
    @DisplayName("Debe crear e insertar un dueño correctamente")
    void testCrearEInsertarDueno() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");

        // Act
        Dueno duenoCreado= duenoService.crearDueno(dueno);

        // Assert
        assertNotNull(duenoCreado);
        assertNotNull(duenoCreado.getId());
        assertEquals("Juan", duenoCreado.getNombre());
        assertEquals("Perez", duenoCreado.getApellido());
    }

    @Test
    @DisplayName("Debe eliminar un dueño por su ID correctamente")
    void testEliminarDuenoPorId() {
        // Arrange
        Integer duenoId = 3;

        // Act
        duenoService.eliminar(duenoId);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            duenoService.obtenerPorId(duenoId);
        });
    }

    @Test
    @DisplayName("Debe eliminar un dueño por su ID correctamente")
    void testEliminarDuenoInsertadoPorId() {
        // Arrange
        Dueno dueno = new Dueno("Maria", "Lopez", "987654321", "Av. Siempre Viva 456");
        Dueno duenoCreado = duenoService.crearDueno(dueno);
        Integer idDueno = duenoCreado.getId();

        // Act
        duenoService.eliminar(idDueno);

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> duenoService.obtenerPorId(idDueno),
                "Después de eliminar, no debería encontrarse");
    }

    @Test
    @DisplayName("Integración: regla de negocio — nombre/apellido obligatorios (AAA)")
    void validaReglaDeNegocioEnCrear() {
        // Arrange
        Dueno invalido = new Dueno("", "", "999", "Sin nombre");

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            duenoService.crearDueno(invalido);
        });

        // Assert
        assertEquals("Nombre y apellido son obligatorios", exception.getMessage());
    }
}