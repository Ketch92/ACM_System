package com.dev.core.service;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Flight;
import com.dev.core.entity.FlightStatus;
import java.util.List;

public interface FlightService {
    
    Flight create(Flight flight);
    
    Flight get(Long id);
    
    List<Flight> get(FlightStatus flightStatus);
    
    List<Flight> get(AirCompany airCompany);
    
    List<Flight> get(FlightStatus flightStatus, AirCompany airCompany);
    
    List<Flight> getAll();
    
    void remove(Flight flight);
}
