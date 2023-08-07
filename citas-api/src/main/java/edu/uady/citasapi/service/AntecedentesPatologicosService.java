package edu.uady.citasapi.service;

import edu.uady.citasapi.repository.PacienteTypeRepository;
import edu.uady.pacientesapi.entity.AntecedentesPatologicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedentesPatologicosService {
    @Autowired
    private PacienteTypeRepository antecedentesPatologicosRepository;

    public AntecedentesPatologicos createAntecedentesPatologicosRespository(AntecedentesPatologicos antecedentesPatologicos){
        return antecedentesPatologicosRepository.save(antecedentesPatologicos);
    }

    public AntecedentesPatologicos updateAntecedentesPatologicosRespository(AntecedentesPatologicos antecedentesPatologicos){
        return antecedentesPatologicosRepository.save(antecedentesPatologicos);
    }

    public List<AntecedentesPatologicos> getAllAntecedentesPatologicos(){
        return antecedentesPatologicosRepository.findAll();
    }

    public void deleteAntecedentesPatologicos(Long id){
        antecedentesPatologicosRepository.deleteById(id);
    }
}
