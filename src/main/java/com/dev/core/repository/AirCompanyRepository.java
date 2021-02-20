package com.dev.core.repository;

import com.dev.core.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
}
