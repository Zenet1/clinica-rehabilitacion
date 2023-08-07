package edu.uady.citasapi.controller;

import edu.uady.citasapi.error.AntecedentesException;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.CitaRepository;
import edu.uady.citasapi.service.AntecedentesFamiliaresService;
import edu.uady.citasapi.service.CitaService;
import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.entity.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/antecedentes-familiares")
public class AntecedentesFamiliaresController {

    @Autowired
    private AntecedentesFamiliaresService antecedentesFamiliaresService;

    @Autowired
    private CitaRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<?> getAllAntecedentesFamiliares() {

        try {
            return ResponseEntity.ok(antecedentesFamiliaresService.getAllAntecedentesFamiliares());
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id-paciente}")
    public ResponseEntity<?> getAntecedentesFamiliaresDelPaciente(@PathVariable(value = "id-paciente") Long id) {
        try {
            return ResponseEntity.ok(antecedentesFamiliaresService.getAntecedentesFamiliaresDelPaciente(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/{id-paciente}")
    public ResponseEntity<?> createAntecedentesFamiliares(@RequestBody AntecedentesFamiliares antecedentesFamiliares, @PathVariable(value = "id-paciente") Long id) {

        try {
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                antecedentesFamiliares.setPaciente(paciente);
            } else {
                throw new AntecedentesException("No se encuentra el paciente con ID " + id);
            }

            return new ResponseEntity<>(antecedentesFamiliaresService.createAntecedentesFamiliares(antecedentesFamiliares), HttpStatus.CREATED);
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }


    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateAntecedentesFamiliares(@RequestBody AntecedentesFamiliares antecedentesFamiliares, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesFamiliaresService.updateAntecedentesFamiliares(antecedentesFamiliares, id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAntecedentesFamiliares(@PathVariable (value = "id") Long id) {

        try {
            return ResponseEntity.ok(antecedentesFamiliaresService.deleteAntecedentesFamiliares(id));
        } catch (AntecedentesException antecedentesException) {
            return new ResponseEntity<>(antecedentesException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
