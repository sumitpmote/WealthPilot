package com.project.backend.dto;

import com.project.backend.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    
    @NotBlank(message = "Full name is required")
    @Pattern(regexp = ValidationPatterns.FULL_NAME_PATTERN, 
             message = "Full name must contain only letters and spaces (2-50 characters)")
    private String fullName;
    
    @NotBlank(message = "Email is required")
    @Pattern(regexp = ValidationPatterns.EMAIL_PATTERN, 
             message = "Please provide a valid email address")
    private String email;
}
