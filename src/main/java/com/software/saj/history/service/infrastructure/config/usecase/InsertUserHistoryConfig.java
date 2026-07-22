package com.software.saj.history.service.infrastructure.config.usecase;

import com.software.saj.history.service.application.core.usecase.InsertUserHistoryUseCase;
import com.software.saj.history.service.application.ports.out.SaveUserHistoryOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertUserHistoryConfig {

    @Bean
    public InsertUserHistoryUseCase insertUserHistoryUseCase(SaveUserHistoryOutPort saveUserHistoryOutPort) {
        return new InsertUserHistoryUseCase(saveUserHistoryOutPort);
    }
}
