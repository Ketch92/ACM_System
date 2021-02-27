package com.dev.core.entity.dto.flight;

import com.dev.core.entity.dto.airplane.AirplaneResponseDto;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightResponseDto {
    private Long id;
    private String flightStatus;
    private String airCompanyName;
    private List<AirplaneResponseDto> airplanes;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String startedAt;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;
}
