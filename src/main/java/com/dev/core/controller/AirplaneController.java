package com.dev.core.controller;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Airplane;
import com.dev.core.entity.dto.airplane.AirplaneRequestDto;
import com.dev.core.entity.dto.airplane.AirplaneResponseDto;
import com.dev.core.entity.type.AirplaneType;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.AirplaneService;
import com.dev.core.service.mapper.impl.AirplaneMapper;
import com.dev.core.service.type.AirplaneTypeService;
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

@RequestMapping("/airplanes")
@RestController
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper mapper;
    private final AirCompanyService companyService;
    private final AirplaneTypeService airplaneTypeService;
    
    public AirplaneController(AirplaneService airplaneService,
                              AirplaneMapper airplaneMapper,
                              AirCompanyService companyService,
                              AirplaneTypeService airplaneTypeService) {
        this.airplaneService = airplaneService;
        this.mapper = airplaneMapper;
        this.companyService = companyService;
        this.airplaneTypeService = airplaneTypeService;
    }
    
    @GetMapping
    public List<AirplaneResponseDto> getAll() {
        return airplaneService.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/byName")
    public List<AirplaneResponseDto> getByName(@RequestParam String name) {
        return airplaneService.getByName(name).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/byCompany")
    public List<AirplaneResponseDto> getByCompany(@RequestParam String companyName) {
        AirCompany company = companyService.getByCompanyName(companyName);
        return airplaneService.getByAirCompany(company).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/byType")
    public List<AirplaneResponseDto> getByType(@RequestParam String type) {
        AirplaneType airplaneType = airplaneTypeService.getByType(type);
        return airplaneService.getByType(airplaneType).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public AirplaneResponseDto get(@PathVariable Long id) {
        return mapper.mapToDto(airplaneService.get(id));
    }
    
    @PostMapping
    public void addAirplane(@RequestBody @Valid AirplaneRequestDto dto) {
        Airplane airplane = mapper.mapToEntity(dto);
        airplane.setNumberOfFlights(0);
        airplane.setFlightDistance(0);
        airplaneService.create(airplane);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        airplaneService.remove(id);
    }
    
    @PutMapping("/{id}")
    public void reassignToAnotherCompany(@PathVariable Long id, @RequestParam Long companyId) {
        Airplane airplane = airplaneService.get(id);
        AirCompany company = companyService.get(id);
        airplane.setAirCompany(company);
        airplaneService.update(airplane);
    }
}
