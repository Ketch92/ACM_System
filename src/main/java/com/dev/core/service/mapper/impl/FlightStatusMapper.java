package com.dev.core.service.mapper.impl;

import com.dev.core.entity.FlightStatus;
import com.dev.core.entity.dto.status.FlightStatusRequestDto;
import com.dev.core.entity.dto.status.FlightStatusRespDto;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class FlightStatusMapper
        implements ToDtoMapper<FlightStatus, FlightStatusRespDto>,
        ToEntityMapper<FlightStatusRequestDto, FlightStatus> {
    
    @Override
    public FlightStatusRespDto mapToDto(FlightStatus entity) {
        FlightStatusRespDto dto = new FlightStatusRespDto();
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        return dto;
    }
    
    @Override
    public FlightStatus mapToEntity(FlightStatusRequestDto dto) {
        FlightStatus status = new FlightStatus();
        status.setStatus(dto.getStatus());
        return status;
    }
}
