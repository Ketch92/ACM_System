package com.dev.core.repository.type;

import com.dev.core.entity.type.AirplaneType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Long> {
    @Query("from AirplaneType at where at.typeName = :type")
    Optional<AirplaneType> getAirplaneTypeByType(@Param("type") String type);
}
