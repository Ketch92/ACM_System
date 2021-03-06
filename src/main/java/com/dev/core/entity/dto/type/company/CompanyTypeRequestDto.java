package com.dev.core.entity.dto.type.company;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyTypeRequestDto {
    @NotNull
    @NotBlank
    private String type;
}
