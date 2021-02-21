package com.dev.core.service.implementation;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Airplane;
import com.dev.core.entity.type.AirplaneType;
import com.dev.core.repository.AirplaneRepository;
import com.dev.core.service.AirplaneService;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    
    private final AirplaneRepository airplaneRepository;
    
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }
    
    @Override
    public Airplane create(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }
    
    @Override
    public Airplane get(Long id) {
        return airplaneRepository.getOne(id);
    }
    
    @Override
    public List<Airplane> get(String name) {
        return airplaneRepository.getByName(name);
    }
    
    @Override
    public List<Airplane> get(AirCompany airCompany) {
        return airplaneRepository.getByCompany(airCompany);
    }
    
    @Override
    public List<Airplane> get(AirplaneType airplaneType) {
        return airplaneRepository.getByType(airplaneType);
    }
    
    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }
    
    @Override
    public List<Airplane> get(Set<Long> ids) {
        return airplaneRepository.getByIds(ids);
    }
    
    @Override
    public void remove(Long id) {
        if (airplaneRepository.findById(id).isPresent()) {
            airplaneRepository.deleteById(id);
        }
    }
    
    @Override
    public void update(Airplane airplane) {
        if (airplaneRepository.findById(airplane.getId()).isPresent()) {
            airplaneRepository.save(airplane);
        }
    }
}
