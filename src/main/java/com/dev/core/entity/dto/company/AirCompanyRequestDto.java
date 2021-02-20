package com.dev.core.entity.dto.company;

public class AirCompanyRequestDto {
    private String name;
    private String companyType;
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
