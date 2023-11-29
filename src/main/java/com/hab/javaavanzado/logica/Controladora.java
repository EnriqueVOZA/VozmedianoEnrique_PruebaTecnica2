
package com.hab.javaavanzado.logica;

import com.hab.javaavanzado.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;



public class Controladora {  
   
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearTurno(Turno turno){
        controlPersis.crearTurno(turno);
    }
    
    public void crearCiudadano (Ciudadano ciudadano){
        controlPersis.crearCiudadano(ciudadano);
    }
    
    public List<Turno> listarTurnos(){
        List<Turno> turnolistado = controlPersis.listarTurnos();
        return turnolistado;
    }
    
    public List<Turno> buscarFechaEstado (LocalDate fecha, boolean estado){
        return controlPersis.buscarFechaEstado(fecha, estado);
  }
    
    public List<Turno> buscarFecha (LocalDate fecha){
        return controlPersis.buscarFecha(fecha);
    }
    
    public Turno turnoId (Long id){
        return controlPersis.turnoId(id);
    }
    
    public void cambiarEstado (Turno turno) throws Exception{
        controlPersis.cambiarEstado(turno);
    }
}
