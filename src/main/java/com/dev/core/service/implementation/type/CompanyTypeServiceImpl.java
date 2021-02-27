package com.dev.core.service.implementation.type;

import com.dev.core.entity.type.CompanyType;
import com.dev.core.exception.RequestProcessingException;
import com.dev.core.repository.type.CompanyTypeRepository;
import com.dev.core.service.type.CompanyTypeService;
import java.util.List;
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
                .getCompanyTypeByTypeName(companyType.getTypeName())
                .orElseGet(() -> companyTypeRepository.save(companyType));
    }
    
    @Override
    public CompanyType get(Long id) {
        return companyTypeRepository.findById(id)
                .orElseThrow(() ->
                        new RequestProcessingException("No company type with given id " + id));
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
