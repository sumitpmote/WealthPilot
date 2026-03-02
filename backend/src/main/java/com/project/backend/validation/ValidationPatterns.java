package com.project.backend.validation;

public class ValidationPatterns {
    
    // Email validation - RFC 5322 compliant
    public static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    // Password validation - At least 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special char
    public static final String PASSWORD_PATTERN = 
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    
    // Full name validation - Only letters and spaces, 2-50 characters
    public static final String FULL_NAME_PATTERN = 
        "^[a-zA-Z\\s]{2,50}$";
    
    // Phone number validation - 10 digits
    public static final String PHONE_PATTERN = 
        "^[0-9]{10}$";
    
    // Company name validation - Letters, numbers, spaces, and common punctuation
    public static final String COMPANY_NAME_PATTERN = 
        "^[a-zA-Z0-9\\s\\-&.,()]{2,100}$";
    
    // Sector name validation - Letters and spaces only
    public static final String SECTOR_NAME_PATTERN = 
        "^[a-zA-Z\\s]{2,50}$";
    
    // Risk level validation - Only specific values
    public static final String RISK_LEVEL_PATTERN = 
        "^(LOW|MEDIUM|HIGH)$";
    
    // Investment amount validation - Positive decimal with up to 2 decimal places
    public static final String INVESTMENT_AMOUNT_PATTERN = 
        "^[1-9]\\d*(\\.\\d{1,2})?$";
    
    // Market cap validation - Positive decimal
    public static final String MARKET_CAP_PATTERN = 
        "^[1-9]\\d*(\\.\\d{1,2})?$";
    
    // Expected return validation - Percentage format
    public static final String EXPECTED_RETURN_PATTERN = 
        "^\\d{1,2}(\\.\\d{1,2})?%?$";
    
    // Meeting link validation - URL format
    public static final String MEETING_LINK_PATTERN = 
        "^https?://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-\\.,@?^=%&:/~\\+#]*[\\w\\-\\@?^=%&/~\\+#])?$";
    
    // Report type validation - Specific report types
    public static final String REPORT_TYPE_PATTERN = 
        "^(ANALYSIS|RECOMMENDATION|MARKET_RESEARCH|RISK_ASSESSMENT|PORTFOLIO_REVIEW)$";
    
    // Status validation patterns
    public static final String REQUEST_STATUS_PATTERN = 
        "^(OPEN|PENDING|ASSIGNED|COMPLETED|CANCELLED)$";
    
    public static final String MEETING_STATUS_PATTERN = 
        "^(PENDING|CONFIRMED|COMPLETED|CANCELLED)$";
    
    public static final String USER_STATUS_PATTERN = 
        "^(ACTIVE|INACTIVE|SUSPENDED)$";
    
    // Role validation
    public static final String ROLE_PATTERN = 
        "^(ADMIN|ADVISOR|INVESTOR)$";
    
    // Subject validation for contact messages
    public static final String SUBJECT_PATTERN = 
        "^[a-zA-Z0-9\\s\\-.,!?]{5,100}$";
    
    // Description/Notes validation - Alphanumeric with common punctuation
    public static final String DESCRIPTION_PATTERN = 
        "^[a-zA-Z0-9\\s\\-.,!?()]{10,1000}$";
    
    // Investment decision validation
    public static final String INVESTMENT_DECISION_PATTERN = 
        "^(BUY|SELL|HOLD|WAIT)$";
}