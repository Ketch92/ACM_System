package com.dev.core.service;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Airplane;
import com.dev.core.entity.type.AirplaneType;
import java.util.List;
import java.util.Set;

public interface AirplaneService {
    
    Airplane create(Airplane airplane);
    
    Airplane get(Long id);
    
    List<Airplane> getByName(String name);
    
    List<Airplane> getByAirCompany(AirCompany airCompany);
    
    List<Airplane> getByType(AirplaneType airplaneType);
    
    List<Airplane> getByIds(Set<Long> ids);
    
    List<Airplane> getAll();
    
    void remove(Long id);
    
    void update(Airplane airplane);
}
