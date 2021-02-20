package com.dev.core.service.implementation.type;

import com.dev.core.entity.type.AirplaneType;
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
        return  airplaneTypeRepository
                .getAirplaneTypeByType(airplaneType.getType())
                .orElseGet(() -> airplaneTypeRepository.save(airplaneType));
    }
    
    @Override
    public List<AirplaneType> getAll() {
        return airplaneTypeRepository.findAll();
    }
    
    @Override
    public AirplaneType get(Long id) {
        return airplaneTypeRepository.getOne(id);
    }
    
    @Override
    public AirplaneType get(String type) {
        return airplaneTypeRepository.getAirplaneTypeByType(type).orElseThrow();
    }
    
    @Override
    public void remove(Long id) {
        if (airplaneTypeRepository.findById(id).isPresent()) {
            airplaneTypeRepository.deleteById(id);
        }
    }
}
