package com.ligabetplay.ligabetplay.equipo.Infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ligabetplay.ligabetplay.equipo.Domain.entidades.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer>, EquipoRepositoryPort {

}
