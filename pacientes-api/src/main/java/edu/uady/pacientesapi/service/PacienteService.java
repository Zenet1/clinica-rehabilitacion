package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDTO createPaciente(Paciente paciente) throws Exception {

        try {
            Paciente pacienteCreated = pacienteRepository.save(paciente);
            return createPacienteDTO(pacienteCreated);
        } catch (Exception exception) {
            throw new PacienteException("Ha ocurrido un error al guardar nuevo paciente.");
        }

    }

    public PacienteDTO updatePaciente(Paciente paciente, Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente pacienteExistente = pacienteOptional.get();

            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setApellidos(paciente.getApellidos());
            pacienteExistente.setDireccion(paciente.getDireccion());
            pacienteExistente.setEmail(paciente.getEmail());
            pacienteExistente.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteExistente.setEscolaridad(paciente.getEscolaridad());
            pacienteExistente.setOcupacion(paciente.getOcupacion());
            pacienteExistente.setEstado_civil(paciente.getEstado_civil());

            Paciente pacienteUpdated = pacienteRepository.save(pacienteExistente);
            return createPacienteDTO(pacienteUpdated);
        } else {
            throw new PacienteException("No existe paciente con ID " + id);
        }
    }

    public List<PacienteDTO> getAllPacientes() throws Exception {
        List<Paciente> pacientes = pacienteRepository.findAll();

        if (pacientes.isEmpty()) {
            throw new PacienteException("No hay pacientes registrados.");
        }

        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        pacientes.forEach(paciente -> {

            PacienteDTO pacienteDTO = createPacienteDTO(paciente);
            pacienteDTOS.add(pacienteDTO);
        });

        return pacienteDTOS;
    }

    public PacienteDTO getPaciente(Long id) throws Exception {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            return createPacienteDTO(paciente);
        } else {
            throw new PacienteException("No se encontró algún paciente con el ID " + id);
        }
    }

    private PacienteDTO createPacienteDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellidos(paciente.getApellidos());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setEstado_civil(paciente.getEstado_civil());
        pacienteDTO.setEscolaridad(paciente.getEscolaridad());
        pacienteDTO.setOcupacion(paciente.getOcupacion());

        return pacienteDTO;
    }

    public String deletePaciente(Long id) throws Exception {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteException("No se encontró ningún paciente con ID " + id));

        pacienteRepository.delete(paciente);

        return "Paciente con ID " + id + " eliminado exitosamente.";

    }
}
