package com.ligabetplay.ligabetplay.equipo.Domain.entidades;

import jakarta.persistence.Entity;

@Entity
public class Futbolista extends IntegranteEquipo {
  int dorsal;
  String posicion;
}
