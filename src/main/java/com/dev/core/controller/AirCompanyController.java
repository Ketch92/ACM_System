package com.dev.core.controller;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.dto.company.AirCompanyRequestDto;
import com.dev.core.entity.dto.company.AirCompanyResponseDto;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.mapper.impl.AirCompanyMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-companies")
public class AirCompanyController {
    private final AirCompanyService companyService;
    private final AirCompanyMapper mapper;
    
    public AirCompanyController(AirCompanyService companyService,
                                AirCompanyMapper mapper) {
        this.companyService = companyService;
        this.mapper = mapper;
    }
    
    @GetMapping
    public List<AirCompanyResponseDto> getAll() {
        return companyService.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public AirCompanyResponseDto getAirCompany(@PathVariable Long id) {
        return mapper.mapToDto(companyService.get(id));
    }
    
    @GetMapping("/byName")
    public AirCompanyResponseDto getAirCompanyByName(@RequestParam String name) {
        return mapper.mapToDto(companyService.get(name));
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        companyService.remove(id);
    }
    
    @PostMapping
    public void addCompany(@RequestBody @Valid AirCompanyRequestDto dto) {
        companyService.create(mapper.mapToEntity(dto));
    }
    
    @PutMapping("/{id}")
    public void updateCompany(@RequestBody @Valid AirCompanyRequestDto dto,
                              @PathVariable Long id) {
        AirCompany company = mapper.mapToEntity(dto);
        company.setId(id);
        companyService.update(company);
    }
}
