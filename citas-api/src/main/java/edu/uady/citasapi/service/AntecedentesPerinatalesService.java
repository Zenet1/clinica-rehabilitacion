package edu.uady.citasapi.service;

import edu.uady.citasapi.repository.CitaStatusRepository;
import edu.uady.pacientesapi.entity.AntecedentesPerinatales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesPerinatalesService {
    @Autowired
    private CitaStatusRepository antecedentesPerinatalesRepository;

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
