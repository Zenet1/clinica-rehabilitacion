package edu.uady.citasapi.repository;

import edu.uady.citasapi.entity.CitaStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaStatusRepository extends JpaRepository<CitaStatus, Long> {
}
