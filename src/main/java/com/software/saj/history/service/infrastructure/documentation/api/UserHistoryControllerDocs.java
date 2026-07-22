package com.software.saj.history.service.infrastructure.documentation.api;

import com.software.saj.history.service.adapters.in.controller.handler.StandardError;
import com.software.saj.history.service.adapters.in.controller.request.UserHistoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Usuários", description = "Endpoints de usuário")
public interface UserHistoryControllerDocs {

    @Operation(
            summary = "Registrar histórico do usuário",
            description = "Registra um novo evento no histórico de um usuário",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserHistoryRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro ao registrar usuário",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StandardError.class),
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "status": 400,
                                                      "message": "O id do usuário é obrigatório",
                                                      "timestamp": "2026-05-30T17:23:30.225002"
                                                    }
                                                    """
                                    )
                            )
                    ),
            }
    )
    @PostMapping
    ResponseEntity<Void> insert(@Valid @RequestBody UserHistoryRequest request);
}
