package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.dto.PacienteDTO;
import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.error.PacienteException;
import edu.uady.pacientesapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getAllPacientes() {

        try {
            return ResponseEntity.ok().body(pacienteService.getAllPacientes());
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaciente(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(pacienteService.getPaciente(id));
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody Paciente paciente) {

        try {
            return ResponseEntity.ok().body(pacienteService.createPaciente(paciente));
        } catch (PacienteException pacienteException) {
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
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(pacienteService.deletePaciente(id));
        } catch (PacienteException pacienteException) {
            return new ResponseEntity<>(pacienteException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
