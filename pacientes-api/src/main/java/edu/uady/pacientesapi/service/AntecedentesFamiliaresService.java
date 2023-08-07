package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.AntecedenteFamiliarDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedenteFamiliarDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentesFamiliaresDTO;
import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.AntecedentesFamiliaresRepository;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesFamiliaresService {
    @Autowired
    private AntecedentesFamiliaresRepository antecedentesFamiliaresRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteService pacienteService;

    public PacienteAntecedenteFamiliarDTO createAntecedentesFamiliares(AntecedentesFamiliares antecedentesFamiliares) throws Exception {

        try {
            AntecedentesFamiliares antecedentesFamiliaresCreated = antecedentesFamiliaresRepository.save(antecedentesFamiliares);
            return createAntecedentesFamiliaresDTO(antecedentesFamiliaresCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente familiar." + " " + exception.getMessage());
        }
    }

    public PacienteAntecedenteFamiliarDTO updateAntecedentesFamiliares(AntecedentesFamiliares antecedentesFamiliares, Long id) throws Exception {
        Optional<AntecedentesFamiliares> antecedenteFamiliarOptional = antecedentesFamiliaresRepository.findById(id);

        if (antecedenteFamiliarOptional.isPresent()) {
            AntecedentesFamiliares antecedenteFamiliar = antecedenteFamiliarOptional.get();

            antecedenteFamiliar.setAlergias(antecedentesFamiliares.getAlergias());
            antecedenteFamiliar.setCardiopatias(antecedentesFamiliares.getCardiopatias());
            antecedenteFamiliar.setDiabetes(antecedentesFamiliares.getDiabetes());
            antecedenteFamiliar.setNeurologicas(antecedentesFamiliares.getNeurologicas());
            antecedenteFamiliar.setNefropatias(antecedentesFamiliares.getNefropatias());
            antecedenteFamiliar.setPsiquiatricos(antecedentesFamiliares.getPsiquiatricos());
            antecedenteFamiliar.setOtros(antecedentesFamiliares.getOtros());

            AntecedentesFamiliares antecedenteFamiliarUpdated = antecedentesFamiliaresRepository.save(antecedenteFamiliar);

            PacienteAntecedenteFamiliarDTO pacienteAntecedenteFamiliarDTO = new PacienteAntecedenteFamiliarDTO();
            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedenteFamiliarUpdated.getPaciente());
            AntecedenteFamiliarDTO antecedenteFamiliarDTO = createAntecedenteFamiliarDTO(antecedenteFamiliarUpdated);

            pacienteAntecedenteFamiliarDTO.setPacienteDTO(pacienteDTO);
            pacienteAntecedenteFamiliarDTO.setAntecedenteFamiliarDTO(antecedenteFamiliarDTO);

            return pacienteAntecedenteFamiliarDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente familiar con ID " + id);
        }

    }

    public List<PacienteAntecedenteFamiliarDTO> getAllAntecedentesFamiliares() throws Exception {

        List<AntecedentesFamiliares> antecedentesFamiliares = antecedentesFamiliaresRepository.findAll();

        if (antecedentesFamiliares.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes familiares registrados.");
        }

        List<PacienteAntecedenteFamiliarDTO> antecedentesFamiliaresDTOS = new ArrayList<>();
        antecedentesFamiliares.forEach(antecedente -> {
            antecedentesFamiliaresDTOS.add(createAntecedentesFamiliaresDTO(antecedente));
        });

        return antecedentesFamiliaresDTOS;
    }

    public PacienteAntecedentesFamiliaresDTO getAntecedentesFamiliaresDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesFamiliares>> antecedentesFamiliaresOptional = antecedentesFamiliaresRepository.findByPaciente(paciente);

            if (!antecedentesFamiliaresOptional.isPresent() || antecedentesFamiliaresOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes familiares registrados.");
            } else {
                List<AntecedentesFamiliares> antecedentesFamiliares = antecedentesFamiliaresOptional.get();
                List<AntecedenteFamiliarDTO> antecedenteFamiliarDTOList = new ArrayList<>();

                antecedentesFamiliares.forEach(antecedente -> {
                    antecedenteFamiliarDTOList.add(createAntecedenteFamiliarDTO(antecedente));
                });

                PacienteAntecedentesFamiliaresDTO pacienteAntecedentesFamiliaresDTO = new PacienteAntecedentesFamiliaresDTO();
                pacienteAntecedentesFamiliaresDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesFamiliaresDTO.setAntecedentes_familiares(antecedenteFamiliarDTOList);

                return pacienteAntecedentesFamiliaresDTO;
            }
        } else {
            throw new PacienteException("No existe el paciente con ID " + id);
        }

    }

    private PacienteAntecedenteFamiliarDTO createAntecedentesFamiliaresDTO(AntecedentesFamiliares antecedente) {
        PacienteAntecedenteFamiliarDTO antecedentesFamiliaresDTO = new PacienteAntecedenteFamiliarDTO();
        PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesFamiliaresDTO.setPacienteDTO(pacienteDTO);

        AntecedenteFamiliarDTO antecedenteFamiliarDTO = createAntecedenteFamiliarDTO(antecedente);
        antecedentesFamiliaresDTO.setAntecedenteFamiliarDTO(antecedenteFamiliarDTO);

        return antecedentesFamiliaresDTO;
    }

    private AntecedenteFamiliarDTO createAntecedenteFamiliarDTO(AntecedentesFamiliares antecedente) {
        AntecedenteFamiliarDTO antecedenteFamiliarDTO = new AntecedenteFamiliarDTO();

        antecedenteFamiliarDTO.setAlergias(antecedente.getAlergias());
        antecedenteFamiliarDTO.setCardiopatias(antecedente.getCardiopatias());
        antecedenteFamiliarDTO.setDiabetes(antecedente.getDiabetes());
        antecedenteFamiliarDTO.setNefropatias(antecedente.getNefropatias());
        antecedenteFamiliarDTO.setPsiquiatricos(antecedente.getPsiquiatricos());
        antecedenteFamiliarDTO.setNeurologicas(antecedente.getNeurologicas());
        antecedenteFamiliarDTO.setOtros(antecedente.getOtros());

        return antecedenteFamiliarDTO;
    }

    public String deleteAntecedentesFamiliares(Long id) throws Exception {
        AntecedentesFamiliares antecedenteFamiliar = antecedentesFamiliaresRepository.findById(id)
                .orElseThrow(() -> new AntecedentesException("No se encontró ningún antecedente familiar con ID " + id));

        antecedentesFamiliaresRepository.delete(antecedenteFamiliar);

        return "Antecedente familiar con ID " + id + " eliminado exitosamente.";
    }


}
