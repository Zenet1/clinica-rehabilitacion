package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.DiagnosticoDTO;
import edu.uady.citasapi.dto.CatalogoSistemasDTO;
import edu.uady.citasapi.dto.PacienteAntecedentesFamiliaresDTO;
import edu.uady.citasapi.dto.CitaDTO;
import edu.uady.citasapi.error.AntecedentesException;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.DiagnosticoRepository;
import edu.uady.citasapi.repository.CitaRepository;
import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.entity.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesFamiliaresService {
    @Autowired
    private DiagnosticoRepository antecedentesFamiliaresRepository;

    @Autowired
    private CitaRepository pacienteRepository;

    @Autowired
    private CitaService pacienteService;

    public CatalogoSistemasDTO createAntecedentesFamiliares(AntecedentesFamiliares antecedentesFamiliares) throws Exception {

        try {
            AntecedentesFamiliares antecedentesFamiliaresCreated = antecedentesFamiliaresRepository.save(antecedentesFamiliares);
            return createAntecedentesFamiliaresDTO(antecedentesFamiliaresCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente familiar." + " " + exception.getMessage());
        }
    }

    public CatalogoSistemasDTO updateAntecedentesFamiliares(AntecedentesFamiliares antecedentesFamiliares, Long id) throws Exception {
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

            CatalogoSistemasDTO pacienteAntecedenteFamiliarDTO = new CatalogoSistemasDTO();
            CitaDTO pacienteDTO = pacienteService.createPacienteDTO(antecedenteFamiliarUpdated.getPaciente());
            DiagnosticoDTO antecedenteFamiliarDTO = createAntecedenteFamiliarDTO(antecedenteFamiliarUpdated);

            pacienteAntecedenteFamiliarDTO.setPacienteDTO(pacienteDTO);
            pacienteAntecedenteFamiliarDTO.setAntecedenteFamiliarDTO(antecedenteFamiliarDTO);

            return pacienteAntecedenteFamiliarDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente familiar con ID " + id);
        }

    }

    public List<CatalogoSistemasDTO> getAllAntecedentesFamiliares() throws Exception {

        List<AntecedentesFamiliares> antecedentesFamiliares = antecedentesFamiliaresRepository.findAll();

        if (antecedentesFamiliares.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes familiares registrados.");
        }

        List<CatalogoSistemasDTO> antecedentesFamiliaresDTOS = new ArrayList<>();
        antecedentesFamiliares.forEach(antecedente -> {
            antecedentesFamiliaresDTOS.add(createAntecedentesFamiliaresDTO(antecedente));
        });

        return antecedentesFamiliaresDTOS;
    }

    public PacienteAntecedentesFamiliaresDTO getAntecedentesFamiliaresDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            CitaDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesFamiliares>> antecedentesFamiliaresOptional = antecedentesFamiliaresRepository.findByPaciente(paciente);

            if (!antecedentesFamiliaresOptional.isPresent() || antecedentesFamiliaresOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes familiares registrados.");
            } else {
                List<AntecedentesFamiliares> antecedentesFamiliares = antecedentesFamiliaresOptional.get();
                List<DiagnosticoDTO> antecedenteFamiliarDTOList = new ArrayList<>();

                antecedentesFamiliares.forEach(antecedente -> {
                    antecedenteFamiliarDTOList.add(createAntecedenteFamiliarDTO(antecedente));
                });

                PacienteAntecedentesFamiliaresDTO pacienteAntecedentesFamiliaresDTO = new PacienteAntecedentesFamiliaresDTO();
                pacienteAntecedentesFamiliaresDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesFamiliaresDTO.setAntecedentes_familiares(antecedenteFamiliarDTOList);

                return pacienteAntecedentesFamiliaresDTO;
            }
        } else {
            throw new CitaException("No existe el paciente con ID " + id);
        }

    }

    private CatalogoSistemasDTO createAntecedentesFamiliaresDTO(AntecedentesFamiliares antecedente) {
        CatalogoSistemasDTO antecedentesFamiliaresDTO = new CatalogoSistemasDTO();
        CitaDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesFamiliaresDTO.setPacienteDTO(pacienteDTO);

        DiagnosticoDTO antecedenteFamiliarDTO = createAntecedenteFamiliarDTO(antecedente);
        antecedentesFamiliaresDTO.setAntecedenteFamiliarDTO(antecedenteFamiliarDTO);

        return antecedentesFamiliaresDTO;
    }

    private DiagnosticoDTO createAntecedenteFamiliarDTO(AntecedentesFamiliares antecedente) {
        DiagnosticoDTO antecedenteFamiliarDTO = new DiagnosticoDTO();

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
