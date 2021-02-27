package com.dev.core.service.mapper.impl;

import com.dev.core.entity.Airplane;
import com.dev.core.entity.dto.airplane.AirplaneRequestDto;
import com.dev.core.entity.dto.airplane.AirplaneResponseDto;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import com.dev.core.service.type.AirplaneTypeService;
import org.springframework.stereotype.Service;

@Service
public class AirplaneMapper
        implements ToDtoMapper<Airplane, AirplaneResponseDto>,
        ToEntityMapper<AirplaneRequestDto, Airplane> {
    private final AirCompanyService companyService;
    private final AirplaneTypeService airplaneTypeService;
    
    public AirplaneMapper(AirCompanyService companyService,
                          AirplaneTypeService airplaneTypeService) {
        this.companyService = companyService;
        this.airplaneTypeService = airplaneTypeService;
    }
    
    @Override
    public Airplane mapToEntity(AirplaneRequestDto dto) {
        Airplane airplane = new Airplane();
        airplane.setAirCompany(companyService.get(dto.getAirCompanyId()));
        airplane.setType(airplaneTypeService.get(dto.getAirplaneTypeId()));
        airplane.setName(dto.getName());
        airplane.setCreatedAt(dto.getCreatedAt());
        airplane.setFlightDistance(dto.getFlightDistance());
        airplane.setFactorySerialNumber(dto.getFactorySerialNumber());
        airplane.setFuelCapacity(dto.getFuelCapacity());
        airplane.setNumberOfFlights(dto.getNumberOfFlights());
        return airplane;
    }
    
    @Override
    public AirplaneResponseDto mapToDto(Airplane airplane) {
        AirplaneResponseDto dto = new AirplaneResponseDto();
        dto.setId(airplane.getId());
        dto.setName(airplane.getName());
        dto.setAirplaneType(airplane.getType().getTypeName());
        dto.setAirCompanyName(airplane.getAirCompany().getName());
        dto.setCreatedAt(airplane.getCreatedAt());
        dto.setFlightDistance(airplane.getFlightDistance());
        dto.setFuelCapacity(airplane.getFuelCapacity());
        dto.setFactorySerialNumber(airplane.getFactorySerialNumber());
        dto.setNumberOfFlights(airplane.getNumberOfFlights());
        return dto;
    }
}
