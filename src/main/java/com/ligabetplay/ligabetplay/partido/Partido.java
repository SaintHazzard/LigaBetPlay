package com.ligabetplay.ligabetplay.partido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private LocalDate fecha;
  private int idEquipoLocal;
  private int idEquipoVisitante;
  private int golesLocal;
  private int golesVisitante;
  private boolean jugado;

  public Partido(LocalDate fecha, int idEquipoLocal, int idEquipoVisitante) {
    this.fecha = fecha;
    this.idEquipoLocal = idEquipoLocal;
    this.idEquipoVisitante = idEquipoVisitante;
    this.golesLocal = 0;
    this.golesVisitante = 0;
    this.jugado = false;
  }

  

}
