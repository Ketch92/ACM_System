package com.dev.core.controller;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Flight;
import com.dev.core.entity.FlightStatus;
import com.dev.core.entity.dto.flight.FlightRequestDto;
import com.dev.core.entity.dto.flight.FlightRespDto;
import com.dev.core.service.AirCompanyService;
import com.dev.core.service.FlightService;
import com.dev.core.service.FlightStatusService;
import com.dev.core.service.mapper.impl.FlightMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/flights")
@RestController
public class FlightController {
    private static final String ACTIVE_STATUS = "ACTIVE";
    private static final String PENDING_STATUS = "PENDING";
    private static final String DELAYED_STATUS = "DELAYED";
    private static final String COMPLETED_STATUS = "COMPLETED";
    private final FlightService flightService;
    private final AirCompanyService companyService;
    private final FlightStatusService flightStatusService;
    private final FlightMapper mapper;
    
    public FlightController(FlightService flightService,
                            AirCompanyService companyService,
                            FlightStatusService flightStatusService,
                            FlightMapper mapper) {
        this.flightService = flightService;
        this.companyService = companyService;
        this.flightStatusService = flightStatusService;
        this.mapper = mapper;
    }
    
    @GetMapping("/")
    public List<FlightRespDto> getByCompanyAndStatus(@RequestParam String company,
                                                     @RequestParam String status) {
        AirCompany airCompany = companyService.get(company);
        FlightStatus flightStatus = flightStatusService.getStatus(status);
        return flightService.get(flightStatus, airCompany).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public FlightRespDto getById(@PathVariable Long id) {
        return mapper.mapToDto(flightService.get(id));
    }
    
    @PostMapping
    public void addFlight(@RequestBody @Valid FlightRequestDto dto) {
        Flight flight = mapper.mapToEntity(dto);
        flight.setFlightStatus(flightStatusService.getStatus(PENDING_STATUS));
        flightService.create(flight);
    }
    
    @GetMapping("/active/24")
    private List<FlightRespDto> getActiveAndStartedMore24hoursAgo() {
        return flightService.getByStatusAndStartedBefore(LocalDateTime.now().minusHours(24L),
                ACTIVE_STATUS).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
    
    @PutMapping("/{id}")
    public void changeStatus(@PathVariable Long id, @RequestParam String status) {
        Flight flight = flightService.get(id);
        switch (status) {
            case DELAYED_STATUS:
                flight.setDelayStartedAt(LocalDateTime.now());
                break;
            case COMPLETED_STATUS:
                flight.setEndedAt(LocalDateTime.now());
                break;
            case ACTIVE_STATUS:
                flight.setStartedAt(LocalDateTime.now());
                break;
            default: break;
        }
        flightService.update(flight);
    }
}
