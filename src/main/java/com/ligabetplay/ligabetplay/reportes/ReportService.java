package com.ligabetplay.ligabetplay.reportes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligabetplay.ligabetplay.equipo.Equipo;
import com.ligabetplay.ligabetplay.equipo.EquipoService;

@Service
public class ReportService {

  @Autowired
  private EquipoService equipoService;

  public Reporte generateReport(String type) {
    switch (type) {
      case "max-goals":
        return generateMaxGoalsReport();
      case "max-points":
        return generateMaxPointsReport();
      case "max-wins":
        return generateMaxWinsReport();
      case "total-goals":
        return generateTotalGoalsReport();
      case "avg-goals":
        return generateAvgGoalsReport();
      default:
        throw new IllegalArgumentException("Tipo de reporte no válido: " + type);
    }
  }

  private Reporte generateMaxGoalsReport() {
    Optional<Equipo> equipoOptional = equipoService.getEquipoConMasGoles();
    if (equipoOptional.isPresent()) {
      Equipo equipo = equipoOptional.get();

      Reporte reporte = new Reporte();
      reporte.setTitulo("Equipo con más goles");
      reporte.setContenido(
          "El equipo con más goles es: " + equipo.getNombre() + " con " + equipo.getGolesFavor() + " goles.");

      return reporte;
    } else {
      // Manejar el caso en que no se encuentre ningún equipo
      return null;
    }
  }

  public Reporte generateMaxPointsReport() {
    Optional<Equipo> equipoOptional = equipoService.getEquipoConMasPuntos();
    if (equipoOptional.isPresent()) {
      Equipo equipo = equipoOptional.get();

      Reporte reporte = new Reporte();
      reporte.setTitulo("Equipo con más puntos");
      reporte.setContenido(
          "El equipo con más puntos es: " + equipo.getNombre() + " con " + equipo.getTotalPuntos() + " puntos.");

      return reporte;
    } else {
      // Manejar el caso en que no se encuentre ningún equipo
      return null;
    }
  }

  private Reporte generateMaxWinsReport() {
    Optional<Equipo> equipoOptional = equipoService.getEquipoConMasPartidosGanados();
    if (equipoOptional.isPresent()) {
      Equipo equipo = equipoOptional.get();

      Reporte reporte = new Reporte();
      reporte.setTitulo("Equipo con más partidos ganados");
      reporte.setContenido("El equipo con más partidos ganados es: " + equipo.getNombre() + " con "
          + equipo.getPartidosGanados() + " partidos ganados.");

      return reporte;
    } else {
      return null;
    }
  }

  private Reporte generateTotalGoalsReport() {
    Reporte reporte = new Reporte();
    reporte.setTitulo("Total de goles");
    reporte.setContenido("El total de goles en la liga es: " + equipoService.getTotalGoles() + " goles.");

    return reporte;
  }

  private Reporte generateAvgGoalsReport() {
    Reporte reporte = new Reporte();
    reporte.setTitulo("Promedio de goles");
    reporte.setContenido("El promedio de goles en la liga es: " + String.format("%.2f",
        equipoService.getPromedioGoles()) + " goles.");

    return reporte;
  }
}
