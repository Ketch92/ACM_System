package com.dev.core.service.mapper.impl;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.dto.company.AirCompanyRequestDto;
import com.dev.core.entity.dto.company.AirCompanyRespDto;
import com.dev.core.entity.type.CompanyType;
import com.dev.core.service.mapper.ToDtoMapper;
import com.dev.core.service.mapper.ToEntityMapper;
import com.dev.core.service.type.CompanyTypeService;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyMapper
        implements ToDtoMapper<AirCompany, AirCompanyRespDto>,
        ToEntityMapper<AirCompanyRequestDto, AirCompany> {
    
    private final CompanyTypeService companyTypeService;
    
    public AirCompanyMapper(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }
    
    @Override
    public AirCompanyRespDto mapToDto(AirCompany airCompany) {
        AirCompanyRespDto dto = new AirCompanyRespDto();
        dto.setId(airCompany.getId());
        dto.setName(airCompany.getName());
        dto.setCompanyType(airCompany.getCompanyType().getTypeName());
        dto.setFoundedAt(airCompany.getFoundedAt());
        return dto;
    }
    
    @Override
    public AirCompany mapToEntity(AirCompanyRequestDto dto) {
        AirCompany company = new AirCompany();
        company.setName(dto.getName());
        company.setFoundedAt(dto.getFoundedAt());
        CompanyType type = new CompanyType();
        type.setTypeName(dto.getCompanyType());
        company.setCompanyType(companyTypeService.create(type));
        return company;
    }
}
