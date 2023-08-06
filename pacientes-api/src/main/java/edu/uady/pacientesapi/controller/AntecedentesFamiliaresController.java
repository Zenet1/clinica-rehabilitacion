package edu.uady.pacientesapi.controller;

import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.service.AntecedentesFamiliaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aFamiliares")
public class AntecedentesFamiliaresController {

    @Autowired
    private AntecedentesFamiliaresService antecedentesFamiliaresService;

    @GetMapping
    public List<AntecedentesFamiliares> getAllAntecedentesFamiliares() {
        return antecedentesFamiliaresService.getAllAntecedentesFamiliares();
    }

    @PostMapping
    public AntecedentesFamiliares createAntecedentesFamiliares(@RequestBody AntecedentesFamiliares antecedentesFamiliares){
        return antecedentesFamiliaresService.createAntecedentesFamiliaresRespository(antecedentesFamiliares);
    }

    @PutMapping
    public AntecedentesFamiliares updateAntecedentesFamiliares(@RequestBody AntecedentesFamiliares antecedentesFamiliares) {
        return antecedentesFamiliaresService.updateAntecedentesFamiliaresRespository(antecedentesFamiliares);
    }

    @DeleteMapping("/{id}")
    public void deleteAntecedentesFamiliares(@PathVariable (value = "id") Long id) {
        antecedentesFamiliaresService.deleteAntecedentesFamiliares(id);
    }
}
