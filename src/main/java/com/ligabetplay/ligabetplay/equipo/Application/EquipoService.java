package com.ligabetplay.ligabetplay.equipo.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;
import com.ligabetplay.ligabetplay.equipo.Infraestructure.EquipoRepositoryPort;

import java.util.ArrayList;
import java.util.Optional;

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

  public ArrayList<Equipo> getAllEquipos() {
    return equipoRepositoryPort.findAll();
  }

  public Equipo getEquipoByNombre(String nombre) {
    return equipoRepositoryPort.findByNombre(nombre);
  }

  public boolean verificarEquipo(String nombre) {
    return equipoRepositoryPort.existsByNombre(nombre);
  }

  public Optional<Equipo> getEquipoConMasPuntos() {
    return equipoRepositoryPort.findTopByOrderByTotalPuntosDesc();
  }

  public Optional<Equipo> getEquipoConMasGoles() {
    return equipoRepositoryPort.findTopByOrderByGolesFavorDesc();
  }

  public Optional<Equipo> getEquipoConMasPartidosGanados() {
    return equipoRepositoryPort.findTopByOrderByPartidosGanadosDesc();
  }

  public int getTotalGoles() {
    return equipoRepositoryPort.findAll().stream().mapToInt(Equipo::getGolesFavor).sum();
  }

  public double getPromedioGoles() {
    return equipoRepositoryPort.findAll().stream().mapToInt(Equipo::getGolesFavor).average().orElse(0);
  }

}
