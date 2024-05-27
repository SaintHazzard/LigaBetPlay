package com.ligabetplay.ligabetplay.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

  @Autowired
  private EquipoService equipoService;

  @PostMapping("/guardarequipo")
  public String guardarEquipo(@ModelAttribute Equipo equipo, HttpServletRequest request) {
    equipoService.saveEquipo(equipo);

    String redirectUrl = UriComponentsBuilder
        .fromHttpUrl(request.getRequestURL().toString())
        .replacePath("/inicio")
        .toUriString();
    return "redirect:" + redirectUrl;
  }

}
