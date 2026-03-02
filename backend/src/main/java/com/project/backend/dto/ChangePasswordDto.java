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
public class ChangePasswordDto {
    
    @NotBlank(message = "New password is required")
    @Pattern(regexp = ValidationPatterns.PASSWORD_PATTERN, 
             message = "Password must be at least 8 characters with uppercase, lowercase, digit and special character")
    private String newPassword;
}

