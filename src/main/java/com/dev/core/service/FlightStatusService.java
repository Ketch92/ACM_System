package com.dev.core.service;

import com.dev.core.entity.FlightStatus;
import java.util.List;

public interface FlightStatusService {
    
    FlightStatus getByStatusTitle(String status);
    
    FlightStatus getById(Long id);
    
    List<FlightStatus> getAll();
    
    FlightStatus create(FlightStatus flightStatus);
    
    void remove(Long id);
}
