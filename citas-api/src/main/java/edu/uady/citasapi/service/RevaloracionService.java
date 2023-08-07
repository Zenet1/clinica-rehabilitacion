package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.RevaloracionDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.RevaloracionRepository;
import edu.uady.citasapi.entity.Revaloracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RevaloracionService {

    @Autowired
    private RevaloracionRepository revaloracionRepository;

    public RevaloracionDTO createRevaloracion(Revaloracion revaloracion) throws Exception {

        try {
            Revaloracion revaloracionCreated = revaloracionRepository.save(revaloracion);
            return createRevaloracionDTO(revaloracionCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo revaloracion.");
        }

    }

    public RevaloracionDTO updateRevaloracion(Revaloracion revaloracion, Long id) throws Exception {

        Optional<Revaloracion> revaloracionOptional = revaloracionRepository.findById(id);

        if (revaloracionOptional.isPresent()) {
            Revaloracion revaloracionExistente = revaloracionOptional.get();
            
            revaloracionExistente.setIdDiagnostico(revaloracion.getIdDiagnostico());
            revaloracionExistente.setFecha(revaloracion.getFecha());
            revaloracionExistente.setIdSistema(revaloracion.getIdSistema());
            revaloracionExistente.setDiagnostico(revaloracion.getDiagnostico());

            Revaloracion revaloracionUpdated = revaloracionRepository.save(revaloracionExistente);
            return createRevaloracionDTO(revaloracionUpdated);
        } else {
            throw new CitaException("No existe revaloracion con ID " + id);
        }
    }

    public List<RevaloracionDTO> getAllRevaloracions() throws Exception {
        List<Revaloracion> revaloracions = revaloracionRepository.findAll();

        if (revaloracions.isEmpty()) {
            throw new CitaException("No hay revaloracions registrados.");
        }

        List<RevaloracionDTO> revaloracionDTOS = new ArrayList<>();

        revaloracions.forEach(revaloracion -> {

            RevaloracionDTO revaloracionDTO = createRevaloracionDTO(revaloracion);
            revaloracionDTOS.add(revaloracionDTO);
        });

        return revaloracionDTOS;
    }

    public RevaloracionDTO getRevaloracion(Long id) throws Exception {
        Optional<Revaloracion> revaloracionOptional = revaloracionRepository.findById(id);

        if (revaloracionOptional.isPresent()) {
            Revaloracion revaloracion = revaloracionOptional.get();
            return createRevaloracionDTO(revaloracion);
        } else {
            throw new CitaException("No se encontró algún revaloracion con el ID " + id);
        }
    }

    protected RevaloracionDTO createRevaloracionDTO(Revaloracion revaloracion) {
        RevaloracionDTO revaloracionDTO = new RevaloracionDTO();

        revaloracionDTO.setIdDiagnostico(revaloracion.getIdDiagnostico());
        revaloracionDTO.setFecha(revaloracion.getFecha());
        revaloracionDTO.setIdSistema(revaloracion.getIdSistema());
        revaloracionDTO.setDiagnostico(revaloracion.getDiagnostico());

        return revaloracionDTO;
    }

    public String deleteRevaloracion(Long id) throws Exception {

        Revaloracion revaloracion = revaloracionRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún revaloracion con ID " + id));

        revaloracionRepository.delete(revaloracion);

        return "Revaloracion con ID " + id + " eliminado exitosamente.";

    }

    public Revaloracion convertirDTOaRevaloracion(RevaloracionDTO revaloracionDTO) {
        Revaloracion revaloracion = new Revaloracion();

        revaloracion.setIdDiagnostico(revaloracion.getIdDiagnostico());
        revaloracion.setFecha(revaloracion.getFecha());
        revaloracion.setIdSistema(revaloracion.getIdSistema());
        revaloracion.setDiagnostico(revaloracion.getDiagnostico());
        

        return revaloracion;
    }
}
