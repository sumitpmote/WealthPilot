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
@Table(name = "meetings")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", nullable = false)
    private AdvisoryRequest request;

    @ManyToOne(optional = false)
    @JoinColumn(name = "investor_id", nullable = false)
    private User investor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id", nullable = false)
    private User advisor;

    @Column(nullable = false)
    private LocalDateTime scheduledDate;

    @Pattern(regexp = ValidationPatterns.MEETING_LINK_PATTERN, 
             message = "Please provide a valid meeting URL")
    private String meetingLink;

    @Column(nullable = false, length = 20)
    @Pattern(regexp = ValidationPatterns.MEETING_STATUS_PATTERN, 
             message = "Status must be PENDING, CONFIRMED, COMPLETED, or CANCELLED")
    private String status = "PENDING";

    @Column(columnDefinition = "TEXT")
    @Pattern(regexp = ValidationPatterns.DESCRIPTION_PATTERN, 
             message = "Notes must be 10-1000 characters with letters, numbers and basic punctuation")
    private String notes;

    @Column(length = 20)
    @Pattern(regexp = ValidationPatterns.INVESTMENT_DECISION_PATTERN, 
             message = "Investment decision must be BUY, SELL, HOLD, or WAIT")
    private String investmentDecision;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
