package com.dev.core.entity.dto.status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightStatusResponseDto {
    private Long id;
    private String status;
}
