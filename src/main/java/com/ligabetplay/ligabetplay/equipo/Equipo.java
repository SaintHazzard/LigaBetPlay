package com.ligabetplay.ligabetplay.equipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(unique = true)
  private String nombre;
  private int partidosJugados;
  private int partidosGanados;
  private int partidosEmpatados;
  private int partidosPerdidos;
  private int golesFavor;
  private int golesContra;
  private int diferenciaGoles;
  private int totalPuntos;

  public Equipo(String nombre) {
    this.nombre = nombre;
    this.partidosJugados = 0;
    this.partidosGanados = 0;
    this.partidosEmpatados = 0;
    this.partidosPerdidos = 0;
    this.golesFavor = 0;
    this.golesContra = 0;
    this.diferenciaGoles = 0;
    this.totalPuntos = 0;
  }

  public void sumarPartidoJugado() {
    this.partidosJugados++;
  }

  public void sumarPartidoGanado() {
    sumarPartidoJugado();
    this.partidosGanados++;
    this.totalPuntos += 3;
  }

  public void sumarPartidoEmpatado() {
    sumarPartidoJugado();
    this.partidosEmpatados++;
    this.totalPuntos++;
  }

  public void sumarPartidoPerdido() {
    sumarPartidoJugado();
    this.partidosPerdidos++;
  }

  public void sumarGolesFavor(int goles) {
    this.golesFavor += goles;
  }

  public void sumarGolesContra(int goles) {
    this.golesContra += goles;
  }

  public void sumarDiferenciaGoles(int goles) {
    this.diferenciaGoles += goles;
  }

  public void resetear() {
    this.partidosJugados = 0;
    this.partidosGanados = 0;
    this.partidosEmpatados = 0;
    this.partidosPerdidos = 0;
    this.golesFavor = 0;
    this.golesContra = 0;
    this.diferenciaGoles = 0;
    this.totalPuntos = 0;
  }
}
