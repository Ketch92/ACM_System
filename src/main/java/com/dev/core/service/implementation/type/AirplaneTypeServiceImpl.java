package com.dev.core.service.implementation.type;

import com.dev.core.entity.exception.RequestProcessingException;
import com.dev.core.entity.type.AirplaneType;
import com.dev.core.repository.type.AirplaneTypeRepository;
import com.dev.core.service.type.AirplaneTypeService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class AirplaneTypeServiceImpl implements AirplaneTypeService {
    public static final String BIG = "Big";
    public static final String SMALL = "Small";
    public static final String VIP = "VIP";
    public static final String CARRIAGE = "CARRIAGE";
    
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
    
    @PostConstruct
    private void injectBasicTypes() {
        airplaneTypeRepository.save(new AirplaneType(BIG));
        airplaneTypeRepository.save(new AirplaneType(SMALL));
        airplaneTypeRepository.save(new AirplaneType(VIP));
        airplaneTypeRepository.save(new AirplaneType(CARRIAGE));
    }
    
    @Override
    public List<AirplaneType> getAll() {
        return airplaneTypeRepository.findAll();
    }
    
    @Override
    public AirplaneType get(Long id) {
        return airplaneTypeRepository.findById(id)
                .orElseThrow(() ->
                        new RequestProcessingException("No airplane type with given id " + id));
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
