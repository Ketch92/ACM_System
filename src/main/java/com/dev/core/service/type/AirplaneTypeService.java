package com.dev.core.service.type;

import com.dev.core.entity.type.AirplaneType;
import java.util.List;

public interface AirplaneTypeService {
    
    AirplaneType create(AirplaneType airplaneType);
    
    List<AirplaneType> getAll();
    
    AirplaneType get(Long id);
    
    AirplaneType get(String type);
    
    void remove(Long id);
}
