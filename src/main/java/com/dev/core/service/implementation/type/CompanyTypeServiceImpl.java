package com.dev.core.service.implementation.type;

import com.dev.core.entity.type.CompanyType;
import com.dev.core.repository.type.CompanyTypeRepository;
import com.dev.core.service.type.CompanyTypeService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {
    public static final String BIG_COMPANY = "Big company";
    public static final String SMALL_COMPANY = "Small company";
    public static final String LOWCOST_COMPANY = "Low cost";
    public static final String BEGINNER_COMPANY = "Beginner company";
    private final CompanyTypeRepository companyTypeRepository;
    
    public CompanyTypeServiceImpl(CompanyTypeRepository companyTypeRepository) {
        this.companyTypeRepository = companyTypeRepository;
    }
    
    @PostConstruct
    private void injectBasicTypes() {
        companyTypeRepository.save(new CompanyType(BIG_COMPANY));
        companyTypeRepository.save(new CompanyType(SMALL_COMPANY));
        companyTypeRepository.save(new CompanyType(LOWCOST_COMPANY));
        companyTypeRepository.save(new CompanyType(BEGINNER_COMPANY));
    }
    
    @Override
    public CompanyType create(CompanyType companyType) {
        return companyTypeRepository
                .getCompanyTypeByTypeName(companyType.getTypeName())
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
