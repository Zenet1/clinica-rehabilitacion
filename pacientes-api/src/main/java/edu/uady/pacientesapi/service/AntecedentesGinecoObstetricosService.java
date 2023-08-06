package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.entity.AntecedentesGinecoObstetricos;
import edu.uady.pacientesapi.repository.AntecedentesGinecoObstetricosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesGinecoObstetricosService {
    @Autowired
    private AntecedentesGinecoObstetricosRepository antecedentesGinecoObstetricosRepository;

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
