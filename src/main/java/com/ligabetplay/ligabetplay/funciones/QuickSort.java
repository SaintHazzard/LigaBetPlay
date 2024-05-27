package com.ligabetplay.ligabetplay.funciones;

import java.util.ArrayList;
import com.ligabetplay.ligabetplay.equipo.Equipo;

public class QuickSort {
  static void quickSort(ArrayList<Equipo> equipos, int low, int high) {
    if (low < high) {
      int pi = particion(equipos, low, high);
      quickSort(equipos, low, pi - 1);
      quickSort(equipos, pi + 1, high);
    }
  }

  static int particion(ArrayList<Equipo> equipos, int low, int high) {
    int pivot = equipos.get(high).getTotalPuntos();
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (equipos.get(j).getTotalPuntos() < pivot) {
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
}
