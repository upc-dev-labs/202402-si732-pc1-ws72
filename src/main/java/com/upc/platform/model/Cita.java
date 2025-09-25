package com.upc.platform.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Cita {
    private Mascota mascota;
    private LocalDateTime fecha;
    private String motivo;
    private String estado; // "Reservada", "Cancelada", "Cerrada"
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaCancelacion;
    private LocalDateTime fechaCierre;

    public Cita(Mascota mascota, LocalDateTime fecha, String motivo) {
        this.mascota = mascota;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = "Reservada";
        this.fechaReserva = LocalDateTime.now();
        System.out.println("Cita reservada para " + mascota.getNombre() +
                " el " + fecha + " por motivo: " + motivo + ". Fecha de reserva: " + fechaReserva);
    }
    public void reservar(LocalDateTime fechaReserva) {
        if (ChronoUnit.MINUTES.between(LocalDateTime.now(), this.fecha) >= 30) {
            this.estado = "Reservada";
            this.fechaReserva = fechaReserva;
            System.out.println("La cita ha sido reservada para " + mascota.getNombre() +
                    " en " + fechaReserva + ".");
        } else {
            System.out.println("No se puede reservar la cita. Debe hacerse al menos 30 minutos antes de la fecha programada.");
        }
    }
    public void cancelar(LocalDateTime fechaCancelacion) {
        if (ChronoUnit.HOURS.between(LocalDateTime.now(), this.fecha) >= 3) {
            this.estado = "Cancelada";
            this.fechaCancelacion = fechaCancelacion;
            System.out.println("La cita ha sido cancelada para " + mascota.getNombre() +
                    " en " + fechaCancelacion + ".");
        } else {
            System.out.println("No se puede cancelar la cita. Debe hacerse al menos 3 horas antes de la fecha programada.");
        }
    }
    public void cerrar(LocalDateTime fechaCierre) {
        this.estado = "Cerrada";
        this.fechaCierre = fechaCierre;
        System.out.println("La cita ha sido cerrada para " + mascota.getNombre() +
                " en " + fechaCierre + ".");
    }
    // Getters y setters
}