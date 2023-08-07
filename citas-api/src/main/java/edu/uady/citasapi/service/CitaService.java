package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.CitaDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.CitaRepository;
import edu.uady.pacientesapi.entity.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository pacienteRepository;

    public CitaDTO createPaciente(Paciente paciente) throws Exception {

        try {
            Paciente pacienteCreated = pacienteRepository.save(paciente);
            return createPacienteDTO(pacienteCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo paciente.");
        }

    }

    public CitaDTO updatePaciente(Paciente paciente, Long id) throws Exception {

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
            throw new CitaException("No existe paciente con ID " + id);
        }
    }

    public List<CitaDTO> getAllPacientes() throws Exception {
        List<Paciente> pacientes = pacienteRepository.findAll();

        if (pacientes.isEmpty()) {
            throw new CitaException("No hay pacientes registrados.");
        }

        List<CitaDTO> pacienteDTOS = new ArrayList<>();

        pacientes.forEach(paciente -> {

            CitaDTO pacienteDTO = createPacienteDTO(paciente);
            pacienteDTOS.add(pacienteDTO);
        });

        return pacienteDTOS;
    }

    public CitaDTO getPaciente(Long id) throws Exception {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            return createPacienteDTO(paciente);
        } else {
            throw new CitaException("No se encontró algún paciente con el ID " + id);
        }
    }

    protected CitaDTO createPacienteDTO(Paciente paciente) {
        CitaDTO pacienteDTO = new CitaDTO();

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
                .orElseThrow(() -> new CitaException("No se encontró ningún paciente con ID " + id));

        pacienteRepository.delete(paciente);

        return "Paciente con ID " + id + " eliminado exitosamente.";

    }

    public Paciente convertirDTOaPaciente(CitaDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEstado_civil(pacienteDTO.getEstado_civil());
        paciente.setEscolaridad(pacienteDTO.getEscolaridad());
        paciente.setOcupacion(pacienteDTO.getOcupacion());

        return paciente;
    }
}
