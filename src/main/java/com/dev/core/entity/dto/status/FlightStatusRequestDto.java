package com.dev.core.entity.dto.status;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;

public class FlightStatusRequestDto {
    @NotNull
    @NotBlank
    private String status;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
