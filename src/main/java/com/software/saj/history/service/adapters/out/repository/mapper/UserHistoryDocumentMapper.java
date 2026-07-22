package com.software.saj.history.service.adapters.out.repository.mapper;

import com.software.saj.history.service.adapters.out.repository.entity.UserHistoryDocument;
import com.software.saj.history.service.application.core.domain.UserHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserHistoryDocumentMapper {

    UserHistoryDocument toDocument(UserHistory domain);

    UserHistory toDomain(UserHistoryDocument userHistoryDocument);

}
