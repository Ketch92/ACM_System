package com.dev.core.service.type;

import com.dev.core.entity.type.CompanyType;
import java.util.List;

public interface CompanyTypeService {
    CompanyType create(CompanyType companyType);
    
    CompanyType get(Long id);
    
    CompanyType getByType(String type);
    
    List<CompanyType> getAll();
    
    void remove(Long id);
}
