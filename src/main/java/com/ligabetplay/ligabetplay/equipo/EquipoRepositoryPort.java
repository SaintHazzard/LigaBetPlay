package com.ligabetplay.ligabetplay.equipo;

import java.util.Optional;

public interface EquipoRepositoryPort {
  Equipo save(Equipo equipo);

  Optional<Equipo> findById(int id);

  void deleteById(int id);

  Equipo findByNombre(String nombre);

  Iterable<Equipo> findAll();

}
