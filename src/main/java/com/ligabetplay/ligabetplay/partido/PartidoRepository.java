package com.ligabetplay.ligabetplay.partido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer>, PartidoRepositoryPort {

}
