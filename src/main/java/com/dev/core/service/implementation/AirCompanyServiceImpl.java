package com.dev.core.service.implementation;

import com.dev.core.entity.AirCompany;
import com.dev.core.repository.AirCompanyRepository;
import com.dev.core.service.AirCompanyService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    
    private final AirCompanyRepository airCompanyRepository;
    
    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }
    
    @Override
    public AirCompany create(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }
    
    @Override
    public AirCompany get(Long id) {
        return airCompanyRepository.getOne(id);
    }
    
    @Override
    public AirCompany get(String companyName) {
        //TODO
        return null;
    }
    
    @Override
    public List<AirCompany> getAll() {
        return airCompanyRepository.findAll();
    }
    
    @Override
    public void remove(AirCompany airCompany) {
        airCompanyRepository.delete(airCompany);
    }
    
    @Override
    public void update(AirCompany airCompany) {
        airCompanyRepository.save(airCompany);
    }
}
