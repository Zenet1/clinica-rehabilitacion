package edu.uady.citasapi.repository;

import edu.uady.citasapi.entity.Padecimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PadecimientoRepository extends JpaRepository<Padecimiento, Long>{
    
}
