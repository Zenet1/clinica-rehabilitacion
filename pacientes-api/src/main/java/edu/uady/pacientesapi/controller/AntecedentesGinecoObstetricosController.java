package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;
import edu.uady.pacientesapi.service.AntecedentesGinecoObstetricosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aGinecoObstetricos")
public class AntecedentesGinecoObstetricosController {
    @Autowired
    private AntecedentesGinecoObstetricosService antecedentesGinecoObstetricosService;

    @GetMapping
    public List<AntecedentesGinecoObstetricos> getAllAntecedentesGinecoObstetricos() {
        return antecedentesGinecoObstetricosService.getAllAntecedentesGinecoObstetricos();
    }

    @PostMapping
    public AntecedentesGinecoObstetricos createAntecedentesGinecoObstetricos(@RequestBody AntecedentesGinecoObstetricos antecedentesGinecoObstetricos){
        return antecedentesGinecoObstetricosService.createAntecedentesGinecoObstetricosRespository(antecedentesGinecoObstetricos);
    }

    @PutMapping
    public AntecedentesGinecoObstetricos updateAntecedentesGinecoObstetricos(@RequestBody AntecedentesGinecoObstetricos antecedentesGinecoObstetricos) {
        return antecedentesGinecoObstetricosService.updateAntecedentesGinecoObstetricosRespository(antecedentesGinecoObstetricos);
    }

    @DeleteMapping("/{id}")
    public void deleteAntecedentesGinecoObstetricos(@PathVariable (value = "id") Long id) {
        antecedentesGinecoObstetricosService.deleteAntecedentesGinecoObstetricos(id);
    }
}
