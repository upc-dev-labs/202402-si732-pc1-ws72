package com.upc.platform.service;

import com.upc.platform.model.Dueno;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("sql")
class DuenoServiceTest {
    @Autowired
    private DuenoService duenoService;

    @Test
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
}