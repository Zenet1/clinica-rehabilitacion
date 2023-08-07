package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.EstudiosDTO;
import edu.uady.citasapi.entity.Estudios;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.repository.EstudiosRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EstudiosService {

    @Autowired
    private EstudiosRepository estudiosRepository;

    public EstudiosDTO createEstudio(Estudios estudio) throws Exception {

        try {
            Estudios estudioCreated = estudiosRepository.save(estudio);
            return createEstudioDTO(estudioCreated);
        } catch (Exception e) {
            throw new RegistroException("Ha ocurrido un error al guardar un nuevo estudio.");
        }

    }

    public EstudiosDTO updateEstudio(Estudios estudio, Long id) throws Exception {

        Optional<Estudios> estudioOptional = estudiosRepository.findById(id);

        if (estudioOptional.isPresent()) {
            Estudios estudioPresent = estudioOptional.get();

            estudioPresent.setUbicacion(estudio.getUbicacion());

            Estudios estudioUpdated = estudiosRepository.save(estudioPresent);
            return createEstudioDTO(estudioUpdated);
        } else {
            throw new RegistroException("No existe el estudio con ID " + id);
        }
    }

    public List<EstudiosDTO> getAllEstudios() throws Exception {
        List<Estudios> allEstudios = estudiosRepository.findAll();

        if (allEstudios.isEmpty()) {
            throw new RegistroException("No hay estudios registrados.");
        }

        List<EstudiosDTO> estudiosDTOs = new ArrayList<>();

        allEstudios.forEach(estudio -> {

            EstudiosDTO estudioDTO = createEstudioDTO(estudio);
            estudiosDTOs.add(estudioDTO);
        });

        return estudiosDTOs;
    }

    public EstudiosDTO getEstudio(Long id) throws Exception {
        Optional<Estudios> estudioOptional = estudiosRepository.findById(id);

        if (estudioOptional.isPresent()) {
            Estudios estudio = estudioOptional.get();
            return createEstudioDTO(estudio);
        } else {
            throw new RegistroException("No se encontró algún estudio con el ID " + id);
        }
    }

    protected EstudiosDTO createEstudioDTO(Estudios estudio) {
        EstudiosDTO estudioDTO = new EstudiosDTO();

        estudioDTO.setUbicacion(estudio.getUbicacion());

        return estudioDTO;
    }

    public String deleteEstudio(Long id) throws Exception {

        Estudios estudio = estudiosRepository.findById(id)
                .orElseThrow(() -> new RegistroException("No se encontró ningún estudio con ID " + id));

        estudiosRepository.delete(estudio);

        return "Estudio con ID " + id + " eliminado exitosamente.";

    }
}