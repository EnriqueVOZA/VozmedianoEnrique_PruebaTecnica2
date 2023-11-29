
package com.hab.javaavanzado.persistencia;

import com.hab.javaavanzado.logica.Ciudadano;
import com.hab.javaavanzado.logica.Turno;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudadaJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();

    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadaJPA.create(ciudadano);
    }

    public List<Turno> listarTurnos() {
        List<Turno> turnoslistado = turnoJPA.findTurnoEntities();

        return turnoslistado;
    }

    public List<Turno> listarTurnosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Turno> turnoslistado = turnoJPA.findTurnoEntities();

        // Filtrar la lista de turnos por fecha
        if (fechaInicio != null && fechaFin != null) {
            turnoslistado = turnoslistado.stream()
                    .filter(turno -> turno.getFecha().isAfter(fechaInicio.minusDays(1)) && turno.getFecha().isBefore(fechaFin.plusDays(1)))
                    .collect(Collectors.toList());
        }

        return turnoslistado;
    }
    
    public List<Turno> buscarFechaEstado (LocalDate fecha, boolean estado) {
        List<Turno> turnosFechaEstado = turnoJPA.findTurnoEntities()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha) && turno.isEstado()== estado)
                .toList();
        return turnosFechaEstado;
    }
    
    public List<Turno> buscarFecha (LocalDate fecha) {
        List<Turno> turnosFechaEstado = turnoJPA.findTurnoEntities()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .toList();
        return turnosFechaEstado;
    }
    
    
   public Turno turnoId(Long id){
       return turnoJPA.findTurno(id);
   }
   
   public void cambiarEstado(Turno turno) throws Exception{
       turnoJPA.edit(turno);
       
   }
   
   
}
