package com.dev.core.controller;

import com.dev.core.entity.dto.type.airplane.AirplaneTypeRequestDto;
import com.dev.core.entity.dto.type.airplane.AirplaneTypeRespDto;
import com.dev.core.service.mapper.impl.AirplaneTypeMapper;
import com.dev.core.service.type.AirplaneTypeService;
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

@RequestMapping("/airplane-types")
@RestController
public class AirplaneTypeController {
    private final AirplaneTypeService airplaneTypeService;
    private final AirplaneTypeMapper mapper;
    
    public AirplaneTypeController(AirplaneTypeService airplaneTypeService,
                                  AirplaneTypeMapper mapper) {
        this.airplaneTypeService = airplaneTypeService;
        this.mapper = mapper;
    }
    
    @GetMapping("/{id}")
    public AirplaneTypeRespDto get(@PathVariable Long id) {
        return mapper.mapToDto(airplaneTypeService.get(id));
    }
    
    @GetMapping("/byName")
    public AirplaneTypeRespDto get(@RequestParam String name) {
        return mapper.mapToDto(airplaneTypeService.get(name));
    }
    
    @GetMapping
    public List<AirplaneTypeRespDto> getAll() {
        return airplaneTypeService.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @DeleteMapping("/{id}")
    public void removeType(@PathVariable Long id) {
        airplaneTypeService.remove(id);
    }
    
    @PostMapping
    public void addNewType(@RequestBody @Valid AirplaneTypeRequestDto dto) {
        airplaneTypeService.create(mapper.mapToEntity(dto));
    }
}
