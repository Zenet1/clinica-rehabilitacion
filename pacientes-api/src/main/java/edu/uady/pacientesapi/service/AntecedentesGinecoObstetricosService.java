package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.*;
import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.AntecedentesGinecoObstetricosRepository;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesGinecoObstetricosService {

    @Autowired
    private AntecedentesGinecoObstetricosRepository antecedentesGinecoObstetricosRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteAntecedenteGinecoObstetricoDTO createAntecedentesGinecoObstetricos(AntecedentesGinecoObstetricos antecedentesGinecoObstetricos) throws Exception {

        try {
            AntecedentesGinecoObstetricos antecedentesGinecoObstetricosCreated = antecedentesGinecoObstetricosRepository.save(antecedentesGinecoObstetricos);
            return createAntecedentesGinecoObstetricosDTO(antecedentesGinecoObstetricosCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente gineco obstetrico");
        }

    }

    public PacienteAntecedenteGinecoObstetricoDTO updateAntecedentesGinecoObstetricos(AntecedentesGinecoObstetricos antecedentesGinecoObstetricos, Long id) throws Exception {

        Optional<AntecedentesGinecoObstetricos> antecedenteOptional = antecedentesGinecoObstetricosRepository.findById(id);

        if (antecedenteOptional.isPresent()) {
            AntecedentesGinecoObstetricos antecedenteGinecoObstetrico = antecedenteOptional.get();
            
            antecedenteGinecoObstetrico.setMenarca(antecedentesGinecoObstetricos.getMenarca());
            antecedenteGinecoObstetrico.setRitmo_menstrual(antecedentesGinecoObstetricos.getRitmo_menstrual());
            antecedenteGinecoObstetrico.setIPSA(antecedentesGinecoObstetricos.getIPSA());
            antecedenteGinecoObstetrico.setPartos(antecedentesGinecoObstetricos.getPartos());
            antecedenteGinecoObstetrico.setFUP(antecedentesGinecoObstetricos.getFUP());
            antecedenteGinecoObstetrico.setAbortos(antecedentesGinecoObstetricos.getAbortos());
            antecedenteGinecoObstetrico.setAbortos(antecedentesGinecoObstetricos.getCesareas());

            AntecedentesGinecoObstetricos antecedenteUpdated = antecedentesGinecoObstetricosRepository.save(antecedenteGinecoObstetrico);

            PacienteAntecedenteGinecoObstetricoDTO pacienteAntecedenteGinecoObstetricoDTO = new PacienteAntecedenteGinecoObstetricoDTO();
            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedenteUpdated.getPaciente());
            AntecedenteGinecoObstetricoDTO antecedenteGinecoObstetricoDTO = createAntecedenteGinecoObstetrico(antecedenteUpdated);

            pacienteAntecedenteGinecoObstetricoDTO.setPaciente(pacienteDTO);
            pacienteAntecedenteGinecoObstetricoDTO.setAntecedente_gineco_obstetrico(antecedenteGinecoObstetricoDTO);

            return pacienteAntecedenteGinecoObstetricoDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente gineco obstetrico con ID " + id);
        }

    }

    public List<PacienteAntecedenteGinecoObstetricoDTO> getAllAntecedentesGinecoObstetricos() throws Exception {

        List<AntecedentesGinecoObstetricos> antecedentesGinecoObstetricos = antecedentesGinecoObstetricosRepository.findAll();

        if (antecedentesGinecoObstetricos.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes gineco obstetricos registrados.");
        }

        List<PacienteAntecedenteGinecoObstetricoDTO> antecedenteGinecoObstetricoDTOS = new ArrayList<>();
        antecedentesGinecoObstetricos.forEach(antecedente -> {
            antecedenteGinecoObstetricoDTOS.add(createAntecedentesGinecoObstetricosDTO(antecedente));
        });

        return antecedenteGinecoObstetricoDTOS;
    }

    public String deleteAntecedentesGinecoObstetricos(Long id) throws Exception {
        AntecedentesGinecoObstetricos antecedenteGinecoObstetricos = antecedentesGinecoObstetricosRepository.findById(id)
                .orElseThrow(() -> new AntecedentesException("No se encontró ningún antecedente gineco obstetrico con ID " + id));

        antecedentesGinecoObstetricosRepository.delete(antecedenteGinecoObstetricos);
        return "Antecedente gineco obstetrico con ID " + id + " eliminado exitosamente";
    }

    private PacienteAntecedenteGinecoObstetricoDTO createAntecedentesGinecoObstetricosDTO(AntecedentesGinecoObstetricos antecedente) {
        PacienteAntecedenteGinecoObstetricoDTO antecedentesGinecoObstetricoDTO = new PacienteAntecedenteGinecoObstetricoDTO();
        PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesGinecoObstetricoDTO.setPaciente(pacienteDTO);
        AntecedenteGinecoObstetricoDTO antecedenteGinecoObstetricoDTO = createAntecedenteGinecoObstetrico(antecedente);
        antecedentesGinecoObstetricoDTO.setAntecedente_gineco_obstetrico(antecedenteGinecoObstetricoDTO);

        return antecedentesGinecoObstetricoDTO;
    }

    private AntecedenteGinecoObstetricoDTO createAntecedenteGinecoObstetrico(AntecedentesGinecoObstetricos antecedente) {
        AntecedenteGinecoObstetricoDTO antecedenteGinecoObstetricoDTO = new AntecedenteGinecoObstetricoDTO();

        antecedenteGinecoObstetricoDTO.setMenarca(antecedente.getMenarca());
        antecedenteGinecoObstetricoDTO.setRitmo_menstrual(antecedente.getRitmo_menstrual());
        antecedenteGinecoObstetricoDTO.setIPSA(antecedente.getIPSA());
        antecedenteGinecoObstetricoDTO.setPartos(antecedente.getPartos());
        antecedenteGinecoObstetricoDTO.setFUP(antecedente.getFUP());
        antecedenteGinecoObstetricoDTO.setAbortos(antecedente.getAbortos());
        antecedenteGinecoObstetricoDTO.setAbortos(antecedente.getCesareas());

        return antecedenteGinecoObstetricoDTO;
    }

    public PacienteAntecedentesGinecoObstetricoDTO getAntecedentesGinecoObstetricosDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesGinecoObstetricos>> antecedentesOptional = antecedentesGinecoObstetricosRepository.findByPaciente(paciente);

            if (!antecedentesOptional.isPresent() || antecedentesOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes gineco obstetricos registrados.");
            } else {
                List<AntecedentesGinecoObstetricos> antecedentes = antecedentesOptional.get();
                List<AntecedenteGinecoObstetricoDTO> antecedenteGinecoObstetricoDTOS = new ArrayList<>();

                antecedentes.forEach(antecedente -> {
                    antecedenteGinecoObstetricoDTOS.add(createAntecedenteGinecoObstetrico(antecedente));
                });

                PacienteAntecedentesGinecoObstetricoDTO pacienteAntecedentesGinecoObstetricoDTO = new PacienteAntecedentesGinecoObstetricoDTO();
                pacienteAntecedentesGinecoObstetricoDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesGinecoObstetricoDTO.setAntecedentes_gineco_obstetricos(antecedenteGinecoObstetricoDTOS);

                return pacienteAntecedentesGinecoObstetricoDTO;
            }
        } else {
            throw new PacienteException("No existe el paciente con ID " + id);
        }

    }
}
