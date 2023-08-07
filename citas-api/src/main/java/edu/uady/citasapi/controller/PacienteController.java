package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.CitaDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.CitaService;
import edu.uady.pacientesapi.entity.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

    @Autowired
    private CitaService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAllPacientes() {

        try {
            return ResponseEntity.ok().body(pacienteService.getAllPacientes());
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaciente(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(pacienteService.getPaciente(id));
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody Paciente paciente) {

        try {
            return ResponseEntity.ok().body(pacienteService.createPaciente(paciente));
        } catch (CitaException pacienteException) {
            String errorMessage = pacienteException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@RequestBody Paciente paciente, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(pacienteService.updatePaciente(paciente, id));
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(pacienteService.deletePaciente(id));
        } catch (CitaException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
