package com.dev.core.service.mapper.impl;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.dto.company.AirCompanyRequestDto;
import com.dev.core.entity.dto.company.AirCompanyResponseDto;
import com.dev.core.entity.type.CompanyType;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import com.dev.core.service.type.CompanyTypeService;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyMapper
        implements ToDtoMapper<AirCompany, AirCompanyResponseDto>,
        ToEntityMapper<AirCompanyRequestDto, AirCompany> {
    
    private final CompanyTypeService companyTypeService;
    
    public AirCompanyMapper(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }
    
    @Override
    public AirCompanyResponseDto mapToDto(AirCompany airCompany) {
        AirCompanyResponseDto dto = new AirCompanyResponseDto();
        dto.setId(airCompany.getId());
        dto.setName(airCompany.getName());
        dto.setCompanyType(airCompany.getCompanyType().getTypeName());
        dto.setFoundedAt(airCompany.getFoundedAt().toString());
        return dto;
    }
    
    @Override
    public AirCompany mapToEntity(AirCompanyRequestDto dto) {
        AirCompany company = new AirCompany();
        company.setName(dto.getName());
        company.setFoundedAt(LocalDate.parse(dto.getFoundedAt()));
        CompanyType type = new CompanyType();
        type.setTypeName(dto.getCompanyType());
        company.setCompanyType(companyTypeService.create(type));
        return company;
    }
}
