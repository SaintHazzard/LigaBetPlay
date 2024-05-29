package com.ligabetplay.ligabetplay.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ligabetplay.ligabetplay.funciones.QuickSort;
import com.ligabetplay.ligabetplay.partido.PartidoDTO;
import com.ligabetplay.ligabetplay.reportes.ReportService;
import com.ligabetplay.ligabetplay.reportes.Reporte;

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
  @Autowired
  private ReportService reportService;
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

  @GetMapping("/generate-report")
  @ResponseBody
  public Reporte generateReport(@RequestParam("type") String type) {
    return reportService.generateReport(type);
  }

}
