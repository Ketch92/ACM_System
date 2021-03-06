package com.dev.core.entity.dto.airplane;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirplaneRequestDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private Long airplaneTypeId;
    @NotNull
    @NotBlank
    private String factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    @NotNull
    private int fuelCapacity;
    @NotNull
    private String createdAt;
}
