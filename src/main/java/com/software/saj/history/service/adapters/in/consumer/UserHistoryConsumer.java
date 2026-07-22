package com.software.saj.history.service.adapters.in.consumer;

import com.software.saj.history.service.adapters.in.consumer.mapper.UserHistoryMessageMapper;
import com.software.saj.history.service.adapters.in.consumer.message.UserHistoryMessage;
import com.software.saj.history.service.application.ports.in.InsertUserHistoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHistoryConsumer {

    private final InsertUserHistoryInputPort insertUserHistoryInputPort;
    private final UserHistoryMessageMapper userHistoryMessageMapper;

    @KafkaListener(
            topics = "${kafka.topics.user-events}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "userHistoryMessageKafkaListenerContainerFactory"
    )
    public void consume(UserHistoryMessage message) {
        log.info("Evento do usuário recebido. userId: {} eventType: {}", message.userId(), message.eventType());

        try{
            var domain = userHistoryMessageMapper.toDomain(message);
            insertUserHistoryInputPort.insert(domain);
            log.info("Histórico de usuário registrado com sucesso. userId: {}", message.userId());
        } catch (Exception ex) {
            log.error("Error ao processar evento de usuário. userId: {} erro: {}", message.userId(), ex.getMessage(), ex);
            throw ex;
        }
    }
}
