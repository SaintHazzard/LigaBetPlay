package com.ligabetplay.ligabetplay.partido;

import java.util.ArrayList;
import java.time.LocalDate;
import com.ligabetplay.ligabetplay.equipo.Equipo;

public interface PartidoRepositoryPort {
  Partido save(Partido partido);

  ArrayList<Partido> findAll();

  Partido findById(int id);

  void deleteById(int id);

  Partido findByEquipoLocal(Equipo equipoLocal);

  Partido findByEquipoVisitante(Equipo equipoVisitante);

  Partido findByFechaPartido(LocalDate fechaPartido);

}
