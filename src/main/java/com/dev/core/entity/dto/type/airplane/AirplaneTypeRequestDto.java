package com.dev.core.entity.dto.type.airplane;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirplaneTypeRequestDto {
    @NotNull
    @NotBlank
    private String type;
}
