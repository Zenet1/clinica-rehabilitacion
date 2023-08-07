package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.PacienteTypeDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.PacienteTypeRepository;
import edu.uady.citasapi.entity.PacienteType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteTypeService {

    @Autowired
    private PacienteTypeRepository pacienteTypeRepository;

    public PacienteTypeDTO createPacienteType(PacienteType pacienteType) throws Exception {

        try {
            PacienteType pacienteTypeCreated = pacienteTypeRepository.save(pacienteType);
            return createPacienteTypeDTO(pacienteTypeCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo cita.");
        }

    }

    public PacienteTypeDTO updatePacienteType(PacienteType pacienteType, Long id) throws Exception {

        Optional<PacienteType> pacienteTypeOptional = pacienteTypeRepository.findById(id);

        if (pacienteTypeOptional.isPresent()) {
            PacienteType pacienteTypeExistente = pacienteTypeOptional.get();
            
            pacienteTypeExistente.setNombre(pacienteType.getNombre());


            PacienteType pacienteTypeUpdated = pacienteTypeRepository.save(pacienteTypeExistente);
            return createPacienteTypeDTO(pacienteTypeUpdated);
        } else {
            throw new CitaException("No existe pacienteType con ID " + id);
        }
    }

    public List<PacienteTypeDTO> getAllPacienteType() throws Exception {
        List<PacienteType> pacientesTypes = pacienteTypeRepository.findAll();

        if (pacientesTypes.isEmpty()) {
            throw new CitaException("No hay citas registrados.");
        }

        List<PacienteTypeDTO> pacienteTypeDTOS = new ArrayList<>();

        pacientesTypes.forEach(pacienteType -> {

            PacienteTypeDTO citaDTO = createPacienteTypeDTO(pacienteType);
            pacienteTypeDTOS.add(citaDTO);
        });

        return pacienteTypeDTOS;
    }

    public PacienteTypeDTO getPacienteType(Long id) throws Exception {
        Optional<PacienteType> citaOptional = pacienteTypeRepository.findById(id);

        if (citaOptional.isPresent()) {
            PacienteType pacienteType = citaOptional.get();
            return createPacienteTypeDTO(pacienteType);
        } else {
            throw new CitaException("No se encontró algún cita con el ID " + id);
        }
    }

    protected PacienteTypeDTO createPacienteTypeDTO(PacienteType pacienteType) {
        PacienteTypeDTO pacienteTypeDTO = new PacienteTypeDTO();
        
        pacienteTypeDTO.setNombre(pacienteType.getNombre());

        return pacienteTypeDTO;
    }

    public String deletePacienteType(Long id) throws Exception {

        PacienteType pacienteType = pacienteTypeRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún cita con ID " + id));

        pacienteTypeRepository.delete(pacienteType);

        return "Cita con ID " + id + " eliminado exitosamente.";

    }

    public PacienteType convertirDTOaCita(PacienteTypeDTO pacienteTypeDTO) {
        PacienteType pacienteType = new PacienteType();

        pacienteType.setNombre(pacienteType.getNombre());


        return pacienteType;
    }
}
