package com.software.saj.history.service.application.ports.in;

import com.software.saj.history.service.application.core.domain.UserHistory;

public interface InsertUserHistoryInputPort {

    void insert(UserHistory userHistory);
}
