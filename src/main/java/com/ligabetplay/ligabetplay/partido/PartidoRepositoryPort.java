package com.ligabetplay.ligabetplay.partido;

import java.util.ArrayList;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;

import java.time.LocalDate;

public interface PartidoRepositoryPort {
  Partido save(Partido partido);

  ArrayList<Partido> findAll();

  Partido findById(int id);

  void deleteById(int id);

  Partido findByEquipoLocal(Equipo equipoLocal);

  Partido findByEquipoVisitante(Equipo equipoVisitante);

  Partido findByFechaPartido(LocalDate fechaPartido);

}
