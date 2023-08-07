package edu.uady.citasapi.repository;

import edu.uady.citasapi.entity.Diagnostico;
import edu.uady.citasapi.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    Optional<List<Diagnostico>> findByCita(Cita cita);
}
