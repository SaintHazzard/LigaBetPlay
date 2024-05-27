package com.ligabetplay.ligabetplay.partido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligabetplay.ligabetplay.equipo.Equipo;

import java.util.ArrayList;
import java.time.LocalDate;

@Service
public class PartidoService {

  @Autowired
  private PartidoRepositoryPort partidoRepositoryPort;

  public Partido savePartido(Partido partido) {
    return partidoRepositoryPort.save(partido);
  }

  public Partido getPartidoById(int id) {
    return partidoRepositoryPort.findById(id);
  }

  public void deletePartido(int id) {
    partidoRepositoryPort.deleteById(id);
  }

  public Partido updatePartido(Partido partido) {
    return partidoRepositoryPort.save(partido);
  }

  public ArrayList<Partido> getAllPartidos() {
    return partidoRepositoryPort.findAll();
  }

  public Partido getPartidoByEquipoLocal(Equipo equipoLocal) {
    return partidoRepositoryPort.findByEquipoLocal(equipoLocal);
  }

  public Partido getPartidoByEquipoVisitante(Equipo equipoVisitante) {
    return partidoRepositoryPort.findByEquipoVisitante(equipoVisitante);
  }

  public Partido getPartidoByFechaPartido(LocalDate fechaPartido) {
    return partidoRepositoryPort.findByFechaPartido(fechaPartido);
  }

}
