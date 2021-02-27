package com.dev.core.service.mapper.impl;

import com.dev.core.entity.dto.type.airplane.AirplaneTypeRequestDto;
import com.dev.core.entity.dto.type.airplane.AirplaneTypeResponseDto;
import com.dev.core.entity.type.AirplaneType;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class AirplaneTypeMapper
        implements ToDtoMapper<AirplaneType, AirplaneTypeResponseDto>,
        ToEntityMapper<AirplaneTypeRequestDto, AirplaneType> {
    
    @Override
    public AirplaneTypeResponseDto mapToDto(AirplaneType type) {
        AirplaneTypeResponseDto dto = new AirplaneTypeResponseDto();
        dto.setId(type.getId());
        dto.setType(type.getTypeName());
        return dto;
    }
    
    @Override
    public AirplaneType mapToEntity(AirplaneTypeRequestDto dto) {
        AirplaneType type = new AirplaneType();
        type.setTypeName(dto.getType());
        return type;
    }
}
