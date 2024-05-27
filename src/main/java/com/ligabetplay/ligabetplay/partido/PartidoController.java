package com.ligabetplay.ligabetplay.partido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/partidos")
public class PartidoController {

  @Autowired
  private PartidoService partidoService;

  @PostMapping("/registrarpartido")
  public String registerpartido(@RequestBody PartidoDTO partidoDTO) {
    Partido partido = new Partido();
    partido.setEquipoLocal(partidoDTO.getEquipoLocal());
    partido.setEquipoVisitante(partidoDTO.getEquipoVisitante());
    partido.setGolesLocal(partidoDTO.getGolesLocal());
    partido.setGolesVisitante(partidoDTO.getGolesVisitante());
    partido.setFechaPartido(LocalDate.parse(partidoDTO.getFechaPartido()));
    partidoService.savePartido(partido);
    return "redirect:/";
  }

}
