package com.project.backend.dto;

import com.project.backend.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectorDto {
    private Long sectorId;
    
    @NotBlank(message = "Sector name is required")
    @Pattern(regexp = ValidationPatterns.SECTOR_NAME_PATTERN, 
             message = "Sector name must contain only letters and spaces (2-50 characters)")
    private String sectorName;
}
