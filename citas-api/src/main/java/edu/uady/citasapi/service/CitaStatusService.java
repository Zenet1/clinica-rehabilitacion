package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.CitaStatusDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.CitaStatusRepository;
import edu.uady.citasapi.entity.CitaStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaStatusService {

    @Autowired
    private CitaStatusRepository citaStatusRepository;

    public CitaStatusDTO createCitaStatus(CitaStatus citaStatus) throws Exception {

        try {
            CitaStatus citaStatusCreated = citaStatusRepository.save(citaStatus);
            return createCitaStatusDTO(citaStatusCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo cita.");
        }

    }

    public CitaStatusDTO updateCitaStatus(CitaStatus citaStatus, Long id) throws Exception {

        Optional<CitaStatus> citaStatusOptional = citaStatusRepository.findById(id);

        if (citaStatusOptional.isPresent()) {
            CitaStatus citaStatusExistente = citaStatusOptional.get();
            
            citaStatusExistente.setNombre(citaStatus.getNombre());


            CitaStatus citaStatusUpdated = citaStatusRepository.save(citaStatusExistente);
            return createCitaStatusDTO(citaStatusUpdated);
        } else {
            throw new CitaException("No existe citaStatus con ID " + id);
        }
    }

    public List<CitaStatusDTO> getAllCitaStatus() throws Exception {
        List<CitaStatus> citasStatus = citaStatusRepository.findAll();

        if (citasStatus.isEmpty()) {
            throw new CitaException("No hay citas registrados.");
        }

        List<CitaStatusDTO> citaStatusDTOS = new ArrayList<>();

        citasStatus.forEach(citaStatus -> {

            CitaStatusDTO citaDTO = createCitaStatusDTO(citaStatus);
            citaStatusDTOS.add(citaDTO);
        });

        return citaStatusDTOS;
    }

    public CitaStatusDTO getCitaStatus(Long id) throws Exception {
        Optional<CitaStatus> citaOptional = citaStatusRepository.findById(id);

        if (citaOptional.isPresent()) {
            CitaStatus citaStatus = citaOptional.get();
            return createCitaStatusDTO(citaStatus);
        } else {
            throw new CitaException("No se encontró algún cita con el ID " + id);
        }
    }

    protected CitaStatusDTO createCitaStatusDTO(CitaStatus citaStatus) {
        CitaStatusDTO citaStatusDTO = new CitaStatusDTO();
        
        citaStatusDTO.setNombre(citaStatus.getNombre());

        return citaStatusDTO;
    }

    public String deleteCitaStatus(Long id) throws Exception {

        CitaStatus citaStatus = citaStatusRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún cita con ID " + id));

        citaStatusRepository.delete(citaStatus);

        return "Cita con ID " + id + " eliminado exitosamente.";

    }

    public CitaStatus convertirDTOaCita(CitaStatusDTO citaStatusDTO) {
        CitaStatus citaStatus = new CitaStatus();

        citaStatus.setNombre(citaStatus.getNombre());


        return citaStatus;
    }
}
