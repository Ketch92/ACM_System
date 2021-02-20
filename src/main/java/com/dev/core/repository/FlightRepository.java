package com.dev.core.repository;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Flight;
import com.dev.core.entity.FlightStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("from Flight f where f.flightStatus = :status")
    List<Flight> getFlightByStatus(@Param("status") FlightStatus flightStatus);
    
    @Query("from Flight f where f.airCompany = :company")
    List<Flight> getFlightByCompany(@Param("company") AirCompany airCompany);
    
    @Query("from Flight f where f.airCompany = :company and f.flightStatus = :status")
    List<Flight> getFlightByCompanyAndStatus(@Param("status") FlightStatus flightStatus,
                                             @Param("company") AirCompany airCompany);
}
