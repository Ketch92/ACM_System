package com.dev.core.entity.dto.status;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightStatusRequestDto {
    @NotNull
    @NotBlank
    private String status;
}
