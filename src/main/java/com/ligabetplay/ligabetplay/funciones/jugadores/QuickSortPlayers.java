package com.ligabetplay.ligabetplay.funciones.jugadores;

import java.util.ArrayList;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;

public class QuickSortPlayers {
  public static void quickSort(ArrayList<Equipo> equipos, int low, int high) {
    if (low < high) {
      int pi = particion(equipos, low, high);
      quickSort(equipos, low, pi - 1);
      quickSort(equipos, pi + 1, high);
    }
  }

  static int particion(ArrayList<Equipo> equipos, int low, int high) {
    Equipo pivot = equipos.get(high);
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (comparacion(equipos.get(j), pivot) < 0) {
        i++;
        Equipo temp = equipos.get(i);
        equipos.set(i, equipos.get(j));
        equipos.set(j, temp);
      }
    }
    Equipo temp = equipos.get(i + 1);
    equipos.set(i + 1, equipos.get(high));
    equipos.set(high, temp);
    return i + 1;
  }

  static int comparacion(Equipo e1, Equipo e2) {
    if (e1.getTotalPuntos() != e2.getTotalPuntos()) {
      return Integer.compare(e2.getTotalPuntos(), e1.getTotalPuntos());
    } else {
      return Integer.compare(e2.getDiferenciaGoles(), e1.getDiferenciaGoles());
    }
  }
}
