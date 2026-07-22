package com.software.saj.history.service.adapters.in.consumer.message;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserHistoryMessage(
        UUID userId,
        String userName,
        String userEmail,
        UUID companyId,
        String eventType,
        LocalDateTime occurredAt
) {}
