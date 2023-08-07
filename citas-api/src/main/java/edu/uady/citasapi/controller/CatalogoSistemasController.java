package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.CatalogoSistemasDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.CatalogoSistemasService;
import edu.uady.citasapi.entity.CatalogoSistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/catalogosSistemas")
public class CatalogoSistemasController {

    @Autowired
    private CatalogoSistemasService catalogoSistemasService;

    @GetMapping
    public ResponseEntity<?> getAllCatalogosSistemas() {

        try {
            return ResponseEntity.ok().body(catalogoSistemasService.getAllCatalogoSistemas());
        } catch (CitaException catalogoSistemasException) {
            return new ResponseEntity<>(catalogoSistemasException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCatalogoSistemas(@PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(catalogoSistemasService.getCatalogoSistemas(id));
        } catch (CitaException catalogoSistemasException) {
            return new ResponseEntity<>(catalogoSistemasException.getMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCatalogoSistemas(@RequestBody CatalogoSistemas catalogoSistemas) {

        try {
            return ResponseEntity.ok().body(catalogoSistemasService.createCatalogoSistemas(catalogoSistemas));
        } catch (CitaException catalogoSistemasException) {
            String errorMessage = catalogoSistemasException.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCatalogoSistemas(@RequestBody CatalogoSistemas catalogoSistemas, @PathVariable(value = "id") Long id) {

        try {
            return ResponseEntity.ok().body(catalogoSistemasService.updateCatalogoSistemas(catalogoSistemas, id));
        } catch (CitaException catalogoSistemasException) {
            return new ResponseEntity<>(catalogoSistemasException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCatalogoSistemas(@PathVariable (value = "id") Long id) {
        try {
            return ResponseEntity.ok().body(catalogoSistemasService.deleteCatalogoSistemas(id));
        } catch (CitaException catalogoSistemasException) {
            return new ResponseEntity<>(catalogoSistemasException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
