package com.dev.core.controller;

import com.dev.core.entity.dto.type.company.CompanyTypeRequestDto;
import com.dev.core.entity.dto.type.company.CompanyTypeRespDto;
import com.dev.core.service.mapper.impl.CompanyTypeMapper;
import com.dev.core.service.type.CompanyTypeService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/company-types")
@RestController
public class CompanyTypeController {
    private final CompanyTypeService companyTypeService;
    private final CompanyTypeMapper mapper;
    
    public CompanyTypeController(CompanyTypeService companyTypeService,
                                 CompanyTypeMapper mapper) {
        this.companyTypeService = companyTypeService;
        this.mapper = mapper;
    }
    
    @GetMapping("/{id}")
    public CompanyTypeRespDto get(@PathVariable Long id) {
        return mapper.mapToDto(companyTypeService.get(id));
    }
    
    @GetMapping("/byName")
    public CompanyTypeRespDto get(@RequestParam String name) {
        return mapper.mapToDto(companyTypeService.get(name));
    }
    
    @GetMapping
    public List<CompanyTypeRespDto> getAll() {
        return companyTypeService.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @DeleteMapping("/{id}")
    public void removeType(@PathVariable Long id) {
        companyTypeService.remove(id);
    }
    
    @PostMapping
    public void addNewType(@RequestBody @Valid CompanyTypeRequestDto dto) {
        companyTypeService.create(mapper.mapToEntity(dto));
    }
}
