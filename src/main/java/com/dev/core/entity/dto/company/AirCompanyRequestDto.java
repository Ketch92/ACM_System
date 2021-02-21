package com.dev.core.entity.dto.company;

import com.sun.istack.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AirCompanyRequestDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String companyType;
    @Min(1900)
    private int foundedAt;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCompanyType() {
        return companyType;
    }
    
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    
    public int getFoundedAt() {
        return foundedAt;
    }
    
    public void setFoundedAt(int foundedAt) {
        this.foundedAt = foundedAt;
    }
}
