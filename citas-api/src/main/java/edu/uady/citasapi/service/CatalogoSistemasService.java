package edu.uady.citasapi.service;

import edu.uady.citasapi.dto.CatalogoSistemasDTO;
import edu.uady.citasapi.error.CitaException;
import edu.uady.citasapi.repository.CatalogoSistemasRepository;
import edu.uady.citasapi.entity.CatalogoSistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogoSistemasService {

    @Autowired
    private CatalogoSistemasRepository catalogoSistemasRepository;

    public CatalogoSistemasDTO createCatalogoSistemas(CatalogoSistemas catalogoSistemas) throws Exception {

        try {
            CatalogoSistemas catalogoSistemasCreated = catalogoSistemasRepository.save(catalogoSistemas);
            return createCatalogoSistemasDTO(catalogoSistemasCreated);
        } catch (Exception exception) {
            throw new CitaException("Ha ocurrido un error al guardar nuevo catalogoSistemas.");
        }

    }

    public CatalogoSistemasDTO updateCatalogoSistemas(CatalogoSistemas catalogoSistemas, Long id) throws Exception {

        Optional<CatalogoSistemas> catalogoSistemasOptional = catalogoSistemasRepository.findById(id);

        if (catalogoSistemasOptional.isPresent()) {
            CatalogoSistemas catalogoSistemasExistente = catalogoSistemasOptional.get();
            
            catalogoSistemasExistente.setSistema(catalogoSistemas.getSistema());
            catalogoSistemasExistente.setSubsistema(catalogoSistemas.getSubsistema());


            CatalogoSistemas catalogoSistemasUpdated = catalogoSistemasRepository.save(catalogoSistemasExistente);
            return createCatalogoSistemasDTO(catalogoSistemasUpdated);
        } else {
            throw new CitaException("No existe catalogoSistemas con ID " + id);
        }
    }

    public List<CatalogoSistemasDTO> getAllCatalogoSistemas() throws Exception {
        List<CatalogoSistemas> citas = catalogoSistemasRepository.findAll();

        if (citas.isEmpty()) {
            throw new CitaException("No hay citas registrados.");
        }

        List<CatalogoSistemasDTO> catalogoSistemasDTOS = new ArrayList<>();

        citas.forEach(catalogoSistemas -> {

            CatalogoSistemasDTO catalogoSistemasDTO = createCatalogoSistemasDTO(catalogoSistemas);
            catalogoSistemasDTOS.add(catalogoSistemasDTO);
        });

        return catalogoSistemasDTOS;
    }

    public CatalogoSistemasDTO getCatalogoSistemas(Long id) throws Exception {
        Optional<CatalogoSistemas> catalogoSistemasOptional = catalogoSistemasRepository.findById(id);

        if (catalogoSistemasOptional.isPresent()) {
            CatalogoSistemas catalogoSistemas = catalogoSistemasOptional.get();
            return createCatalogoSistemasDTO(catalogoSistemas);
        } else {
            throw new CitaException("No se encontró algún catalogoSistemas con el ID " + id);
        }
    }

    protected CatalogoSistemasDTO createCatalogoSistemasDTO(CatalogoSistemas catalogoSistemas) {
        CatalogoSistemasDTO catalogoSistemasDTO = new CatalogoSistemasDTO();
        
        catalogoSistemasDTO.setSistema(catalogoSistemas.getSistema());
        catalogoSistemasDTO.setSubsistema(catalogoSistemas.getSubsistema());


        return catalogoSistemasDTO;
    }

    public String deleteCatalogoSistemas(Long id) throws Exception {

        CatalogoSistemas catalogoSistemas = catalogoSistemasRepository.findById(id)
                .orElseThrow(() -> new CitaException("No se encontró ningún catalogoSistemas con ID " + id));

        catalogoSistemasRepository.delete(catalogoSistemas);

        return "CatalogoSistemas con ID " + id + " eliminado exitosamente.";

    }

    public CatalogoSistemas convertirDTOaCatalogoSistemas(CatalogoSistemasDTO catalogoSistemasDTO) {
        CatalogoSistemas catalogoSistemas = new CatalogoSistemas();

        catalogoSistemas.setSistema(catalogoSistemas.getSistema());
        catalogoSistemas.setSubsistema(catalogoSistemas.getSubsistema());

        return catalogoSistemas;
    }
}
