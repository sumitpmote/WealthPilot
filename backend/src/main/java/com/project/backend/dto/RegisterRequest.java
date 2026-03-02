package com.project.backend.dto;

import com.project.backend.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class RegisterRequest {
    
    @NotBlank(message = "Full name is required")
    @Pattern(regexp = ValidationPatterns.FULL_NAME_PATTERN, 
             message = "Full name must contain only letters and spaces (2-50 characters)")
    private String fullName;
    
    @NotBlank(message = "Email is required")
    @Pattern(regexp = ValidationPatterns.EMAIL_PATTERN, 
             message = "Please provide a valid email address")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Pattern(regexp = ValidationPatterns.PASSWORD_PATTERN, 
             message = "Password must be at least 8 characters with uppercase, lowercase, digit and special character")
    private String password;
    
    @NotBlank(message = "Role is required")
    @Pattern(regexp = ValidationPatterns.ROLE_PATTERN, 
             message = "Role must be ADMIN, ADVISOR, or INVESTOR")
    private String role;
}