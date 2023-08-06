package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.entity.AntecedentesFamiliares;
import edu.uady.pacientesapi.repository.AntecedentesFamiliaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesFamiliaresService {
    @Autowired
    private AntecedentesFamiliaresRepository antecedentesFamiliaresRepository;

    public AntecedentesFamiliares createAntecedentesFamiliaresRespository(AntecedentesFamiliares antecedentesFamiliares){
        return antecedentesFamiliaresRepository.save(antecedentesFamiliares);
    }

    public AntecedentesFamiliares updateAntecedentesFamiliaresRespository(AntecedentesFamiliares antecedentesFamiliares){
        return antecedentesFamiliaresRepository.save(antecedentesFamiliares);
    }

    public List<AntecedentesFamiliares> getAllAntecedentesFamiliares(){
        return antecedentesFamiliaresRepository.findAll();
    }

    public void deleteAntecedentesFamiliares(Long id){
        antecedentesFamiliaresRepository.deleteById(id);
    }


}
