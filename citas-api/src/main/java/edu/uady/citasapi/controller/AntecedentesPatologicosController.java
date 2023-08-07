package edu.uady.citasapi.controller;

import edu.uady.citasapi.service.AntecedentesPatologicosService;
import edu.uady.pacientesapi.entity.AntecedentesPatologicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aPatologicos")
public class AntecedentesPatologicosController {
    @Autowired
    private AntecedentesPatologicosService antecedentesPatologicosService;

    @GetMapping
    public List<AntecedentesPatologicos> getAllAntecedentesPatologicos() {
        return antecedentesPatologicosService.getAllAntecedentesPatologicos();
    }

    @PostMapping
    public AntecedentesPatologicos createAntecedentesPatologicos(@RequestBody AntecedentesPatologicos antecedentesPatologicos){
        return antecedentesPatologicosService.createAntecedentesPatologicosRespository(antecedentesPatologicos);
    }

    @PutMapping
    public AntecedentesPatologicos updateAntecedentesPatologicos(@RequestBody AntecedentesPatologicos antecedentesPatologicos) {
        return antecedentesPatologicosService.updateAntecedentesPatologicosRespository(antecedentesPatologicos);
    }

    @DeleteMapping("/{id}")
    public void deleteAntecedentesPatologicos(@PathVariable (value = "id") Long id) {
        antecedentesPatologicosService.deleteAntecedentesPatologicos(id);
    }

}
