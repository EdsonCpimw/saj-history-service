package com.software.saj.history.service.adapters.in.consumer.mapper;

import com.software.saj.history.service.adapters.in.consumer.message.UserHistoryMessage;
import com.software.saj.history.service.application.core.domain.UserHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserHistoryMessageMapper {

    @Mapping(target = "id", ignore = true)
    UserHistory toDomain(UserHistoryMessage message);
}
