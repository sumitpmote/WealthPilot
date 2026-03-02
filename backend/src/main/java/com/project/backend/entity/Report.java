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
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reports")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Report {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", nullable = false)
    private AdvisoryRequest request;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id", nullable = false)
    private User advisor;

    @Column(nullable = false)
    @Pattern(regexp = ValidationPatterns.REPORT_TYPE_PATTERN, 
             message = "Report type must be ANALYSIS, RECOMMENDATION, MARKET_RESEARCH, RISK_ASSESSMENT, or PORTFOLIO_REVIEW")
    private String reportType;

    @Column(nullable = false)
    private String fileUrl;

    @Column(columnDefinition = "TEXT")
    @Pattern(regexp = ValidationPatterns.DESCRIPTION_PATTERN, 
             message = "Summary must be 10-1000 characters with letters, numbers and basic punctuation")
    private String summary;

    @Column(nullable = false)
    private LocalDateTime uploadedAt;

    @PrePersist
    protected void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }
}
