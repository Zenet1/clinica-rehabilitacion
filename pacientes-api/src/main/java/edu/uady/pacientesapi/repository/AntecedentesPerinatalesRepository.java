package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.AntecedentesPerinatales;
import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedentesPerinatalesRepository extends JpaRepository<AntecedentesPerinatales, Long> {
    Optional<List<AntecedentesPerinatales>> findByPaciente(Paciente paciente);
}
