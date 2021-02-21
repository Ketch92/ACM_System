package com.dev.core.service;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Airplane;
import com.dev.core.entity.type.AirplaneType;
import java.util.List;

public interface AirplaneService {
    
    Airplane create(Airplane airplane);
    
    Airplane get(Long id);
    
    List<Airplane> get(String name);
    
    List<Airplane> get(AirCompany airCompany);
    
    List<Airplane> get(AirplaneType airplaneType);
    
    List<Airplane> getAll();
    
    void remove(Long id);
    
    void update(Airplane airplane);
}
