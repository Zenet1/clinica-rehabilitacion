package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.entity.AntecedentesNoPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedentesNoPatologicosRepository extends JpaRepository<AntecedentesNoPatologicos, Long> {
    Optional<List<AntecedentesNoPatologicos>> findByPaciente(Paciente paciente);
}
