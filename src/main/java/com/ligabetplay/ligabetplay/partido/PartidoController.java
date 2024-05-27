package com.ligabetplay.ligabetplay.partido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/partidoes")
public class PartidoController {

  @Autowired
  private PartidoRepository partidoRepository;

  @PostMapping("/register")
  public Partido registerpartido(@RequestBody PartidoDTO partidoDTO) {
    Partido partido = new Partido();
    partido.setIdEquipoLocal(partidoDTO.getIdEquipoLocal());
    partido.setIdEquipoVisitante(partidoDTO.getIdEquipoVisitante());
    partido.setGolesLocal(partidoDTO.getGolesLocal());
    partido.setGolesVisitante(partidoDTO.getGolesVisitante());
    partido.setFecha(LocalDate.parse(partidoDTO.getFechaPartido()));
    return partidoRepository.save(partido);
  }


  
}
