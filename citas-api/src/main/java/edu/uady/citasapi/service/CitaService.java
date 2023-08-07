package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.CitaDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.CitaRepository;
import edu.uady.citasapi.entity.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public CitaDTO createCita(Cita cita) throws Exception {

        try {
            Cita citaCreated = citaRepository.save(cita);
            return createCitaDTO(citaCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo cita.");
        }

    }

    public CitaDTO updateCita(Cita cita, Long id) throws Exception {

        Optional<Cita> citaOptional = citaRepository.findById(id);

        if (citaOptional.isPresent()) {
            Cita citaExistente = citaOptional.get();
            
            citaExistente.setIdPaciente(cita.getIdPaciente());
            citaExistente.setFechaHora(cita.getFechaHora());
            citaExistente.setIdPacienteType(cita.getIdPacienteType());
            citaExistente.setIdStatus(cita.getIdStatus());
            citaExistente.setNumeroSesion(cita.getNumeroSesion());
            citaExistente.setCostoTerapia(cita.getCostoTerapia());

            Cita citaUpdated = citaRepository.save(citaExistente);
            return createCitaDTO(citaUpdated);
        } else {
            throw new CitaException("No existe cita con ID " + id);
        }
    }

    public List<CitaDTO> getAllCitas() throws Exception {
        List<Cita> citas = citaRepository.findAll();

        if (citas.isEmpty()) {
            throw new CitaException("No hay citas registrados.");
        }

        List<CitaDTO> citaDTOS = new ArrayList<>();

        citas.forEach(cita -> {

            CitaDTO citaDTO = createCitaDTO(cita);
            citaDTOS.add(citaDTO);
        });

        return citaDTOS;
    }

    public CitaDTO getCita(Long id) throws Exception {
        Optional<Cita> citaOptional = citaRepository.findById(id);

        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();
            return createCitaDTO(cita);
        } else {
            throw new CitaException("No se encontró algún cita con el ID " + id);
        }
    }

    protected CitaDTO createCitaDTO(Cita cita) {
        CitaDTO citaDTO = new CitaDTO();

        citaDTO.setIdPaciente(cita.getIdPaciente());
        citaDTO.setFechaHora(cita.getFechaHora());
        citaDTO.setIdPacienteType(cita.getIdPacienteType());
        citaDTO.setIdStatus(cita.getIdStatus());
        citaDTO.setNumeroSesion(cita.getNumeroSesion());
        citaDTO.setCostoTerapia(cita.getCostoTerapia());

        return citaDTO;
    }

    public String deleteCita(Long id) throws Exception {

        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún cita con ID " + id));

        citaRepository.delete(cita);

        return "Cita con ID " + id + " eliminado exitosamente.";

    }

    public Cita convertirDTOaCita(CitaDTO citaDTO) {
        Cita cita = new Cita();

        cita.setIdPaciente(cita.getIdPaciente());
        cita.setFechaHora(cita.getFechaHora());
        cita.setIdPacienteType(cita.getIdPacienteType());
        cita.setIdStatus(cita.getIdStatus());
        cita.setNumeroSesion(cita.getNumeroSesion());
        cita.setCostoTerapia(cita.getCostoTerapia());

        return cita;
    }
}
