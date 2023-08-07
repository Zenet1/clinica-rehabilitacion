package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.AntecedentesPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedentesPatologicosRepository extends JpaRepository<AntecedentesPatologicos, Long> {
    Optional<List<AntecedentesPatologicos>> findByPaciente(Paciente paciente);
}
