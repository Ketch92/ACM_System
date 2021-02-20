package com.dev.core.service.type;

import com.dev.core.entity.type.AirplaneType;
import java.util.List;
import java.util.Optional;

public interface AirplaneTypeService {
    
    AirplaneType create(AirplaneType airplaneType);
    
    List<AirplaneType> getAll();
    
    AirplaneType get(Long id);
    
    AirplaneType get(String type);
    
    void remove(Long id);
}
