package com.ligabetplay.ligabetplay.equipo;

import java.util.Optional;

import java.util.ArrayList;

public interface EquipoRepositoryPort {
  Equipo save(Equipo equipo);

  Optional<Equipo> findById(int id);

  void deleteById(int id);

  Equipo findByNombre(String nombre);

  ArrayList<Equipo> findAll();

  boolean existsByNombre(String nombre);

  Optional<Equipo> findTopByOrderByGolesFavorDesc();

  Optional<Equipo> findTopByOrderByTotalPuntosDesc();

  Optional<Equipo> findTopByOrderByPartidosGanadosDesc();

}
