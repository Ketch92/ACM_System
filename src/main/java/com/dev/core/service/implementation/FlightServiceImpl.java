package com.dev.core.service.implementation;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Flight;
import com.dev.core.entity.FlightStatus;
import com.dev.core.repository.FlightRepository;
import com.dev.core.service.FlightService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    
    private final FlightRepository flightRepository;
    
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    @Override
    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }
    
    @Override
    public Flight get(Long id) {
        return flightRepository.getOne(id);
    }
    
    @Override
    public List<Flight> get(FlightStatus flightStatus) {
        return flightRepository.getFlightByStatus(flightStatus);
    }
    
    @Override
    public List<Flight> get(AirCompany airCompany) {
        return flightRepository.getFlightByCompany(airCompany);
    }
    
    @Override
    public List<Flight> get(FlightStatus flightStatus, AirCompany airCompany) {
        return flightRepository.getFlightByCompanyAndStatus(flightStatus, airCompany);
    }
    
    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
    
    @Override
    public void remove(Flight flight) {
        if (flightRepository.findById(flight.getId()).isPresent()) {
            flightRepository.delete(flight);
        }
    }
    
    @Override
    public void update(Flight flight) {
        if (flightRepository.findById(flight.getId()).isPresent()) {
            flightRepository.save(flight);
        }
    }
}
