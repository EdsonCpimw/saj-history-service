package com.software.saj.history.service.adapters.out.repository;

import com.software.saj.history.service.adapters.out.repository.entity.UserHistoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface UserHistoryMongoRepository extends MongoRepository<UserHistoryDocument, String> {

    List<UserHistoryDocument> findByUserId(UUID userId);

    List<UserHistoryDocument> findByCompanyId(UUID companyId);

    List<UserHistoryDocument> findByEventType(String eventType);
}
