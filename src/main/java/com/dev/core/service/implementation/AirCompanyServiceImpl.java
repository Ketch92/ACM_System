package com.dev.core.service.implementation;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.exception.RequestProcessingException;
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
        return airCompanyRepository.findById(id)
                .orElseThrow(() ->
                        new RequestProcessingException("No Air company type with given id " + id));
    }
    
    @Override
    public AirCompany get(String companyName) {
        return airCompanyRepository.getByName(companyName).orElseThrow();
    }
    
    @Override
    public List<AirCompany> getAll() {
        return airCompanyRepository.findAll();
    }
    
    @Override
    public void remove(Long id) {
        if (airCompanyRepository.findById(id).isPresent()) {
            airCompanyRepository.deleteById(id);
        }
    }
    
    @Override
    public void update(AirCompany airCompany) {
        if (airCompanyRepository.findById(airCompany.getId()).isPresent()) {
            airCompanyRepository.save(airCompany);
        }
    }
}
