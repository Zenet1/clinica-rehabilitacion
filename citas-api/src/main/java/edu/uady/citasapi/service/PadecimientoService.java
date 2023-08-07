package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.PadecimientoDTO;
import edu.uady.citasapi.entity.Padecimiento;
import edu.uady.citasapi.error.RegistroException;
import edu.uady.citasapi.repository.PadecimientoRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PadecimientoService {

    @Autowired
    private PadecimientoRepository padecimientoRepository;

    public PadecimientoDTO createPadecimiento(Padecimiento padecimiento) throws Exception {

        try {
            Padecimiento padecimientoCreated = padecimientoRepository.save(padecimiento);
            return createPadecimientoDTO(padecimientoCreated);
        } catch (Exception e) {
            throw new RegistroException("Ha ocurrido un error al guardar un nuevo padecimiento.");
        }

    }

    public PadecimientoDTO updatePadecimiento(Padecimiento padecimiento, Long id) throws Exception {

        Optional<Padecimiento> padecimientoOptional = padecimientoRepository.findById(id);

        if (padecimientoOptional.isPresent()) {
            Padecimiento padecimientoPresent = padecimientoOptional.get();
            
            padecimientoPresent.setFecha(padecimiento.getFecha());
            padecimientoPresent.setDescripcion(padecimiento.getDescripcion());
            padecimientoPresent.setEvolucion(padecimiento.getEvolucion());
            padecimientoPresent.setEstado_actual(padecimiento.getEstado_actual());
            padecimientoPresent.setIdCita(padecimiento.getIdCita());

            Padecimiento estudioUpdated = padecimientoRepository.save(padecimientoPresent);
            return createPadecimientoDTO(estudioUpdated);
        } else {
            throw new RegistroException("No existe el padecimiento con ID " + id);
        }
    }

    public List<PadecimientoDTO> getAllPadecimientos() throws Exception {
        List<Padecimiento> allPadecimientos = padecimientoRepository.findAll();

        if (allPadecimientos.isEmpty()) {
            throw new RegistroException("No hay padecimientos registrados.");
        }

        List<PadecimientoDTO> padecimientosDTOs = new ArrayList<>();

        allPadecimientos.forEach(padecimiento -> {

            PadecimientoDTO padecimientoDTO = createPadecimientoDTO(padecimiento);
            padecimientosDTOs.add(padecimientoDTO);
        });

        return padecimientosDTOs;
    }

    public PadecimientoDTO getPadecimiento(Long id) throws Exception {
        Optional<Padecimiento> padecimientoOptional = padecimientoRepository.findById(id);

        if (padecimientoOptional.isPresent()) {
            Padecimiento padecimiento = padecimientoOptional.get();
            return createPadecimientoDTO(padecimiento);
        } else {
            throw new RegistroException("No se encontró algún padecimiento con el ID " + id);
        }
    }

    protected PadecimientoDTO createPadecimientoDTO(Padecimiento padecimiento) {
        PadecimientoDTO padecimientoDTO = new PadecimientoDTO();

        padecimientoDTO.setFecha(padecimiento.getFecha());
        padecimientoDTO.setDescripcion(padecimiento.getDescripcion());
        padecimientoDTO.setEvolucion(padecimiento.getEvolucion());
        padecimientoDTO.setEstado_actual(padecimiento.getEstado_actual());
        padecimientoDTO.setIdCita(padecimiento.getIdCita());

        return padecimientoDTO;
    }

    public String deletePadecimiento(Long id) throws Exception {

        Padecimiento padecimiento = padecimientoRepository.findById(id)
                .orElseThrow(() -> new RegistroException("No se encontró ningún padecimiento con ID " + id));

        padecimientoRepository.delete(padecimiento);

        return "Padecimiento con ID " + id + " eliminado exitosamente.";

    }
}