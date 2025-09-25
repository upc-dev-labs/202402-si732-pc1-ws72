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

    @Test
    @DisplayName("Debe encontrar todos los dueños y contar correctamente")
    void testEncontrarTodosYContar() {
        // Arrange
        Dueno dueno1 = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");
        Dueno dueno2 = new Dueno("Maria", "Gomez", "987654321", "Avenida Siempre Viva 456");
        duenoRepository.save(dueno1);
        duenoRepository.save(dueno2);

        // Act
        long total = duenoRepository.count();

        // Assert
        assertEquals(2, total);
        assertEquals(2, duenoRepository.findAll().size());
    }

    @Test
    @DisplayName("Debe actualizar un dueño existente correctamente")
    void testActualizarExistente() {
        // Arrange
        Dueno dueno = new Dueno("Juan", "Perez", "123456789", "Calle Falsa 123");
        Dueno duenoGuardado = duenoRepository.save(dueno);

        // Act
        duenoGuardado.setDireccion("Nueva Direccion 456");
        Dueno duenoActualizado = duenoRepository.save(duenoGuardado);
        Dueno duenoLeido = duenoRepository.findById(duenoActualizado.getId()).orElseThrow();

        // Assert
        assertEquals("Nueva Direccion 456", duenoLeido.getDireccion());
    }
}