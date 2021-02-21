package com.dev.core.service.mapper.impl;

import com.dev.core.entity.Flight;
import com.dev.core.entity.FlightStatus;
import com.dev.core.entity.dto.flight.FlightRequestDto;
import com.dev.core.entity.dto.flight.FlightRespDto;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.AirplaneService;
import com.dev.core.service.FlightStatusService;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FlightMapper
        implements ToDtoMapper<Flight, FlightRespDto>,
        ToEntityMapper<FlightRequestDto, Flight> {
    private final AirplaneMapper airplaneMapper;
    private final FlightStatusService flightStatusService;
    private final AirCompanyService companyService;
    private final AirplaneService airplaneService;
    
    public FlightMapper(AirplaneMapper airplaneMapper,
                        FlightStatusService flightStatusService,
                        AirCompanyService companyService,
                        AirplaneService airplaneService) {
        this.airplaneMapper = airplaneMapper;
        this.flightStatusService = flightStatusService;
        this.companyService = companyService;
        this.airplaneService = airplaneService;
    }
    
    @Override
    public FlightRespDto mapToDto(Flight flight) {
        FlightRespDto dto = new FlightRespDto();
        dto.setId(flight.getId());
        dto.setFlightStatus(flight.getFlightStatus().getStatusName());
        dto.setAirCompanyName(flight.getAirCompany().getName());
        dto.setAirplanes(flight.getAirplanes().stream()
                .map(airplaneMapper::mapToDto)
                .collect(Collectors.toList()));
        dto.setDepartureCountry(flight.getDepartureCountry());
        dto.setDestinationCountry(flight.getDestinationCountry());
        dto.setDistance(flight.getDistance());
        dto.setEstimatedFlightTime(flight.getEstimatedFlightTime());
        dto.setStartedAt(flight.getStartedAt().toString());
        dto.setDelayStartedAt(flight.getDelayStartedAt().toString());
        dto.setEndedAt(flight.getEndedAt().toString());
        dto.setCreatedAt(flight.getCreatedAt().toString());
        return dto;
    }
    
    @Override
    public Flight mapToEntity(FlightRequestDto dto) {
        Flight flight = new Flight();
        flight.setFlightStatus(flightStatusService.getStatus(dto.getFlightStatusId()));
        flight.setAirCompany(companyService.get(dto.getAirCompanyId()));
        flight.setAirplanes(airplaneService.get(dto.getAirplaneIds()));
        flight.setCreatedAt(LocalDateTime.parse(dto.getCreatedAt()));
        flight.setStartedAt(LocalDateTime.parse(dto.getStartedAt()));
        flight.setDelayStartedAt(LocalDateTime.parse(dto.getDelayStartedAt()));
        flight.setEndedAt(LocalDateTime.parse(dto.getEndedAt()));
        flight.setDepartureCountry(dto.getDepartureCountry());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setDistance(dto.getDistance());
        flight.setEstimatedFlightTime(dto.getEstimatedFlightTime());
        return flight;
    }
}
