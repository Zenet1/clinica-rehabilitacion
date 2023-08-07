package edu.uady.citasapi.controller;

import edu.uady.citasapi.entity.Estudios;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.service.EstudiosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estudios")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    @GetMapping
    public ResponseEntity<?> getAllEstudios() {

        try {
            return ResponseEntity.ok().body(estudiosService.getAllEstudios());
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/estudios/{id}")
    public ResponseEntity<?> getEstudio(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(estudiosService.getEstudio(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/estudios")
    public ResponseEntity<?> createEstudio(@RequestBody Estudios estudio) {

        try {
            return ResponseEntity.ok().body(estudiosService.createEstudio(estudio));
        } catch (RegistroException e) {
            String errorMessage = e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/estudios/{id}")
    public ResponseEntity<?> updateEstudio(@RequestBody Estudios estudio, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(estudiosService.updateEstudio(estudio, id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/estudios/{id}")
    public ResponseEntity<?> deleteEstudio(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(estudiosService.deleteEstudio(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
