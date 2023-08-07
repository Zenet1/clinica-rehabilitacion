package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.DiagnosticoDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.DiagnosticoService;
import edu.uady.citasapi.entity.Diagnostico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping
    public ResponseEntity<?> getAllDiagnosticos() {

        try {
            return ResponseEntity.ok().body(diagnosticoService.getAllDiagnosticos());
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDiagnostico(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.getDiagnostico(id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createDiagnostico(@RequestBody Diagnostico diagnostico) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.createDiagnostico(diagnostico));
        } catch (CitaException diagnosticoException) {
            String errorMessage = diagnosticoException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiagnostico(@RequestBody Diagnostico diagnostico, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.updateDiagnostico(diagnostico, id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiagnostico(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(diagnosticoService.deleteDiagnostico(id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
