package com.dev.core.repository;

import com.dev.core.entity.AirCompany;
import com.dev.core.entity.Airplane;
import com.dev.core.entity.type.AirplaneType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirplaneRepository
        extends JpaRepository<Airplane, Long> {
    
    @Query("from Airplane a where a.name = :name")
    List<Airplane> getByName(@Param("name") String name);
    
    @Query("from Airplane a where a.airCompany = :company")
    List<Airplane> getByCompany(@Param("company") AirCompany airCompany);
    
    @Query("from Airplane a where a.airplaneType = :type")
    List<Airplane> getByType(@Param("type") AirplaneType airplaneType);
}
