package com.project.backend.entity;

import java.time.LocalDateTime;

import com.project.backend.validation.ValidationPatterns;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Company {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, length = 150)
    @Pattern(regexp = ValidationPatterns.COMPANY_NAME_PATTERN, 
             message = "Company name must be 2-100 characters with letters, numbers, spaces and basic punctuation")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @Column(nullable = false)
    @Pattern(regexp = ValidationPatterns.RISK_LEVEL_PATTERN, 
             message = "Risk level must be LOW, MEDIUM, or HIGH")
    private String riskLevel;
    
    @Column(nullable = false)
    @DecimalMin(value = "0.01", message = "Market cap must be positive")
    private Double marketCap;

    @Column(columnDefinition = "TEXT")
    @Pattern(regexp = ValidationPatterns.DESCRIPTION_PATTERN, 
             message = "Description must be 10-1000 characters with letters, numbers and basic punctuation")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
