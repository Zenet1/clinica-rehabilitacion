package edu.uady.citasapi.repository;

import edu.uady.citasapi.entity.Revaloracion;
import edu.uady.citasapi.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RevaloracionRepository extends JpaRepository<Revaloracion, Long> {
	Optional<List<Revaloracion>> findByDiagnostico(Diagnostico diagnostico);
}
