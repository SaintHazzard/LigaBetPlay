package com.ligabetplay.ligabetplay.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepositoryPort equipoRepositoryPort;

  public Equipo saveEquipo(Equipo equipo) {
    return equipoRepositoryPort.save(equipo);
  }

  public Equipo getEquipoById(int id) {
    return equipoRepositoryPort.findById(id).orElse(null);
  }

  public void deleteEquipo(int id) {
    equipoRepositoryPort.deleteById(id);
  }

  public Equipo updateEquipo(Equipo equipo) {
    return equipoRepositoryPort.save(equipo);
  }

  public Iterable<Equipo> getAllEquipos() {
    return equipoRepositoryPort.findAll();
  }

  public Equipo getEquipoByNombre(String nombre) {
    return equipoRepositoryPort.findByNombre(nombre);
  }

}
