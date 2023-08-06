package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesNoPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.PacienteRepository;
import edu.uady.pacientesapi.service.AntecedentesNoPatologicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/no-patologicos")
public class AntecedentesNoPatologicosController {
    @Autowired
    private AntecedentesNoPatologicosService antecedentesNoPatologicosService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<?> getAllAntecedentesNoPatologicos() {

        try {
            return ResponseEntity.ok(antecedentesNoPatologicosService.getAllAntecedentesNoPatologicos());
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/{id-paciente}")
    public ResponseEntity<?> createAntecedentesGinecoObstetricos(@RequestBody AntecedentesNoPatologicos antecedenteNoPatologico, @PathVariable(value = "id-paciente") Long id){

        try {
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                antecedenteNoPatologico.setPaciente(paciente);
            } else {
                throw new AntecedentesException("No se encuentra el paciente con ID " + id);
            }

            return new ResponseEntity<>(antecedentesNoPatologicosService.createAntecedenteNoPatologico(antecedenteNoPatologico), HttpStatus.CREATED);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @GetMapping("/{id-paciente}")
    public ResponseEntity<?> getAntecedentesGinecoObstetricosDelPaciente(@PathVariable(value = "id-paciente") Long id) {
        try {
            return ResponseEntity.ok(antecedentesNoPatologicosService.getAntecedentesNoPatologicosDelPaciente(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAntecedenteNoPatologico(@RequestBody AntecedentesNoPatologicos antecedenteNoPatologico, @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(antecedentesNoPatologicosService.updateAntecedenteNoPatologico(antecedenteNoPatologico, id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAntecedenteNoPatologico(@PathVariable (value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesNoPatologicosService.deleteAntecedenteNoPatologico(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

}
