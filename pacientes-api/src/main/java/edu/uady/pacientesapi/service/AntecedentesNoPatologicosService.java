package edu.uady.pacientesapi.service;

import edu.uady.pacientesapi.entity.AntecedentesNoPatologicos;
import edu.uady.pacientesapi.repository.AntecedentesNoPatologicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesNoPatologicosService {
    @Autowired
    private AntecedentesNoPatologicosRepository antecedentesNoPatologicosRepository;

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
