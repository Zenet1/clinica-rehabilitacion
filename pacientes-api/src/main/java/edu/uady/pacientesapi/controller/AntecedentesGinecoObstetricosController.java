package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.PacienteRepository;
import edu.uady.pacientesapi.service.AntecedentesGinecoObstetricosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/aGinecoObstetricos")
public class AntecedentesGinecoObstetricosController {

    @Autowired
    private AntecedentesGinecoObstetricosService antecedentesGinecoObstetricosService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<?> getAllAntecedentesGinecoObstetricos() {

        try {
            return ResponseEntity.ok(antecedentesGinecoObstetricosService.getAllAntecedentesGinecoObstetricos());
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/{id-paciente}")
    public ResponseEntity<?> createAntecedentesGinecoObstetricos(@RequestBody AntecedentesGinecoObstetricos antecedentesGinecoObstetricos, @PathVariable(value = "id-paciente") Long id){

        try {
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                antecedentesGinecoObstetricos.setPaciente(paciente);
            } else {
                throw new AntecedentesException("No se encuentra el paciente con ID " + id);
            }

            return new ResponseEntity<>(antecedentesGinecoObstetricosService.createAntecedentesGinecoObstetricos(antecedentesGinecoObstetricos), HttpStatus.CREATED);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @GetMapping("/{id-paciente}")
    public ResponseEntity<?> getAntecedentesGinecoObstetricosDelPaciente(@PathVariable(value = "id-paciente") Long id) {
        try {
            return ResponseEntity.ok(antecedentesGinecoObstetricosService.getAntecedentesGinecoObstetricosDelPaciente(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAntecedentesGinecoObstetricos(@RequestBody AntecedentesGinecoObstetricos antecedentesGinecoObstetricos, @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(antecedentesGinecoObstetricosService.updateAntecedentesGinecoObstetricos(antecedentesGinecoObstetricos, id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAntecedentesGinecoObstetricos(@PathVariable (value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesGinecoObstetricosService.deleteAntecedentesGinecoObstetricos(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }
}
