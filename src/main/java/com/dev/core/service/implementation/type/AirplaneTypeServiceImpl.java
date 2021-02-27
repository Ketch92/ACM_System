package com.dev.core.service.implementation.type;

import com.dev.core.entity.type.AirplaneType;
import com.dev.core.exception.RequestProcessingException;
import com.dev.core.repository.type.AirplaneTypeRepository;
import com.dev.core.service.type.AirplaneTypeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AirplaneTypeServiceImpl implements AirplaneTypeService {
    
    private final AirplaneTypeRepository airplaneTypeRepository;
    
    public AirplaneTypeServiceImpl(AirplaneTypeRepository airplaneTypeRepository) {
        this.airplaneTypeRepository = airplaneTypeRepository;
    }
    
    @Override
    public AirplaneType create(AirplaneType airplaneType) {
        return airplaneTypeRepository
                .getAirplaneTypeByType(airplaneType.getTypeName())
                .orElseGet(() -> airplaneTypeRepository.save(airplaneType));
    }
    
    @Override
    public List<AirplaneType> getAll() {
        return airplaneTypeRepository.findAll();
    }
    
    @Override
    public AirplaneType getById(Long id) {
        return airplaneTypeRepository.findById(id)
                .orElseThrow(() ->
                        new RequestProcessingException("No airplane type with given id " + id));
    }
    
    public AirplaneType getByType(String type) {
        return airplaneTypeRepository.getAirplaneTypeByType(type).orElseThrow();
    }
    
    @Override
    public void remove(Long id) {
        if (airplaneTypeRepository.findById(id).isPresent()) {
            airplaneTypeRepository.deleteById(id);
        }
    }
}
