package com.dev.core.service.mapper.impl;

import com.dev.core.entity.FlightStatus;
import com.dev.core.entity.dto.status.FlightStatusRequestDto;
import com.dev.core.entity.dto.status.FlightStatusResponseDto;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class FlightStatusMapper
        implements ToDtoMapper<FlightStatus, FlightStatusResponseDto>,
        ToEntityMapper<FlightStatusRequestDto, FlightStatus> {
    
    @Override
    public FlightStatusResponseDto mapToDto(FlightStatus entity) {
        FlightStatusResponseDto dto = new FlightStatusResponseDto();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatusName());
        return dto;
    }
    
    @Override
    public FlightStatus mapToEntity(FlightStatusRequestDto dto) {
        FlightStatus status = new FlightStatus();
        status.setStatusName(dto.getStatus());
        return status;
    }
}
