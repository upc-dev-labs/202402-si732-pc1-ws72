package com.upc.platform.service;

import com.upc.platform.model.Dueno;
import com.upc.platform.repository.DuenoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService {

    private final DuenoRepository duenoRepository;

    public DuenoService(DuenoRepository duenoRepository) {
        this.duenoRepository = duenoRepository;
    }

    @Transactional
    public Dueno crearDueno(Dueno dueno) {
        if (dueno.getNombre() == null || dueno.getNombre().isBlank()
                || dueno.getApellido() == null || dueno.getApellido().isBlank()) {
            throw new IllegalArgumentException("Nombre y apellido son obligatorios");
        }
        return duenoRepository.save(dueno);
    }

    @Transactional
    public Dueno obtenerPorId(Integer id) {
        return duenoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dueño no encontrado: " + id));
    }

    @Transactional
    public Dueno actualizarDireccion(Integer id, String nuevaDireccion) {
        Dueno d = obtenerPorId(id);
        d.setDireccion(nuevaDireccion);
        return duenoRepository.save(d);
    }

    @Transactional
    public void eliminar(Integer id) {
        if (!duenoRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe el dueño: " + id);
        }
        duenoRepository.deleteById(id);
    }

    @Transactional
    public List<Dueno> listar() {
        return duenoRepository.findAll();
    }
}
