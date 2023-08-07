package edu.uady.citasapi.controller;

import edu.uady.citasapi.entity.ExploracionFisica;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.service.ExploracionFisicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exploraciones-fisicas")
public class ExploracionFisicaController {

    @Autowired
    private ExploracionFisicaService exploracionFisicaService;

    @GetMapping
    public ResponseEntity<?> getAllExploraciones() {

        try {
            return ResponseEntity.ok().body(exploracionFisicaService.getAllExploraciones());
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExploracion(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(exploracionFisicaService.getExploracion(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstudio(@RequestBody ExploracionFisica exploracion) {

        try {
            return ResponseEntity.ok().body(exploracionFisicaService.createExploracion(exploracion));
        } catch (RegistroException e) {
            String errorMessage = e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExploracion(@RequestBody ExploracionFisica exploracion, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(exploracionFisicaService.updateExploracion(exploracion, id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExploracion(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(exploracionFisicaService.deleteExploracion(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
