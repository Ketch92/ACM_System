package com.dev.core.entity.dto.company;

public class AirCompanyRespDto {
    private Long id;
    private String name;
    private String companyType;
    private String foundedAt;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public String getFoundedAt() {
        return foundedAt;
    }
    
    public void setFoundedAt(String foundedAt) {
        this.foundedAt = foundedAt;
    }
}
