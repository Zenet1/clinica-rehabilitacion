package edu.uady.citasapi.controller;

import edu.uady.citasapi.entity.Padecimiento;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.service.PadecimientoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/padecimientos")
public class PadecimientoController {

    @Autowired
    private PadecimientoService padecimientoService;

    @GetMapping
    public ResponseEntity<?> getAllPadecimientos() {

        try {
            return ResponseEntity.ok().body(padecimientoService.getAllPadecimientos());
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/padecimientos/{id}")
    public ResponseEntity<?> getPadecimiento(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(padecimientoService.getPadecimiento(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping("/padecimientos")
    public ResponseEntity<?> createPadecimiento(@RequestBody Padecimiento padecimiento) {

        try {
            return ResponseEntity.ok().body(padecimientoService.createPadecimiento(padecimiento));
        } catch (RegistroException e) {
            String errorMessage = e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/padecimientos/{id}")
    public ResponseEntity<?> updatePadecimiento(@RequestBody Padecimiento padecimiento, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(padecimientoService.updatePadecimiento(padecimiento, id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/padecimientos/{id}")
    public ResponseEntity<?> deletePadecimiento(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(padecimientoService.deletePadecimiento(id));
        } catch (RegistroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}