package com.dev.core.service.mapper.impl;

import com.dev.core.entity.dto.type.company.CompanyTypeRequestDto;
import com.dev.core.entity.dto.type.company.CompanyTypeResponseDto;
import com.dev.core.entity.type.CompanyType;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyTypeMapper
        implements ToDtoMapper<CompanyType, CompanyTypeResponseDto>,
        ToEntityMapper<CompanyTypeRequestDto, CompanyType> {
    
    @Override
    public CompanyTypeResponseDto mapToDto(CompanyType entity) {
        CompanyTypeResponseDto dto = new CompanyTypeResponseDto();
        dto.setId(entity.getId());
        dto.setType(entity.getTypeName());
        return dto;
    }
    
    @Override
    public CompanyType mapToEntity(CompanyTypeRequestDto dto) {
        CompanyType type = new CompanyType();
        type.setTypeName(dto.getType());
        return type;
    }
}
