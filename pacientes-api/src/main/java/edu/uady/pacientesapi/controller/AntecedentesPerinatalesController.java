package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesPerinatales;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.AntecedentesException;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.repository.PacienteRepository;
import edu.uady.pacientesapi.service.AntecedentesPerinatalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/perinatales")
public class AntecedentesPerinatalesController {
    @Autowired
    private AntecedentesPerinatalesService antecedentesPerinatalesService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<?> getAllAntecedentesPerinatales() {

        try {
            return ResponseEntity.ok(antecedentesPerinatalesService.getAllAntecedentesPerinatales());
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/{id-paciente}")
    public ResponseEntity<?> createAntecedentesPerinatales(@RequestBody AntecedentesPerinatales antecedentePerinatal, @PathVariable(value = "id-paciente") Long id){

        try {
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                antecedentePerinatal.setPaciente(paciente);
            } else {
                throw new AntecedentesException("No se encuentra el paciente con ID " + id);
            }

            return new ResponseEntity<>(antecedentesPerinatalesService.createAntecedentesPerinatales(antecedentePerinatal), HttpStatus.CREATED);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @GetMapping("/{id-paciente}")
    public ResponseEntity<?> getAntecedentesPerinatalesDelPaciente(@PathVariable(value = "id-paciente") Long id) {
        try {
            return ResponseEntity.ok(antecedentesPerinatalesService.getAntecedentesPerinatalesDelPaciente(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAntecedentePerinatal(@RequestBody AntecedentesPerinatales antecedentePerinatal, @PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.ok(antecedentesPerinatalesService.updateAntecedentesPerinatales(antecedentePerinatal, id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAntecedentePerinatal(@PathVariable (value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesPerinatalesService.deleteAntecedentesPerinatales(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

}
