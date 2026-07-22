package com.software.saj.history.service.adapters.out.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "historico_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserHistoryDocument {

    @Id
    private String id;
    @Field("usuario_id")
    private UUID userId;
    @Field("nome_usuario")
    private String userName;
    @Field("email_usuario")
    private String userEmail;
    @Field("empresa_id")
    private UUID companyId;
    @Field("tipo_evento")
    private String eventType;
    @Field("ocorreu_em")
    private LocalDateTime occurredAt;

}
