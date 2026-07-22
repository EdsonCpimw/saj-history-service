package com.software.saj.history.service.adapters.in.controller;

import com.software.saj.history.service.adapters.in.controller.mapper.UserHistoryRequestMapper;
import com.software.saj.history.service.adapters.in.controller.request.UserHistoryRequest;
import com.software.saj.history.service.application.ports.in.InsertUserHistoryInputPort;
import com.software.saj.history.service.infrastructure.documentation.api.UserHistoryControllerDocs;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/history/users")
@RequiredArgsConstructor
public class UserHistoryController implements UserHistoryControllerDocs {

    private final InsertUserHistoryInputPort insertUserHistoryInputPort;
    private final UserHistoryRequestMapper userHistoryRequestMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody UserHistoryRequest request) {
        log.info("Recebendo requisição para registrar histórico de usuário. userId: userId: {}", request.userId());

        var domain = userHistoryRequestMapper.toDomain(request);
        domain.setOccurredAt(LocalDateTime.now());

        insertUserHistoryInputPort.insert(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
