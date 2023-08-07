package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.AntecedentePerinatalDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentePerinatalDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentesPerinatalesDTO;
import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.AntecedentesPerinatales;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.AntecedentesPerinatalesRepository;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesPerinatalesService {
    @Autowired
    private AntecedentesPerinatalesRepository antecedentesPerinatalesRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteService pacienteService;

    public PacienteAntecedentePerinatalDTO createAntecedentesPerinatales(AntecedentesPerinatales antecedentesPerinatales) throws Exception {

        try {
            AntecedentesPerinatales antecedentesPerinatalesCreated = antecedentesPerinatalesRepository.save(antecedentesPerinatales);
            return createAntecedentesPerinatalesDTO(antecedentesPerinatalesCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente familiar." + " " + exception.getMessage());
        }
    }

    public PacienteAntecedentePerinatalDTO updateAntecedentesPerinatales(AntecedentesPerinatales antecedentesPerinatales, Long id) throws Exception {
        Optional<AntecedentesPerinatales> antecedentePerinatalOptional = antecedentesPerinatalesRepository.findById(id);

        if (antecedentePerinatalOptional.isPresent()) {
            AntecedentesPerinatales antecedentePerinatal = antecedentePerinatalOptional.get();

            antecedentePerinatal.setNacimiento(antecedentesPerinatales.getNacimiento());
            antecedentePerinatal.setSDG(antecedentesPerinatales.getSDG());
            antecedentePerinatal.setAPGAR(antecedentesPerinatales.getAPGAR());
            antecedentePerinatal.setTalla(antecedentesPerinatales.getTalla());
            antecedentePerinatal.setEmbarazos(antecedentesPerinatales.getEmbarazos());
            antecedentePerinatal.setPDP(antecedentesPerinatales.getPDP());
            
            

            

            AntecedentesPerinatales antecedentePerinatalUpdated = antecedentesPerinatalesRepository.save(antecedentePerinatal);

            PacienteAntecedentePerinatalDTO pacienteAntecedentePerinatalDTO = new PacienteAntecedentePerinatalDTO();
            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedentePerinatalUpdated.getPaciente());
            AntecedentePerinatalDTO antecedentePerinatalDTO = createAntecedentePerinatalDTO(antecedentePerinatalUpdated);

            pacienteAntecedentePerinatalDTO.setPaciente(pacienteDTO);
            pacienteAntecedentePerinatalDTO.setAntecedente_Perinatal(antecedentePerinatalDTO);

            return pacienteAntecedentePerinatalDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente perinatal con ID " + id);
        }

    }

    public List<PacienteAntecedentePerinatalDTO> getAllAntecedentesPerinatales() throws Exception {

        List<AntecedentesPerinatales> antecedentesPerinatales = antecedentesPerinatalesRepository.findAll();

        if (antecedentesPerinatales.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes perinatales registrados.");
        }

        List<PacienteAntecedentePerinatalDTO> antecedentesPerinatalesDTOS = new ArrayList<>();
        antecedentesPerinatales.forEach(antecedente -> {
            antecedentesPerinatalesDTOS.add(createAntecedentesPerinatalesDTO(antecedente));
        });

        return antecedentesPerinatalesDTOS;
    }

    public PacienteAntecedentesPerinatalesDTO getAntecedentesPerinatalesDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesPerinatales>> antecedentesPerinatalesOptional = antecedentesPerinatalesRepository.findByPaciente(paciente);

            if (!antecedentesPerinatalesOptional.isPresent() || antecedentesPerinatalesOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes perinatales registrados.");
            } else {
                List<AntecedentesPerinatales> antecedentesPerinatales = antecedentesPerinatalesOptional.get();
                List<AntecedentePerinatalDTO> antecedentePerinatalDTOList = new ArrayList<>();

                antecedentesPerinatales.forEach(antecedente -> {
                    antecedentePerinatalDTOList.add(createAntecedentePerinatalDTO(antecedente));
                });

                PacienteAntecedentesPerinatalesDTO pacienteAntecedentesPerinatalesDTO = new PacienteAntecedentesPerinatalesDTO();
                pacienteAntecedentesPerinatalesDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesPerinatalesDTO.setAntecedente_Perinatal(antecedentePerinatalDTOList);

                return pacienteAntecedentesPerinatalesDTO;
            }
        } else {
            throw new PacienteException("No existe el paciente con ID " + id);
        }

    }

    private PacienteAntecedentePerinatalDTO createAntecedentesPerinatalesDTO(AntecedentesPerinatales antecedente) {
        PacienteAntecedentePerinatalDTO antecedentesPerinatalesDTO = new PacienteAntecedentePerinatalDTO();
        PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesPerinatalesDTO.setPaciente(pacienteDTO);

        AntecedentePerinatalDTO antecedentePerinatalDTO = createAntecedentePerinatalDTO(antecedente);
        antecedentesPerinatalesDTO.setAntecedente_Perinatal(antecedentePerinatalDTO);

        return antecedentesPerinatalesDTO;
    }

    private AntecedentePerinatalDTO createAntecedentePerinatalDTO(AntecedentesPerinatales antecedente) {
        AntecedentePerinatalDTO antecedentePerinatalDTO = new AntecedentePerinatalDTO();


        antecedentePerinatalDTO.setNacimiento(antecedente.getNacimiento());
        antecedentePerinatalDTO.setSDG(antecedente.getSDG());
        antecedentePerinatalDTO.setAPGAR(antecedente.getAPGAR());
        antecedentePerinatalDTO.setTalla(antecedente.getTalla());
        antecedentePerinatalDTO.setEmbarazos(antecedente.getEmbarazos());
        antecedentePerinatalDTO.setPDP(antecedente.getPDP());



        return antecedentePerinatalDTO;
    }

    public String deleteAntecedentesPerinatales(Long id) throws Exception {
        AntecedentesPerinatales antecedentePerinatal = antecedentesPerinatalesRepository.findById(id)
                .orElseThrow(() -> new AntecedentesException("No se encontró ningún antecedente perinatal con ID " + id));

        antecedentesPerinatalesRepository.delete(antecedentePerinatal);

        return "Antecedente perinatal con ID " + id + " eliminado exitosamente.";
    }


}
