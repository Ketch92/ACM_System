package com.dev.core.service;

import com.dev.core.entity.FlightStatus;

public interface FlightStatusService {
    
    FlightStatus getStatus(String status);
    
    FlightStatus getStatus(Long id);
    
    FlightStatus create(FlightStatus flightStatus);
    
    void remove(FlightStatus flightStatus);
}
