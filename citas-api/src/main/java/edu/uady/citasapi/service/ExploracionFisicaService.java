package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.ExploracionFisicaDTO;
import edu.uady.citasapi.entity.ExploracionFisica;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.repository.ExploracionFisicaRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ExploracionFisicaService {

    @Autowired
    private ExploracionFisicaRepository exploracionFisicaRepository;

    public ExploracionFisicaDTO createExploracion(ExploracionFisica exploracion) throws Exception {

        try {
            ExploracionFisica exploracionCreated = exploracionFisicaRepository.save(exploracion);
            return createExploracionDTO(exploracionCreated);
        } catch (Exception e) {
            throw new RegistroException("Ha ocurrido un error al guardar una nueva exploración física.");
        }

    }

    public ExploracionFisicaDTO updateExploracion(ExploracionFisica exploracion, Long id) throws Exception {

        Optional<ExploracionFisica> exploracionOptional = exploracionFisicaRepository.findById(id);

        if (exploracionOptional.isPresent()) {
            ExploracionFisica exploracionPresent = exploracionOptional.get();

            exploracionPresent.setExploracion(exploracion.getExploracion());
            exploracionPresent.setFecha(exploracion.getFecha());
            exploracionPresent.setIdCita(exploracion.getIdCita());

            ExploracionFisica exploracionUpdated = exploracionFisicaRepository.save(exploracionPresent);
            return createExploracionDTO(exploracionUpdated);
        } else {
            throw new RegistroException("No existe la exploración física con ID " + id);
        }
    }

    public List<ExploracionFisicaDTO> getAllExploraciones() throws Exception {
        List<ExploracionFisica> allExploraciones = exploracionFisicaRepository.findAll();

        if (allExploraciones.isEmpty()) {
            throw new RegistroException("No hay exploraciones físicas registrados.");
        }

        List<ExploracionFisicaDTO> exploracionesDTOs = new ArrayList<>();

        allExploraciones.forEach(exploracion -> {

            ExploracionFisicaDTO exploracionDTO = createExploracionDTO(exploracion);
            exploracionesDTOs.add(exploracionDTO);
        });

        return exploracionesDTOs;
    }

    public ExploracionFisicaDTO getExploracion(Long id) throws Exception {
        Optional<ExploracionFisica> exploracionOptional = exploracionFisicaRepository.findById(id);

        if (exploracionOptional.isPresent()) {
            ExploracionFisica exploracion = exploracionOptional.get();
            return createExploracionDTO(exploracion);
        } else {
            throw new RegistroException("No se encontró alguna exploración física con el ID " + id);
        }
    }

    protected ExploracionFisicaDTO createExploracionDTO(ExploracionFisica exploracion) {
        ExploracionFisicaDTO exploracionDTO = new ExploracionFisicaDTO();

        exploracionDTO.setExploracion(exploracion.getExploracion());
        exploracionDTO.setFecha(exploracion.getFecha());
        exploracionDTO.setId_cita(exploracion.getIdCita());

        return exploracionDTO;
    }

    public String deleteExploracion(Long id) throws Exception {

        ExploracionFisica exploracion = exploracionFisicaRepository.findById(id)
                .orElseThrow(() -> new RegistroException("No se encontró ninguna exploración física con ID " + id));

        exploracionFisicaRepository.delete(exploracion);

        return "Exploración física con ID " + id + " eliminada exitosamente.";

    }
}