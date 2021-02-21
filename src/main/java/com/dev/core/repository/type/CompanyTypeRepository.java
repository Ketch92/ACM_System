package com.dev.core.repository.type;

import com.dev.core.entity.type.CompanyType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
    @Query("from CompanyType ct where ct.typeName = :type")
    Optional<CompanyType> getCompanyTypeByTypeName(@Param("type") String type);
}
