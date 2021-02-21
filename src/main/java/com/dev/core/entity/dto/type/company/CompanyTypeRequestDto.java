package com.dev.core.entity.dto.type.company;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;

public class CompanyTypeRequestDto {
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
