package com.ligabetplay.ligabetplay.partido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDTO {
  private Equipo equipoLocal;
  private Equipo equipoVisitante;
  private int golesLocal;
  private int golesVisitante;
  private LocalDate fechaPartido;
}
