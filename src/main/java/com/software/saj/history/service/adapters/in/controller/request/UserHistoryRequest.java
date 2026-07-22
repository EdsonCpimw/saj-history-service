package com.software.saj.history.service.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserHistoryRequest(
        @NotNull(message = "Id do usuário é obrigatório")
        UUID userId,
        @NotBlank(message = "Nome do usuário é obrigatório")
        String userName,
        @NotBlank(message = "Email do usuário é obrigatório")
        String userEmail,
        @NotNull(message = "Id da empresa é obrigatório")
        UUID companyId,
        @NotBlank(message = "Tipo de evento é obrigatório")
        String eventType
) {}
