package com.ligabetplay.ligabetplay.equipo;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ligabetplay.ligabetplay.funciones.QuickSort;
import com.ligabetplay.ligabetplay.partido.PartidoDTO;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class EquipoController {

  @Autowired
  private EquipoService equipoService;
  private static ArrayList<Equipo> equipos;

  @PostConstruct
  public void init() {
    equipos = equipoService.getAllEquipos();
    QuickSort.quickSort(equipos, 0, equipos.size() - 1);
  }

  @GetMapping("/")
  public String index(Model model) {
    init();
    model.addAttribute("equipo", new Equipo());
    model.addAttribute("equipos", equipos);
    model.addAttribute("partidoDTO", new PartidoDTO());
    return "index";
  }

  @PostMapping("/guardarequipo")
  public String guardarEquipo(@ModelAttribute Equipo equipo, HttpServletRequest request) {
    if (equipoService.verificarEquipo(equipo.getNombre())) {
      return "redirect:/";
    }
    equipoService.saveEquipo(equipo);
    // String redirectUrl = UriComponentsBuilder
    // .fromHttpUrl(request.getRequestURL().toString())
    // .replacePath("/inicio")
    // .toUriString();
    return "redirect:/";
  }

  @GetMapping("/maxpuntos")
  public Equipo getMethodName(Equipo equipo) {
    return equipos.get(0);
  }

}
