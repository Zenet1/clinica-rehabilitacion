package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.service.AntecedentesNoPatologicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aPatologicos")
public class AntecedentesNoPatologicosController {
    @Autowired
    private AntecedentesNoPatologicosService antecedentesNoPatologicosService;

    @GetMapping
    public List<edu.uady.pacientesapi.entity.AntecedentesNoPatologicos> getAllAntecedentesNoPatologicos() {
        return antecedentesNoPatologicosService.getAllAntecedentesNoPatologicos();
    }

    @PostMapping
    public edu.uady.pacientesapi.entity.AntecedentesNoPatologicos createAntecedentesNoPatologicos(@RequestBody edu.uady.pacientesapi.entity.AntecedentesNoPatologicos antecedentesNoPatologicos){
        return antecedentesNoPatologicosService.createAntecedentesNoPatologicosRespository(antecedentesNoPatologicos);
    }

    @PutMapping
    public edu.uady.pacientesapi.entity.AntecedentesNoPatologicos updateAntecedentesNoPatologicos(@RequestBody edu.uady.pacientesapi.entity.AntecedentesNoPatologicos antecedentesNoPatologicos) {
        return antecedentesNoPatologicosService.updateAntecedentesNoPatologicosRespository(antecedentesNoPatologicos);
    }

    @DeleteMapping("/{id}")
    public void deleteAntecedentesNoPatologicos(@PathVariable (value = "id") Long id) {
        antecedentesNoPatologicosService.deleteAntecedentesNoPatologicos(id);
    }
}
