package com.ligabetplay.ligabetplay.partido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDTO {
  private int idEquipoLocal;
  private int idEquipoVisitante;
  private int golesLocal;
  private int golesVisitante;
  private String fechaPartido;

}
