package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.PacienteTypeDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.PacienteTypeService;
import edu.uady.citasapi.entity.PacienteType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacienteType")
public class PacienteTypeController {

    @Autowired
    private PacienteTypeService pacienteTypeService;

    @GetMapping
    public ResponseEntity<?> getAllPacienteType() {

        try {
            return ResponseEntity.ok().body(pacienteTypeService.getAllPacienteType());
        } catch (CitaException pacienteTypeException) {
            return new ResponseEntity<>(pacienteTypeException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPacienteType(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(pacienteTypeService.getPacienteType(id));
        } catch (CitaException pacienteTypeException) {
            return new ResponseEntity<>(pacienteTypeException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPacienteType(@RequestBody PacienteType pacienteType) {

        try {
            return ResponseEntity.ok().body(pacienteTypeService.createPacienteType(pacienteType));
        } catch (CitaException pacienteTypeException) {
            String errorMessage = pacienteTypeException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePacienteType(@RequestBody PacienteType pacienteType, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(pacienteTypeService.updatePacienteType(pacienteType, id));
        } catch (CitaException pacienteTypeException) {
            return new ResponseEntity<>(pacienteTypeException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePacienteType(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(pacienteTypeService.deletePacienteType(id));
        } catch (CitaException pacienteTypeException) {
            return new ResponseEntity<>(pacienteTypeException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
