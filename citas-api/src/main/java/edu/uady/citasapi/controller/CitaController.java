package edu.uady.citasapi.controller;

import edu.uady.citasapi.dto.CitaDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.service.CitaService;
import edu.uady.citasapi.entity.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;

	@GetMapping
	public ResponseEntity<?> getAllCitas() {

		try {
			return ResponseEntity.ok().body(citaService.getAllCitas());
		} catch (CitaException citaException) {
			return new ResponseEntity<>(citaException.getMessage(), HttpStatus.OK);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCita(@PathVariable(value = "id") Long id) {

		try {
			return ResponseEntity.ok().body(citaService.getCita(id));
		} catch (CitaException citaException) {
			return new ResponseEntity<>(citaException.getMessage(), HttpStatus.OK);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@PostMapping
	public ResponseEntity<?> createCita(@RequestBody Cita cita) {

		try {
			return ResponseEntity.ok().body(citaService.createCita(cita));
		} catch (CitaException citaException) {
			String errorMessage = citaException.getMessage();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCita(@RequestBody Cita cita, @PathVariable(value = "id") Long id) {

		try {
			return ResponseEntity.ok().body(citaService.updateCita(cita, id));
		} catch (CitaException citaException) {
			return new ResponseEntity<>(citaException.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCita(@PathVariable(value = "id") Long id) {
		try {
			return ResponseEntity.ok().body(citaService.deleteCita(id));
		} catch (CitaException citaException) {
			return new ResponseEntity<>(citaException.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}
