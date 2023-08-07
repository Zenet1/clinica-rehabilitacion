package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;
import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedentesGinecoObstetricosRepository extends JpaRepository<AntecedentesGinecoObstetricos, Long> {

    Optional<List<AntecedentesGinecoObstetricos>> findByPaciente(Paciente paciente);
}
