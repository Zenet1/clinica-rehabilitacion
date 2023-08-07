package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.RevaloracionDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.RevaloracionService;
import edu.uady.citasapi.entity.Revaloracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/revaloraciones")
public class RevaloracionController {

    @Autowired
    private RevaloracionService diagnosticoService;

    @GetMapping
    public ResponseEntity<?> getAllRevaloracions() {

        try {
            return ResponseEntity.ok().body(diagnosticoService.getAllRevaloracions());
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRevaloracion(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.getRevaloracion(id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createRevaloracion(@RequestBody Revaloracion diagnostico) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.createRevaloracion(diagnostico));
        } catch (CitaException diagnosticoException) {
            String errorMessage = diagnosticoException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRevaloracion(@RequestBody Revaloracion diagnostico, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(diagnosticoService.updateRevaloracion(diagnostico, id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRevaloracion(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(diagnosticoService.deleteRevaloracion(id));
        } catch (CitaException diagnosticoException) {
            return new ResponseEntity<>(diagnosticoException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
