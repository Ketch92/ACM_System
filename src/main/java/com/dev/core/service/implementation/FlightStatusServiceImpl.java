package com.dev.core.service.implementation;

import com.dev.core.entity.FlightStatus;
import com.dev.core.repository.FlightStatusRepository;
import com.dev.core.service.FlightStatusService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightStatusServiceImpl implements FlightStatusService {
    private final FlightStatusRepository flightStatusRepository;
    
    public FlightStatusServiceImpl(FlightStatusRepository flightStatusRepository) {
        this.flightStatusRepository = flightStatusRepository;
    }
    
    @Override
    public FlightStatus getStatus(String status) {
        return flightStatusRepository.getFlightStatusByName(status).orElseThrow();
    }
    
    @Override
    public FlightStatus getStatus(Long id) {
        return flightStatusRepository.getOne(id);
    }
    
    @Override
    public FlightStatus create(FlightStatus flightStatus) {
        return flightStatusRepository
                .getFlightStatusByName(flightStatus.getStatusName())
                .orElseGet(() -> flightStatusRepository.save(flightStatus));
    }
    
    @Override
    public void remove(Long id) {
        if (flightStatusRepository.findById(id).isPresent()) {
            flightStatusRepository.deleteById(id);
        }
    }
    
    @Override
    public List<FlightStatus> getAll() {
        return flightStatusRepository.findAll();
    }
}
