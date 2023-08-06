package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.entity.AntecedentesPerinatales;
import edu.uady.pacientesapi.repository.AntecedentesPerinatalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesPerinatalesService {
    @Autowired
    private AntecedentesPerinatalesRepository antecedentesPerinatalesRepository;

    public AntecedentesPerinatales createAntecedentesPerinatalesRespository(AntecedentesPerinatales antecedentesPerinatales){
        return antecedentesPerinatalesRepository.save(antecedentesPerinatales);
    }

    public AntecedentesPerinatales updateAntecedentesPerinatalesRespository(AntecedentesPerinatales antecedentesPerinatales){
        return antecedentesPerinatalesRepository.save(antecedentesPerinatales);
    }

    public List<AntecedentesPerinatales> getAllAntecedentesPerinatales(){
        return antecedentesPerinatalesRepository.findAll();
    }

    public void deleteAntecedentesPerinatales(Long id){
        antecedentesPerinatalesRepository.deleteById(id);
    }
}
