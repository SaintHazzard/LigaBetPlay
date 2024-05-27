package com.ligabetplay.ligabetplay.partido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.ligabetplay.ligabetplay.equipo.Equipo;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private LocalDate fechaPartido;

  @ManyToOne
  private Equipo equipoLocal;

  @ManyToOne
  private Equipo equipoVisitante;

  private int golesLocal;
  private int golesVisitante;
  private boolean jugado;

  public Partido(LocalDate fechaPartido, Equipo equipoLocal, Equipo equipoVisitante) {
    this.fechaPartido = fechaPartido;
    this.equipoLocal = equipoLocal;
    this.equipoVisitante = equipoVisitante;
    this.golesLocal = 0;
    this.golesVisitante = 0;
    this.jugado = false;
  }

}
