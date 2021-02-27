package com.dev.core.entity.dto.flight;

import com.sun.istack.NotNull;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightRequestDto {
    @NotNull
    private Long flightStatusId;
    @NotNull
    private Long airCompanyId;
    private Set<Long> airplaneIds;
    @NotNull
    @NotBlank
    private String departureCountry;
    @NotNull
    @NotBlank
    private String destinationCountry;
    @Positive
    private int distance;
    @Positive
    private int estimatedFlightTime;
    @NotNull
    @NotBlank
    private String createdAt;
}
