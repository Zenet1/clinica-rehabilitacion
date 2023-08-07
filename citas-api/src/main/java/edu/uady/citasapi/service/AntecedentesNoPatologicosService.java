package edu.uady.citasapi.service;

import edu.uady.citasapi.repository.RevaloracionRepository;
import edu.uady.pacientesapi.entity.AntecedentesNoPatologicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesNoPatologicosService {
    @Autowired
    private RevaloracionRepository antecedentesNoPatologicosRepository;

    public AntecedentesNoPatologicos createAntecedentesNoPatologicosRespository(AntecedentesNoPatologicos antecedentesNoPatologicos){
        return antecedentesNoPatologicosRepository.save(antecedentesNoPatologicos);
    }

    public AntecedentesNoPatologicos updateAntecedentesNoPatologicosRespository(AntecedentesNoPatologicos antecedentesNoPatologicos){
        return antecedentesNoPatologicosRepository.save(antecedentesNoPatologicos);
    }

    public List<AntecedentesNoPatologicos> getAllAntecedentesNoPatologicos(){
        return antecedentesNoPatologicosRepository.findAll();
    }

    public void deleteAntecedentesNoPatologicos(Long id){
        antecedentesNoPatologicosRepository.deleteById(id);
    }
}
