package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.CitaStatusDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.CitaStatusService;
import edu.uady.citasapi.entity.CitaStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/citaStatus")
public class CitaStatusController {

    @Autowired
    private CitaStatusService citaStatusService;

    @GetMapping
    public ResponseEntity<?> getAllCitaStatus() {

        try {
            return ResponseEntity.ok().body(citaStatusService.getAllCitaStatus());
        } catch (CitaException citaStatusException) {
            return new ResponseEntity<>(citaStatusException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCitaStatus(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(citaStatusService.getCitaStatus(id));
        } catch (CitaException citaStatusException) {
            return new ResponseEntity<>(citaStatusException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCitaStatus(@RequestBody CitaStatus citaStatus) {

        try {
            return ResponseEntity.ok().body(citaStatusService.createCitaStatus(citaStatus));
        } catch (CitaException citaStatusException) {
            String errorMessage = citaStatusException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCitaStatus(@RequestBody CitaStatus citaStatus, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(citaStatusService.updateCitaStatus(citaStatus, id));
        } catch (CitaException citaStatusException) {
            return new ResponseEntity<>(citaStatusException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCitaStatus(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(citaStatusService.deleteCitaStatus(id));
        } catch (CitaException citaStatusException) {
            return new ResponseEntity<>(citaStatusException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
