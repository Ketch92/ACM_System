package com.dev.core.entity.dto.company;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirCompanyRequestDto {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String companyType;
    private String foundedAt;
}
