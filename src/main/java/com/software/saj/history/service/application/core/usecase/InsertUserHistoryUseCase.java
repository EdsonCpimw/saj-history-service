package com.software.saj.history.service.application.core.usecase;

import com.software.saj.history.service.application.core.domain.UserHistory;
import com.software.saj.history.service.application.core.exceptions.BusinessException;
import com.software.saj.history.service.application.ports.in.InsertUserHistoryInputPort;
import com.software.saj.history.service.application.ports.out.SaveUserHistoryOutPort;

public class InsertUserHistoryUseCase implements InsertUserHistoryInputPort {

    private final SaveUserHistoryOutPort saveUserHistoryOutPort;

    public InsertUserHistoryUseCase(SaveUserHistoryOutPort saveUserHistoryOutPort) {
        this.saveUserHistoryOutPort = saveUserHistoryOutPort;
    }

    @Override
    public void insert(UserHistory userHistory) {

        if (userHistory.getUserId() == null) {
            throw new BusinessException("O id do usuário é obrigatório");
        }
        if (userHistory.getEventType() == null || userHistory.getEventType().isBlank()) {
            throw new BusinessException("O tipo do evento é obrigatório");
        }

        saveUserHistoryOutPort.save(userHistory);
    }
}
