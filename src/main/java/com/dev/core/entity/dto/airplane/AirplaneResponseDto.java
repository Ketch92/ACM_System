package com.dev.core.entity.dto.airplane;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirplaneResponseDto {
    private Long id;
    private String name;
    private String airplaneType;
    private String factorySerialNumber;
    private String airCompanyName;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String createdAt;
}
