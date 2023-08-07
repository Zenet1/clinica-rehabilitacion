package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesPatologicos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.PacienteRepository;
import edu.uady.pacientesapi.service.AntecedentesPatologicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patologicos")
public class AntecedentesPatologicosController {
    @Autowired
    private AntecedentesPatologicosService antecedentesPatologicosService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<?> getAllAntecedentesPatologicos() {

        try {
            return ResponseEntity.ok(antecedentesPatologicosService.getAllAntecedentesPatologicos());
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/{id-paciente}")
    public ResponseEntity<?> createAntecedentesPatologico(@RequestBody AntecedentesPatologicos antecedentePatologico, @PathVariable(value = "id-paciente") Long id){

        try {
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                antecedentePatologico.setPaciente(paciente);
            } else {
                throw new AntecedentesException("No se encuentra el paciente con ID " + id);
            }

            return new ResponseEntity<>(antecedentesPatologicosService.createAntecedentePatologico(antecedentePatologico), HttpStatus.CREATED);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @GetMapping("/{id-paciente}")
    public ResponseEntity<?> getAntecedentesPatologicoDelPaciente(@PathVariable(value = "id-paciente") Long id) {
        try {
            return ResponseEntity.ok(antecedentesPatologicosService.getAntecedentesPatologicosDelPaciente(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAntecedentePatologico(@RequestBody AntecedentesPatologicos antecedentePatologico, @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(antecedentesPatologicosService.updateAntecedentePatologico(antecedentePatologico, id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAntecedentePatologico(@PathVariable (value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesPatologicosService.deleteAntecedentePatologico(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

}
