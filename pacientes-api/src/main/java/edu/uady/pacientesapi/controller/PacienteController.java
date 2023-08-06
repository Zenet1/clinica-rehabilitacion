package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.Paciente;
import edu.uady.pacientesapi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente) {
        return pacienteService.updatePaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable (value = "id") Long id) {
        pacienteService.deletePaciente(id);
    }
}
