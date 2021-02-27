package com.dev.core.service.mapper.impl;

import com.dev.core.entity.Flight;
import com.dev.core.entity.dto.flight.FlightRequestDto;
import com.dev.core.entity.dto.flight.FlightResponseDto;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.AirplaneService;
import com.dev.core.service.FlightStatusService;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FlightMapper
        implements ToDtoMapper<Flight, FlightResponseDto>,
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
    public FlightResponseDto mapToDto(Flight flight) {
        FlightResponseDto dto = new FlightResponseDto();
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
        dto.setStartedAt(Optional.ofNullable(flight.getStartedAt())
                .map(LocalDateTime::toString).orElse(""));
        dto.setDelayStartedAt(Optional.ofNullable(flight.getDelayStartedAt())
                .map(LocalDateTime::toString).orElse(""));
        dto.setEndedAt(Optional.ofNullable(flight.getEndedAt())
                .map(LocalDateTime::toString).orElse(""));
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
        flight.setDepartureCountry(dto.getDepartureCountry());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setDistance(dto.getDistance());
        flight.setEstimatedFlightTime(dto.getEstimatedFlightTime());
        return flight;
    }
}
