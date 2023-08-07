package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.dto.AntecedenteNoPatologicoDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedenteNoPatologicoDTO;
import edu.uady.pacientesapi.dto.PacienteAntecedentesNoPatologicosDTO;
import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.AntecedentesNoPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.AntecedentesNoPatologicosRepository;
import edu.uady.pacientesapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentesNoPatologicosService {
    @Autowired
    private AntecedentesNoPatologicosRepository antecedentesNoPatologicosRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteAntecedenteNoPatologicoDTO createAntecedenteNoPatologico(AntecedentesNoPatologicos antecedentesNoPatologicos) throws Exception {

        try {
            AntecedentesNoPatologicos antecedenteNoPatologicoCreated = antecedentesNoPatologicosRepository.save(antecedentesNoPatologicos);
            return createAntecedentesNoPatologicosDTO(antecedenteNoPatologicoCreated);
        } catch (Exception exception) {
            throw new AntecedentesException("Ha ocurrido un error al crear el antecedente no patologico");
        }

    }

    public PacienteAntecedenteNoPatologicoDTO updateAntecedenteNoPatologico(AntecedentesNoPatologicos antecedenteNoPatologico, Long id) throws Exception {

        Optional<AntecedentesNoPatologicos> antecedenteOptional = antecedentesNoPatologicosRepository.findById(id);

        if (antecedenteOptional.isPresent()) {
            AntecedentesNoPatologicos antecedenteNoPatologicoFound = antecedenteOptional.get();

            antecedenteNoPatologicoFound.setHabitos(antecedenteNoPatologico.getHabitos());
            antecedenteNoPatologicoFound.setBaño(antecedenteNoPatologico.getBaño());
            antecedenteNoPatologicoFound.setHabitacion(antecedenteNoPatologico.getHabitacion());
            antecedenteNoPatologicoFound.setTabaquismo(antecedenteNoPatologico.getTabaquismo());
            antecedenteNoPatologicoFound.setAlcoholismo(antecedenteNoPatologico.getAlcoholismo());
            antecedenteNoPatologicoFound.setVacunas(antecedenteNoPatologico.getVacunas());
            antecedenteNoPatologicoFound.setActividad_fisica(antecedenteNoPatologico.getActividad_fisica());
            antecedenteNoPatologicoFound.setAlimentacion(antecedenteNoPatologico.getAlimentacion());
            antecedenteNoPatologicoFound.setEstado_civil(antecedenteNoPatologico.getEstado_civil());
            antecedenteNoPatologicoFound.setZoonosis(antecedenteNoPatologico.getZoonosis());

            AntecedentesNoPatologicos antecedenteUpdated = antecedentesNoPatologicosRepository.save(antecedenteNoPatologicoFound);

            PacienteAntecedenteNoPatologicoDTO pacienteAntecedenteNoPatologicoDTO = new PacienteAntecedenteNoPatologicoDTO();
            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedenteUpdated.getPaciente());
            AntecedenteNoPatologicoDTO antecedenteNoPatologicoDTO = createAntecedenteNoPatologicoDTO(antecedenteUpdated);

            pacienteAntecedenteNoPatologicoDTO.setPaciente(pacienteDTO);
            pacienteAntecedenteNoPatologicoDTO.setAntecedente_No_Patologico(antecedenteNoPatologicoDTO);

            return pacienteAntecedenteNoPatologicoDTO;
        } else {
            throw new AntecedentesException("No existe algún antecedente gineco obstetrico con ID " + id);
        }

    }

    public List<PacienteAntecedenteNoPatologicoDTO> getAllAntecedentesNoPatologicos() throws Exception {

        List<AntecedentesNoPatologicos> antecedentesGinecoObstetricos = antecedentesNoPatologicosRepository.findAll();

        if (antecedentesGinecoObstetricos.isEmpty()) {
            throw new AntecedentesException("No hay antecedentes no patologicos registrados.");
        }

        List<PacienteAntecedenteNoPatologicoDTO> antecedenteGinecoObstetricoDTOS = new ArrayList<>();
        antecedentesGinecoObstetricos.forEach(antecedente -> {
            antecedenteGinecoObstetricoDTOS.add(createAntecedentesNoPatologicosDTO(antecedente));
        });

        return antecedenteGinecoObstetricoDTOS;
    }

    public String deleteAntecedenteNoPatologico(Long id) throws Exception {
        AntecedentesNoPatologicos antecedenteNoPatologico = antecedentesNoPatologicosRepository.findById(id)
                .orElseThrow(() -> new AntecedentesException("No se encontró ningún antecedente no patologico con ID " + id));

        antecedentesNoPatologicosRepository.delete(antecedenteNoPatologico);
        return "Antecedente no patologico con ID " + id + " eliminado exitosamente";
    }

    private PacienteAntecedenteNoPatologicoDTO createAntecedentesNoPatologicosDTO(AntecedentesNoPatologicos antecedente) {
        PacienteAntecedenteNoPatologicoDTO antecedentesNoPatologicoDTO = new PacienteAntecedenteNoPatologicoDTO();
        PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(antecedente.getPaciente());

        antecedentesNoPatologicoDTO.setPaciente(pacienteDTO);
        AntecedenteNoPatologicoDTO antecedenteNoPatologicoDTO = createAntecedenteNoPatologicoDTO(antecedente);
        antecedentesNoPatologicoDTO.setAntecedente_No_Patologico(antecedenteNoPatologicoDTO);

        return antecedentesNoPatologicoDTO;
    }

    private AntecedenteNoPatologicoDTO createAntecedenteNoPatologicoDTO(AntecedentesNoPatologicos antecedente) {
        AntecedenteNoPatologicoDTO antecedenteNoPatologicoDTO = new AntecedenteNoPatologicoDTO();

        antecedenteNoPatologicoDTO.setHabitos(antecedente.getHabitos());
        antecedenteNoPatologicoDTO.setBaño(antecedente.getBaño());
        antecedenteNoPatologicoDTO.setHabitacion(antecedente.getHabitacion());
        antecedenteNoPatologicoDTO.setTabaquismo(antecedente.getTabaquismo());
        antecedenteNoPatologicoDTO.setAlcoholismo(antecedente.getAlcoholismo());
        antecedenteNoPatologicoDTO.setVacunas(antecedente.getVacunas());
        antecedenteNoPatologicoDTO.setActividad_fisica(antecedente.getActividad_fisica());
        antecedenteNoPatologicoDTO.setAlimentacion(antecedente.getAlimentacion());
        antecedenteNoPatologicoDTO.setEstado_civil(antecedente.getEstado_civil());
        antecedenteNoPatologicoDTO.setZoonosis(antecedente.getZoonosis());

        return antecedenteNoPatologicoDTO;
    }

    public PacienteAntecedentesNoPatologicosDTO getAntecedentesNoPatologicosDelPaciente(Long id) throws Exception {

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            PacienteDTO pacienteDTO = pacienteService.createPacienteDTO(paciente);
            Optional<List<AntecedentesNoPatologicos>> antecedentesOptional = antecedentesNoPatologicosRepository.findByPaciente(paciente);

            if (!antecedentesOptional.isPresent() || antecedentesOptional.isEmpty()) {
                throw new AntecedentesException("El paciente con ID " + id + " no tiene antecedentes no patologicos registrados.");
            } else {
                List<AntecedentesNoPatologicos> antecedentes = antecedentesOptional.get();
                List<AntecedenteNoPatologicoDTO> antecedenteNoPatologicoDTOS = new ArrayList<>();

                antecedentes.forEach(antecedente -> {
                    antecedenteNoPatologicoDTOS.add(createAntecedenteNoPatologicoDTO(antecedente));
                });

                PacienteAntecedentesNoPatologicosDTO pacienteAntecedentesNoPatologicosDTO = new PacienteAntecedentesNoPatologicosDTO();
                pacienteAntecedentesNoPatologicosDTO.setPaciente(pacienteDTO);
                pacienteAntecedentesNoPatologicosDTO.setAntecedente_No_Patologico(antecedenteNoPatologicoDTOS);

                return pacienteAntecedentesNoPatologicosDTO;
            }
        } else {
            throw new PacienteException("No existe el paciente con ID " + id);
        }

    }
}
