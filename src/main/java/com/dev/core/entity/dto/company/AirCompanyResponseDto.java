package com.dev.core.entity.dto.company;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private String foundedAt;
}
