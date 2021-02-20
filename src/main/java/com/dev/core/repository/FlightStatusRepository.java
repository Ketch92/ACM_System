package com.dev.core.repository;

import com.dev.core.entity.FlightStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {
    @Query("from FlightStatus fs where fs.status = :status")
    Optional<FlightStatus> getFlightStatusByName(@Param("status") String status);
}
