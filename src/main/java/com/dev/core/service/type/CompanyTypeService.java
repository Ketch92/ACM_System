package com.dev.core.service.type;

import com.dev.core.entity.type.CompanyType;
import java.util.Optional;

public interface CompanyTypeService {
    CompanyType create(CompanyType companyType);
    
    CompanyType get(Long id);
    
    Optional<CompanyType> get(String type);
    
    void remove(CompanyType companyType);
}
