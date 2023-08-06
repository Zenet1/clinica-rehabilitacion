package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAllPacientes(){
        return pacienteRepository.findAll();
    }

    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
