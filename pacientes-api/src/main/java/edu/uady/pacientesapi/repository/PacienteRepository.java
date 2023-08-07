package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<Paciente, Long> {
}
