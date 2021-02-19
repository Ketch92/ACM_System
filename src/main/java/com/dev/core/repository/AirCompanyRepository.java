package com.dev.core.repository;

import com.dev.core.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<Airplane, Long> {
}
