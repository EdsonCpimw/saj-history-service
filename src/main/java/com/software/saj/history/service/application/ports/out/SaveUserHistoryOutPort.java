package com.software.saj.history.service.application.ports.out;

import com.software.saj.history.service.application.core.domain.UserHistory;

public interface SaveUserHistoryOutPort {

    void save(UserHistory userHistory);
}
