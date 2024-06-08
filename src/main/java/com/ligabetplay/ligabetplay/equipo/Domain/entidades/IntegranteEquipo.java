package com.ligabetplay.ligabetplay.equipo.Domain.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class IntegranteEquipo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String nombre;
  String apellidos;
  int edad;
}
