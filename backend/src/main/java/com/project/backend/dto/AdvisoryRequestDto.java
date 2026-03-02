package com.project.backend.dto;

import com.project.backend.validation.ValidationPatterns;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class AdvisoryRequestDto {
    
    @NotNull(message = "Investment amount is required")
    @DecimalMin(value = "1.0", message = "Investment amount must be at least 1")
    private Double investmentAmount;
    
    @NotBlank(message = "Risk preference is required")
    @Pattern(regexp = ValidationPatterns.RISK_LEVEL_PATTERN, 
             message = "Risk preference must be LOW, MEDIUM, or HIGH")
    private String riskPreference;
    
    @NotBlank(message = "Sector preference is required")
    @Pattern(regexp = ValidationPatterns.SECTOR_NAME_PATTERN, 
             message = "Sector preference must contain only letters and spaces (2-50 characters)")
    private String sectorPreference;
    
    @NotBlank(message = "Description is required")
    @Pattern(regexp = ValidationPatterns.DESCRIPTION_PATTERN, 
             message = "Description must be 10-1000 characters with letters, numbers and basic punctuation")
    private String description;
}

