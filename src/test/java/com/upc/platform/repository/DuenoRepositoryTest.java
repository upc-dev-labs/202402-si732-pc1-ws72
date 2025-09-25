package com.upc.platform.repository;

import com.upc.platform.model.Dueno;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Carga solo la capa de persistencia
@ActiveProfiles("h2")
@DisplayName("Pruebas de componentes JPA de Dueño")
class DuenoRepositoryTest {
    @Autowired
    private DuenoRepository duenoRepository;

    @Test
    @DisplayName("Debe guardar y buscar un dueño por ID correctamente")
    void testGuardarYBuscarPorId() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");

        // Act
        Dueno duenoGuardado = duenoRepository.save(dueno);
        Optional<Dueno> duenoEncontrado = duenoRepository.findById(duenoGuardado.getId());

        // Assert
        assertNotNull(duenoGuardado.getId());
        assertTrue(duenoEncontrado.isPresent());
        assertEquals("Juan", duenoEncontrado.get().getNombre());
        assertEquals("Perez", duenoEncontrado.get().getApellido());
    }
}