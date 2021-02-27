package com.dev.core.controller;

import com.dev.core.entity.dto.status.FlightStatusRequestDto;
import com.dev.core.entity.dto.status.FlightStatusResponseDto;
import com.dev.core.service.FlightStatusService;
import com.dev.core.service.mapper.impl.FlightStatusMapper;
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

@RequestMapping("/flight-statuses")
@RestController
public class FlightStatusController {
    private final FlightStatusService flightStatusService;
    private final FlightStatusMapper mapper;
    
    public FlightStatusController(FlightStatusService flightStatusService,
                                  FlightStatusMapper mapper) {
        this.flightStatusService = flightStatusService;
        this.mapper = mapper;
    }
    
    @GetMapping("/{id}")
    public FlightStatusResponseDto get(@PathVariable Long id) {
        return mapper.mapToDto(flightStatusService.getById(id));
    }
    
    @GetMapping("/byName")
    public FlightStatusResponseDto get(@RequestParam String name) {
        return mapper.mapToDto(flightStatusService.getByStatusTitle(name));
    }
    
    @GetMapping
    public List<FlightStatusResponseDto> getAll() {
        return flightStatusService.getAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @DeleteMapping("/{id}")
    public void removeType(@PathVariable Long id) {
        flightStatusService.remove(id);
    }
    
    @PostMapping
    public void addNewType(@RequestBody @Valid FlightStatusRequestDto dto) {
        flightStatusService.create(mapper.mapToEntity(dto));
    }
}
