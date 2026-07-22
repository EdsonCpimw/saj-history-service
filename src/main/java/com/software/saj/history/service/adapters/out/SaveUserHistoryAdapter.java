package com.software.saj.history.service.adapters.out;

import com.software.saj.history.service.adapters.out.repository.UserHistoryMongoRepository;
import com.software.saj.history.service.adapters.out.repository.mapper.UserHistoryDocumentMapper;
import com.software.saj.history.service.application.core.domain.UserHistory;
import com.software.saj.history.service.application.ports.out.SaveUserHistoryOutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveUserHistoryAdapter implements SaveUserHistoryOutPort {

    private final UserHistoryMongoRepository userHistoryMongoRepository;
    private final UserHistoryDocumentMapper userHistoryDocumentMapper;

    @Override
    public void save(UserHistory userHistory) {
        log.info("Salvando histórico de usuário. userId: {} eventType: {}", userHistory.getUserId(), userHistory.getEventType());

        var document = userHistoryDocumentMapper.toDocument(userHistory);
        userHistoryMongoRepository.save(document);

        log.info("Histórico de usuário salvo com sucesso. userId: {}", userHistory.getUserId());

    }
}
