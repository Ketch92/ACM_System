package com.dev.core.entity.dto.type.airplane;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;

public class AirplaneTypeRequestDto {
    @NotNull
    @NotBlank
    private String type;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
