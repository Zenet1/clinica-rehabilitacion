package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesPatologicos;
import edu.uady.pacientesapi.service.AntecedentesPatologicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aPatalogicos")
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
