package com.dev.core.service;

import com.dev.core.entity.AirCompany;
import java.util.List;

public interface AirCompanyService {
    
    AirCompany create(AirCompany airCompany);
    
    AirCompany get(Long id);
    
    AirCompany get(String companyName);
    
    List<AirCompany> getAll();
    
    void remove(Long id);
    
    void update(AirCompany airCompany);
}
