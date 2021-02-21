package com.dev.core.repository;

import com.dev.core.entity.AirCompany;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    
    @Query("from AirCompany ac where ac.name = :name")
    public Optional<AirCompany> getByName(@Param("name") String name);
}
