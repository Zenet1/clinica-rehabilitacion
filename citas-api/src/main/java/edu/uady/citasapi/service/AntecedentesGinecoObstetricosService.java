package edu.uady.citasapi.service;

import edu.uady.citasapi.repository.CatalogoSistemasRepository;
import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesGinecoObstetricosService {
    @Autowired
    private CatalogoSistemasRepository antecedentesGinecoObstetricosRepository;

    public AntecedentesGinecoObstetricos createAntecedentesGinecoObstetricosRespository(AntecedentesGinecoObstetricos antecedentesGinecoObstetricos){
        return antecedentesGinecoObstetricosRepository.save(antecedentesGinecoObstetricos);
    }

    public AntecedentesGinecoObstetricos updateAntecedentesGinecoObstetricosRespository(AntecedentesGinecoObstetricos antecedentesGinecoObstetricos){
        return antecedentesGinecoObstetricosRepository.save(antecedentesGinecoObstetricos);
    }

    public List<AntecedentesGinecoObstetricos> getAllAntecedentesGinecoObstetricos(){
        return antecedentesGinecoObstetricosRepository.findAll();
    }

    public void deleteAntecedentesGinecoObstetricos(Long id){
        antecedentesGinecoObstetricosRepository.deleteById(id);
    }


}
