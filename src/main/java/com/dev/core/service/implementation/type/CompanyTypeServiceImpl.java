package com.dev.core.service.implementation.type;

import com.dev.core.entity.type.CompanyType;
import com.dev.core.repository.type.CompanyTypeRepository;
import com.dev.core.service.type.CompanyTypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {
    
    private final CompanyTypeRepository companyTypeRepository;
    
    public CompanyTypeServiceImpl(CompanyTypeRepository companyTypeRepository) {
        this.companyTypeRepository = companyTypeRepository;
    }
    
    @Override
    public CompanyType create(CompanyType companyType) {
        return companyTypeRepository
                .getCompanyTypeByTypeName(companyType.getType())
                .orElseGet(() -> companyTypeRepository.save(companyType));
    }
    
    @Override
    public CompanyType get(Long id) {
        return companyTypeRepository.getOne(id);
    }
    
    @Override
    public CompanyType get(String type) {
        return companyTypeRepository.getCompanyTypeByTypeName(type).orElseThrow();
    }
    
    @Override
    public List<CompanyType> getAll() {
        return companyTypeRepository.findAll();
    }
    
    @Override
    public void remove(Long id) {
        if (companyTypeRepository.findById(id).isPresent()) {
            companyTypeRepository.deleteById(id);
        }
    }
}
