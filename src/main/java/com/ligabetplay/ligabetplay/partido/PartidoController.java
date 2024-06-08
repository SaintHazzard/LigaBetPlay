package com.ligabetplay.ligabetplay.partido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;

@Controller
@RequestMapping("/partido")
public class PartidoController {

  @Autowired
  private PartidoService partidoService;

  @PostMapping("/registrarpartido")
  public String guardarPartido(@ModelAttribute PartidoDTO partidoDTO) {
    Partido partido = convertirDtoAPartido(partidoDTO);
    actualizarEstadisticasEquipos(partido);
    partidoService.savePartido(partido);
    return "redirect:/";
  }

  private Partido convertirDtoAPartido(PartidoDTO partidoDTO) {
    Partido partido = new Partido();
    partido.setEquipoLocal(partidoDTO.getEquipoLocal());
    partido.setEquipoVisitante(partidoDTO.getEquipoVisitante());
    partido.setGolesLocal(partidoDTO.getGolesLocal());
    partido.setGolesVisitante(partidoDTO.getGolesVisitante());
    partido.setFechaPartido(partidoDTO.getFechaPartido());
    partido.setJugado(true);
    return partido;
  }

  private void actualizarEstadisticasEquipos(Partido partido) {
    Equipo equipoLocal = partido.getEquipoLocal();
    Equipo equipoVisitante = partido.getEquipoVisitante();

    actualizarResultadoPartido(partido, equipoLocal, equipoVisitante);
    actualizarGolesEquipos(partido, equipoLocal, equipoVisitante);
  }

  private void actualizarResultadoPartido(Partido partido, Equipo equipoLocal, Equipo equipoVisitante) {
    int golesLocal = partido.getGolesLocal();
    int golesVisitante = partido.getGolesVisitante();

    if (golesLocal == golesVisitante) {
      equipoLocal.sumarPartidoEmpatado();
      equipoVisitante.sumarPartidoEmpatado();
    } else if (golesLocal > golesVisitante) {
      equipoLocal.sumarPartidoGanado();
      equipoVisitante.sumarPartidoPerdido();
    } else {
      equipoLocal.sumarPartidoPerdido();
      equipoVisitante.sumarPartidoGanado();
    }
  }

  private void actualizarGolesEquipos(Partido partido, Equipo equipoLocal, Equipo equipoVisitante) {
    int golesLocal = partido.getGolesLocal();
    int golesVisitante = partido.getGolesVisitante();

    equipoLocal.setGolesFavor(equipoLocal.getGolesFavor() + golesLocal);
    equipoLocal.setGolesContra(equipoLocal.getGolesContra() + golesVisitante);
    equipoLocal.setDiferenciaGoles(equipoLocal.getGolesFavor() - equipoLocal.getGolesContra());

    equipoVisitante.setGolesFavor(equipoVisitante.getGolesFavor() + golesVisitante);
    equipoVisitante.setGolesContra(equipoVisitante.getGolesContra() + golesLocal);
    equipoVisitante.setDiferenciaGoles(equipoVisitante.getGolesFavor() - equipoVisitante.getGolesContra());
  }

}
