package edu.uady.citasapi.controller;

import edu.uady.citasapi.service.AntecedentesPerinatalesService;
import edu.uady.pacientesapi.entity.AntecedentesPerinatales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aPerinatales")
public class AntecedentesPerinatalesController {

    @Autowired
    private AntecedentesPerinatalesService antecedentesPerinatalesService;

    @GetMapping
    public List<AntecedentesPerinatales> getAllAntecedentesPerinatales() {
        return antecedentesPerinatalesService.getAllAntecedentesPerinatales();
    }

    @PostMapping
    public AntecedentesPerinatales createAntecedentesPerinatales(@RequestBody AntecedentesPerinatales antecedentesPerinatales){
        return antecedentesPerinatalesService.createAntecedentesPerinatalesRespository(antecedentesPerinatales);
    }

    @PutMapping
    public AntecedentesPerinatales updateAntecedentesPerinatales(@RequestBody AntecedentesPerinatales antecedentesPerinatales) {
        return antecedentesPerinatalesService.updateAntecedentesPerinatalesRespository(antecedentesPerinatales);
    }

    @DeleteMapping("/{id}")
    public void deleteAntecedentesPerinatales(@PathVariable (value = "id") Long id) {
        antecedentesPerinatalesService.deleteAntecedentesPerinatales(id);
    }
}
