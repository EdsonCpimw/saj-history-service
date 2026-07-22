package com.software.saj.history.service.adapters.in.controller.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StandardError(
        int status,
        String message,
        LocalDateTime timestamp,
        List<FieldErrorDTO> errors

)  {
    public record FieldErrorDTO(
            String field,
            String message
    ){}
}
