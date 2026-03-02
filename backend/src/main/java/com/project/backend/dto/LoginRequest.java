package com.project.backend.dto;

import com.project.backend.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LoginRequest {
    
    @NotBlank(message = "Email is required")
    @Pattern(regexp = ValidationPatterns.EMAIL_PATTERN, 
             message = "Please provide a valid email address")
    private String email;
    
    @NotBlank(message = "Password is required")
    private String password;
}