package com.dev.core.service.type;

import com.dev.core.entity.type.CompanyType;

public interface CompanyTypeService {
    CompanyType create(CompanyType companyType);
    
    CompanyType get(Long id);
    
    CompanyType get(String type);
    
    void remove(CompanyType companyType);
}
