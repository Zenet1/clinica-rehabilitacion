package edu.uady.pacientesapi.repository;

import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedentesFamiliaresRepository extends JpaRepository<AntecedentesFamiliares, Long> {

    Optional<List<AntecedentesFamiliares>> findByPaciente(Paciente paciente);
}
