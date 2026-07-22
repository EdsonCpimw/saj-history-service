package com.software.saj.history.service.adapters.in.controller.mapper;

import com.software.saj.history.service.adapters.in.controller.request.UserHistoryRequest;
import com.software.saj.history.service.application.core.domain.UserHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserHistoryRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "occurredAt", ignore = true)
    UserHistory toDomain(UserHistoryRequest request);
}
