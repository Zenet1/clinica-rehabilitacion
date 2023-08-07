package edu.uady.citasapi.repository;

import edu.uady.citasapi.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository  extends JpaRepository<Cita, Long> {
}
