package com.software.saj.history.service.application.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserHistory {

    private String id;
    private UUID userId;
    private String userName;
    private String userEmail;
    private UUID companyId;
    private String eventType;
    private LocalDateTime occurredAt;

    public UserHistory() {}

    public UserHistory(String id, UUID userId, String userName, String userEmail, UUID companyId, String eventType, LocalDateTime occurredAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.companyId = companyId;
        this.eventType = eventType;
        this.occurredAt = occurredAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail ) { this.userEmail = userEmail; }

    public UUID getCompanyId() { return companyId; }
    public void setCompanyId(UUID companyId) { this.companyId = companyId; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public LocalDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }
}
