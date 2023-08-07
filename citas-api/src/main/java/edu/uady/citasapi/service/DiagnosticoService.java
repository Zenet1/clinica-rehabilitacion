package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.DiagnosticoDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.DiagnosticoRepository;
import edu.uady.citasapi.entity.Diagnostico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoDTO createDiagnostico(Diagnostico diagnostico) throws Exception {

        try {
            Diagnostico diagnosticoCreated = diagnosticoRepository.save(diagnostico);
            return createDiagnosticoDTO(diagnosticoCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo diagnostico.");
        }

    }

    public DiagnosticoDTO updateDiagnostico(Diagnostico diagnostico, Long id) throws Exception {

        Optional<Diagnostico> diagnosticoOptional = diagnosticoRepository.findById(id);

        if (diagnosticoOptional.isPresent()) {
            Diagnostico diagnosticoExistente = diagnosticoOptional.get();
            
            diagnosticoExistente.setIdCita(diagnostico.getIdCita());
            diagnosticoExistente.setFecha(diagnostico.getFecha());
            diagnosticoExistente.setIdSistema(diagnostico.getIdSistema());
            diagnosticoExistente.setDiagnostico(diagnostico.getDiagnostico());

            Diagnostico diagnosticoUpdated = diagnosticoRepository.save(diagnosticoExistente);
            return createDiagnosticoDTO(diagnosticoUpdated);
        } else {
            throw new CitaException("No existe diagnostico con ID " + id);
        }
    }

    public List<DiagnosticoDTO> getAllDiagnosticos() throws Exception {
        List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();

        if (diagnosticos.isEmpty()) {
            throw new CitaException("No hay diagnosticos registrados.");
        }

        List<DiagnosticoDTO> diagnosticoDTOS = new ArrayList<>();

        diagnosticos.forEach(diagnostico -> {

            DiagnosticoDTO diagnosticoDTO = createDiagnosticoDTO(diagnostico);
            diagnosticoDTOS.add(diagnosticoDTO);
        });

        return diagnosticoDTOS;
    }

    public DiagnosticoDTO getDiagnostico(Long id) throws Exception {
        Optional<Diagnostico> diagnosticoOptional = diagnosticoRepository.findById(id);

        if (diagnosticoOptional.isPresent()) {
            Diagnostico diagnostico = diagnosticoOptional.get();
            return createDiagnosticoDTO(diagnostico);
        } else {
            throw new CitaException("No se encontró algún diagnostico con el ID " + id);
        }
    }

    protected DiagnosticoDTO createDiagnosticoDTO(Diagnostico diagnostico) {
        DiagnosticoDTO diagnosticoDTO = new DiagnosticoDTO();

        diagnosticoDTO.setIdCita(diagnostico.getIdCita());
        diagnosticoDTO.setFecha(diagnostico.getFecha());
        diagnosticoDTO.setIdSistema(diagnostico.getIdSistema());
        diagnosticoDTO.setDiagnostico(diagnostico.getDiagnostico());

        return diagnosticoDTO;
    }

    public String deleteDiagnostico(Long id) throws Exception {

        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún diagnostico con ID " + id));

        diagnosticoRepository.delete(diagnostico);

        return "Diagnostico con ID " + id + " eliminado exitosamente.";

    }

    public Diagnostico convertirDTOaDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();

        diagnostico.setIdCita(diagnostico.getIdCita());
        diagnostico.setFecha(diagnostico.getFecha());
        diagnostico.setIdSistema(diagnostico.getIdSistema());
        diagnostico.setDiagnostico(diagnostico.getDiagnostico());
        

        return diagnostico;
    }
}
