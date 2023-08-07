package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.AntecedentePatologicoDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentePatologicoDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentesPatologicosDTO;
import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.AntecedentesPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.AntecedentesPatologicosRepository;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesPatologicosService {
    @Autowired
    private AntecedentesPatologicosRepository antecedentesPatologicosRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteAntecedentePatologicoDTO createAntecedentePatologico(AntecedentesPatologicos antecedentesPatologicos) throws Exception {

        try {
            AntecedentesPatologicos antecedentePatologicoCreated = antecedentesPatologicosRepository.save(antecedentesPatologicos);
            return createAntecedentesPatologicosDTO(antecedentePatologicoCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente patologico");
        }

    }

    public PacienteAntecedentePatologicoDTO updateAntecedentePatologico(AntecedentesPatologicos antecedentePatologico, Long id) throws Exception {

        Optional<AntecedentesPatologicos> antecedenteOptional = antecedentesPatologicosRepository.findById(id);

        if (antecedenteOptional.isPresent()) {
            AntecedentesPatologicos antecedentePatologicoFound = antecedenteOptional.get();

            antecedentePatologicoFound.setCirugias(antecedentePatologico.getCirugias());
            antecedentePatologicoFound.setAdicciones(antecedentePatologico.getAdicciones());
            antecedentePatologicoFound.setTraumatismos(antecedentePatologico.getTraumatismos());
            antecedentePatologicoFound.setETS(antecedentePatologico.getETS());
            antecedentePatologicoFound.setAlergias(antecedentePatologico.getAlergias());
            antecedentePatologicoFound.setPadecimientos_articulares(antecedentePatologico.getPadecimientos_articulares());


            AntecedentesPatologicos antecedenteUpdated = antecedentesPatologicosRepository.save(antecedentePatologicoFound);

            PacienteAntecedentePatologicoDTO pacienteAntecedentePatologicoDTO = new PacienteAntecedentePatologicoDTO();
            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedenteUpdated.getPaciente());
            AntecedentePatologicoDTO antecedentePatologicoDTO = createAntecedentePatologicoDTO(antecedenteUpdated);

            pacienteAntecedentePatologicoDTO.setPaciente(pacienteDTO);
            pacienteAntecedentePatologicoDTO.setAntecedente_Patologico(antecedentePatologicoDTO);

            return pacienteAntecedentePatologicoDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente patologico con ID " + id);
        }

    }

    public List<PacienteAntecedentePatologicoDTO> getAllAntecedentesPatologicos() throws Exception {

        List<AntecedentesPatologicos> antecedentesPatologicos = antecedentesPatologicosRepository.findAll();

        if (antecedentesPatologicos.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes patologicos registrados.");
        }

        List<PacienteAntecedentePatologicoDTO> antecedentePatologicoDTOS = new ArrayList<>();
        antecedentesPatologicos.forEach(antecedente -> {
            antecedentePatologicoDTOS.add(createAntecedentesPatologicosDTO(antecedente));
        });

        return antecedentePatologicoDTOS;
    }

    public String deleteAntecedentePatologico(Long id) throws Exception {
        AntecedentesPatologicos antecedentePatologico = antecedentesPatologicosRepository.findById(id)
                .orElseThrow(() -> new AntecedentesException("No se encontró ningún antecedente patologico con ID " + id));

        antecedentesPatologicosRepository.delete(antecedentePatologico);
        return "Antecedente patologico con ID " + id + " eliminado exitosamente";
    }

    private PacienteAntecedentePatologicoDTO createAntecedentesPatologicosDTO(AntecedentesPatologicos antecedente) {
        PacienteAntecedentePatologicoDTO antecedentesPatologicoDTO = new PacienteAntecedentePatologicoDTO();
        PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesPatologicoDTO.setPaciente(pacienteDTO);
        AntecedentePatologicoDTO antecedentePatologicoDTO = createAntecedentePatologicoDTO(antecedente);
        antecedentesPatologicoDTO.setAntecedente_Patologico(antecedentePatologicoDTO);

        return antecedentesPatologicoDTO;
    }

    private AntecedentePatologicoDTO createAntecedentePatologicoDTO(AntecedentesPatologicos antecedente) {
        AntecedentePatologicoDTO antecedentePatologicoDTO = new AntecedentePatologicoDTO();


        antecedentePatologicoDTO.setCirugias(antecedente.getCirugias());
        antecedentePatologicoDTO.setAdicciones(antecedente.getAdicciones());
        antecedentePatologicoDTO.setTraumatismos(antecedente.getTraumatismos());
        antecedentePatologicoDTO.setETS(antecedente.getETS());
        antecedentePatologicoDTO.setAlergias(antecedente.getAlergias());
        antecedentePatologicoDTO.setPadecimientos_articulares(antecedente.getPadecimientos_articulares());

        return antecedentePatologicoDTO;
    }

    public PacienteAntecedentesPatologicosDTO getAntecedentesPatologicosDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesPatologicos>> antecedentesOptional = antecedentesPatologicosRepository.findByPaciente(paciente);

            if (!antecedentesOptional.isPresent() || antecedentesOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes patologicos registrados.");
            } else {
                List<AntecedentesPatologicos> antecedentes = antecedentesOptional.get();
                List<AntecedentePatologicoDTO> antecedentePatologicoDTOS = new ArrayList<>();

                antecedentes.forEach(antecedente -> {
                    antecedentePatologicoDTOS.add(createAntecedentePatologicoDTO(antecedente));
                });

                PacienteAntecedentesPatologicosDTO pacienteAntecedentesPatologicosDTO = new PacienteAntecedentesPatologicosDTO();
                pacienteAntecedentesPatologicosDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesPatologicosDTO.setAntecedente_Patologico(antecedentePatologicoDTOS);

                return pacienteAntecedentesPatologicosDTO;
            }
        } else {
            throw new PacienteException("No existe el paciente con ID " + id);
        }

    }
}
